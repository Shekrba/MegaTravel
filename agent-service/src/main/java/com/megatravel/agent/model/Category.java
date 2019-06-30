package com.megatravel.agent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="naziv", nullable = false)
    private String naziv;

    @Column(name="vrednost", nullable = false)
    private int vrednost;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Smestaj> smestajList = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "category_service",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Usluga> uslugaList = new HashSet<>();

    public Category() {

    }

    public Set<Usluga> getUslugaList() {
        return uslugaList;
    }

    public void setUslugaList(HashSet<Usluga> uslugaList) {
        this.uslugaList = uslugaList;
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


    public Set<Smestaj> getSmestajList() {
        return smestajList;
    }

    @JsonIgnore
    public void setSmestajList(Set<Smestaj> smestajList) {
        this.smestajList = smestajList;
    }



    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }
}
