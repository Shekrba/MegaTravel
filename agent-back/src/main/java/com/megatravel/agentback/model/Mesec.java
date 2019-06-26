package com.megatravel.agentback.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Mesec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Cenovnik cenovnik;

    @Column(name = "mesecna_cena", unique = false, nullable = false)
    protected double mesecnaCena;

    @Column(name = "mesec", unique = false, nullable = false)
    protected String mesec;

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }

    public void setMesecnaCena(double mesecnaCena) {
        this.mesecnaCena = mesecnaCena;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public Long getId() {
        return id;
    }

    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    public double getMesecnaCena() {
        return mesecnaCena;
    }

    public String getMesec() {
        return mesec;
    }

    public Mesec() {
    }
}
