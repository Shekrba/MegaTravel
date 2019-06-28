package com.megatravel.rezervacija.model;

import javax.persistence.*;

@Entity
public class Poruka {

        @Column(name = "sadrzaj", unique = false, nullable = false)
        private String sadrzaj;

        @ManyToOne(fetch = FetchType.EAGER)
        private User posiljalac;

        @ManyToOne(fetch = FetchType.EAGER)
        private User primalac;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

       public Poruka(){

       }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public User getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(User posiljalac) {
        this.posiljalac = posiljalac;
    }

    public User getPrimalac() {
        return primalac;
    }

    public void setPrimalac(User primalac) {
        this.primalac = primalac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
