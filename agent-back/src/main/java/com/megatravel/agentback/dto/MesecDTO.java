package com.megatravel.agentback.dto;

public class MesecDTO {

    private String mesec;
    private double cena;

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getMesec() {
        return mesec;
    }

    public double getCena() {
        return cena;
    }

    public MesecDTO() {
    }
}
