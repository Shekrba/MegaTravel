package com.megatravel.rezervacija.dto;

public class CommentDTO {

    private Long id;
    private String tekst;
    private Long smestajId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Long getSmestajId() {
        return smestajId;
    }

    public void setSmestajId(Long smestajId) {
        this.smestajId = smestajId;
    }
}
