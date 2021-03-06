package com.megatravel.rezervacija.dto;

import java.util.Date;

public class ReservationDTO {
    private Long id;
    private Long korisnik_id;
    private Long smestaj_id;
    private Long agent_id;
    private String agentUserName;
    private String smestaj_naziv;
    private double cost;
    private Date from;
    private Date to;
    private boolean canCancel;

    public Long getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(Long agent_id) {
        this.agent_id = agent_id;
    }

    public boolean isCanCancel() {
        return canCancel;
    }

    public String getAgentUserName() {
        return agentUserName;
    }

    public void setAgentUserName(String agentUserName) {
        this.agentUserName = agentUserName;
    }

    public void setCanCancel(boolean canCancel) {
        this.canCancel = canCancel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(Long korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public Long getSmestaj_id() {
        return smestaj_id;
    }

    public void setSmestaj_id(Long smestaj_id) {
        this.smestaj_id = smestaj_id;
    }

    public String getSmestaj_naziv() {
        return smestaj_naziv;
    }

    public void setSmestaj_naziv(String smestaj_naziv) {
        this.smestaj_naziv = smestaj_naziv;
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
}
