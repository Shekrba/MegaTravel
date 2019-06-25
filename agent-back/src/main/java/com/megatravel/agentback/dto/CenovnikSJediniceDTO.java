package com.megatravel.agentback.dto;

import java.time.LocalDate;

public class CenovnikSJediniceDTO {

    private LocalDate datumOd;
    private LocalDate datumDo;
    private double cena;


    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }


    public LocalDate getDatumOd() {
        return datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public double getCena() {
        return cena;
    }


    public CenovnikSJediniceDTO() {
    }
}
