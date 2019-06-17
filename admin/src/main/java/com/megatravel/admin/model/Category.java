package com.megatravel.admin.model;

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

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Smestaj> smestajList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "category_service",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Usluga> uslugaList = new ArrayList<>();

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
}
