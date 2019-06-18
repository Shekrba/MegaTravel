package com.megatravel.admin.service;

import com.megatravel.admin.dto.AccTypeDTO;
import com.megatravel.admin.dto.AgentDTO;
import com.megatravel.admin.dto.SmestajDTO;
import com.megatravel.admin.dto.UslugaDTO;
import com.megatravel.admin.model.*;

import java.util.List;

public interface AdminService {


    public Usluga addUsluga(UslugaDTO usluga);
    public String deleteUsluga(Long id);
    public Usluga updateUsluga(UslugaDTO usluga, Long id);
    public List<Usluga> getUsluge();
    public SJedinica setTip(Long id, TTipSmestaja tip);
    public Komentar odobriKomentar(Long id);
    public List<Komentar> getUnapprovedComments();
    public User blockKorisnik(Long id);
    public User activateKorisnik(Long id);
    public User deleteKorisnik(Long id);
    public User addAgent(AgentDTO agent);

    public Smestaj addAccomodation(SmestajDTO smestaj);
    public List<Category> getCategories();
    public String setServicesForCategory(Long id, List<Long> services);

    public void setCategoryForAccomodation(Smestaj smestaj);

    public List<AccTypeDTO> getAccomodationTypes();
    public AccTypeDTO addAcomodationType(AccTypeDTO accTypeDTO);

}
