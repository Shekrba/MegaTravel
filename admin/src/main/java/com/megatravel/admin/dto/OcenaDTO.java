package com.megatravel.admin.dto;

import java.util.Date;

public class OcenaDTO {
    private Long ocena_id;
    private int vrednost;
    private String komentar;
    private Long rezervacija_id;
    private Long korisnik_id;
    private Long smestaj_id;
    private Date from;
    private Date to;
    private boolean published;

    public Long getOcena_id() {
        return ocena_id;
    }

    public void setOcena_id(Long ocena_id) {
        this.ocena_id = ocena_id;
    }

    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Long getRezervacija_id() {
        return rezervacija_id;
    }

    public void setRezervacija_id(Long rezervacija_id) {
        this.rezervacija_id = rezervacija_id;
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

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
