package com.megatravel.admin.service;

import com.megatravel.admin.dto.*;
import com.megatravel.admin.model.*;

import java.util.List;

public interface AdminService {


    public Usluga addUsluga(UslugaDTO usluga);
    public String deleteUsluga(Long id);
    public Usluga updateUsluga(UslugaDTO usluga, Long id);
    public UslugaDTO getUsluga(Long id);
    public List<Usluga> getUsluge();

    public AdminDTO addAdmin(AdminDTO adminDTO);
    public User blockKorisnik(Long id);
    public User activateKorisnik(Long id);
    public User deleteKorisnik(Long id);
    public User addAgent(AgentDTO agent);
    public List<UserDTO> getKorisnike();

    public Smestaj addAccomodation(SmestajDTO smestaj);
    public List<Category> getCategories();
    public String setServicesForCategory(Long id, List<Long> services);

    public void setCategoryForAccomodation(Smestaj smestaj);

    public List<AccTypeDTO> getAccomodationTypes();
    public AccTypeDTO addAcomodationType(AccTypeDTO accTypeDTO);
    public String deleteType(Long id);

    public String getUsername(Long id);
    public String getSmestajNaziv(Long id);
}
