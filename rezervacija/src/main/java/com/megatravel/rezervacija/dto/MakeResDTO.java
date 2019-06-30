package com.megatravel.rezervacija.dto;

import java.util.Date;
import java.util.List;

public class MakeResDTO {
    private Date from;
    private Date to;
    private double cost;
    private Long korisnikId;
    private Long sjedinicaId;
    private List<UslugaDTO> services;
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Long getSjedinicaId() {
        return sjedinicaId;
    }

    public void setSjedinicaId(Long sjedinicaId) {
        this.sjedinicaId = sjedinicaId;
    }

    public List<UslugaDTO> getServices() {
        return services;
    }

    public void setServices(List<UslugaDTO> services) {
        this.services = services;
    }
}
