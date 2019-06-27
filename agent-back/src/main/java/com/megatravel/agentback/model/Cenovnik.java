package com.megatravel.agentback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cenovnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected SJedinica sJedinica;

    @OneToMany(mappedBy = "cenovnik")
    protected List<Mesec> listaMeseca;

    public void setListaMeseca(List<Mesec> listaMeseca) {
        this.listaMeseca = listaMeseca;
    }

    public List<Mesec> getListaMeseca() {
        return listaMeseca;
    }

    @JsonIgnore
    public void setsJedinica(SJedinica sJedinica) {
        this.sJedinica = sJedinica;
    }

    public SJedinica getsJedinica() {
        return sJedinica;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Cenovnik() {
    }


}
