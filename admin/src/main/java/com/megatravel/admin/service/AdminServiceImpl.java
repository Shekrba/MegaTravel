package com.megatravel.admin.service;

import com.megatravel.admin.dto.*;
import com.megatravel.admin.model.*;
import com.megatravel.admin.repository.*;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements  AdminService{

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SmestajRepository smestajRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    AccomodationTypeRepository accomodationTypeRepository;

    @Override
    public List<Usluga> getUsluge() {
        return uslugaRepository.findAll();
    }

    @Override
    public Usluga addUsluga(UslugaDTO usluga){
        Usluga saveUsluga = new Usluga();
        saveUsluga.setCena(usluga.getCena());
        saveUsluga.setNaziv(usluga.getNaziv());
        saveUsluga.setOpis(usluga.getOpis());
        return uslugaRepository.save(saveUsluga);
    }

    @Override
    public String deleteUsluga(Long id){
        uslugaRepository.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public Usluga updateUsluga(UslugaDTO usluga, Long id){
        Usluga updateUsluga = uslugaRepository.findOneById(id);
        updateUsluga.setCena(usluga.getCena());
        updateUsluga.setNaziv(usluga.getNaziv());
        updateUsluga.setOpis(usluga.getOpis());
        return uslugaRepository.save(updateUsluga);
    }

    @Override
    public UslugaDTO getUsluga(Long id) {
        Usluga usluga = uslugaRepository.findOneById(id);
        UslugaDTO uslugaDTO = new UslugaDTO();
        uslugaDTO.setOpis(usluga.getOpis());
        uslugaDTO.setNaziv(usluga.getNaziv());
        uslugaDTO.setCena(usluga.getCena());
        uslugaDTO.setId(usluga.getId());
        return  uslugaDTO;
    }

    @Override
    public AdminDTO addAdmin(AdminDTO adminDTO) {
        User user = new User();
        user.setPrezime(adminDTO.getPrezime());
        user.setIme(adminDTO.getIme());
        user.setUsername(adminDTO.getUsername());
        user.setStatus(UserStatus.ACTIVE);
        Authority authority = authorityRepository.findOneByName("ROLE_AGENT");
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authority);
        user.setAuthorities(authorities);

        user = userRepository.save(user);
        adminDTO.setId(user.getId());
        adminDTO.setStatus(UserStatus.ACTIVE);
        return adminDTO;
    }

    @Override
    public User blockKorisnik(Long id){
        User user = userRepository.findOneById(id);
        user.setStatus(UserStatus.BLOCKED);
        return userRepository.save(user);
    }

    @Override
    public User activateKorisnik(Long id){
        User user = userRepository.findOneById(id);
        user.setStatus(UserStatus.ACTIVE);
        return userRepository.save(user);
    }

    @Override
    public User deleteKorisnik(Long id) {
        User user = userRepository.findOneById(id);
        user.setStatus(UserStatus.REMOVED);
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getKorisnike(){
        List<User> users = userRepository.findAllNonRemoved();
        List<UserDTO> usersDTO = new ArrayList<>();

        for (User u: users) {
            UserDTO uDTO = new UserDTO();
            uDTO.setId(u.getId());
            uDTO.setUsername(u.getUsername());
            uDTO.setStatus(u.getStatus());

            usersDTO.add(uDTO);
        }

        return usersDTO;
    }

    @Override
    public User addAgent(AgentDTO agent){
        User newUser = new User();
        newUser.setAdresa(agent.getAdresa());
        newUser.setStatus(UserStatus.ACTIVE);
        newUser.setIme(agent.getIme());
        newUser.setPosMatBroj(agent.getPosMatBroj());
        newUser.setPrezime(agent.getPrezime());
        newUser.setEmail(agent.getEmail());
        Authority authority = authorityRepository.findOneByName("ROLE_AGENT");
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authority);
        newUser.setAuthorities(authorities);

        return userRepository.save(newUser);
    }

    @Override
    public Smestaj addAccomodation(SmestajDTO smestaj) {
        Smestaj accomodation = new Smestaj();
        accomodation.setNaziv(smestaj.getNaziv());
        accomodation.setAdresa(smestaj.getAdresa());
        accomodation.setOpis(smestaj.getOpis());
        AccomodationType type = accomodationTypeRepository.findOneById(smestaj.getTipSmestaja());
        accomodation.setAccomodationType(type);
        accomodation.setPeriodOtkaza(smestaj.getPeriodOtkaza());
        List<Usluga> uslugaList = uslugaRepository.findAllById(smestaj.getAdditionalServices());
        accomodation.setUsluge(uslugaList);
        setCategoryForAccomodation(accomodation);

        return smestajRepository.save(accomodation);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public String setServicesForCategory(Long id, List<Long> services) {
        Category category = categoryRepository.findOneById(id);
        List<Usluga> foundServices = uslugaRepository.findAllById(services);
        category.setUslugaList(foundServices);
        categoryRepository.save(category);

        List<Smestaj> smestajList = smestajRepository.findAll();
        for(Smestaj smestaj : smestajList)
        {
            setCategoryForAccomodation(smestaj);
            smestajRepository.save(smestaj);
        }


        return "Change success!";
    }

    @Override
    public void setCategoryForAccomodation(Smestaj smestaj) {
        List<Category> categories = categoryRepository.findAll();
        List<Category> foundCategories = new ArrayList<>();
        for(Category category: categories)
        {
            List<Usluga> categoryServices = category.getUslugaList();
            List<Usluga> accomodationServices = smestaj.getUsluge();
            if(accomodationServices.size() >= categoryServices.size())
            {
                boolean isOk = true;
                if(categoryServices.size() == 0)
                    isOk = false;
                for(Usluga categoryService : categoryServices)
                {

                    boolean foundService = false;
                    for(Usluga accomodationService : accomodationServices)
                    {
                        if(accomodationService.getId() == categoryService.getId()) {
                            foundService = true;
                            break;
                        }
                    }
                    if(!foundService) {
                        isOk = false;
                        break;
                    }
                }
                if(isOk)
                    foundCategories.add(category);
            }
        }
        if(foundCategories.size() > 0){
            smestaj.setCategory(foundCategories.get(0));
            for(Category category : foundCategories){
                if(category.getVrednost() > smestaj.getCategory().getVrednost())
                    smestaj.setCategory(category);
            }
        }
        else
        {
            smestaj.setCategory(null);
        }
    }

    @Override
    public List<AccTypeDTO> getAccomodationTypes() {

        List<AccomodationType> accomodationTypes = accomodationTypeRepository.findAll();
        List<AccTypeDTO> retDtos = new ArrayList<>();
        for(AccomodationType accomodationType: accomodationTypes){
            retDtos.add(new AccTypeDTO(accomodationType.getId(),accomodationType.getNaziv()));
        }
        return retDtos;
    }

    @Override
    public AccTypeDTO addAcomodationType(AccTypeDTO accTypeDTO) {
        AccomodationType accomodationType = new AccomodationType();
        accomodationType.setNaziv(accTypeDTO.getNaziv());
        accomodationType = accomodationTypeRepository.save(accomodationType);
        AccTypeDTO retDto = new AccTypeDTO(accomodationType.getId(), accomodationType.getNaziv());
        return retDto;
    }

    @Override
    public String deleteType(Long id){

        List<AccomodationType> act = accomodationTypeRepository.findAllNonSmestaj();

        for (AccomodationType a: act) {
            if(a.getId() == id){
                accomodationTypeRepository.deleteById(id);
                return "Deleted successfully";
            }
        }

        return "Can not delete type. It is contained in one or more accommodations";
    }
}
