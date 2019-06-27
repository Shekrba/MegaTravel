package com.megatravel.agentback.dto;

import java.time.LocalDate;
import java.util.List;

public class CenovnikSJediniceDTO {

    private Long idSJedinice;
    private List<MesecDTO> listaMeseca;

    public void setIdSJedinice(Long idSJedinice) {
        this.idSJedinice = idSJedinice;
    }

    public void setListaMeseca(List<MesecDTO> meseci) {
        this.listaMeseca = meseci;
    }

    public Long getIdSJedinice() {
        return idSJedinice;
    }

    public List<MesecDTO> getListaMeseca() {
        return listaMeseca;
    }

    public CenovnikSJediniceDTO() {
    }
}
