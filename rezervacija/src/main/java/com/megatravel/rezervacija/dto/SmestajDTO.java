package com.megatravel.rezervacija.dto;

import java.util.Date;
import java.util.List;

public class SmestajDTO {
    private Long id;
    private Long roomId;
    private String naziv;
    private int room;
    private Date from;
    private Date to;
    private int brojKreveta;
    private List<UslugaDTO> services;
    private double cost;


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
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

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public List<UslugaDTO> getServices() {
        return services;
    }

    public void setServices(List<UslugaDTO> services) {
        this.services = services;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
