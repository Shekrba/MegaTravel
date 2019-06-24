package com.megatravel.agent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    private List<Smestaj> smestajList = new ArrayList<>();



    public Category() {

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


    public List<Smestaj> getSmestajList() {
        return smestajList;
    }

    @JsonIgnore
    public void setSmestajList(List<Smestaj> smestajList) {
        this.smestajList = smestajList;
    }



    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }
}
