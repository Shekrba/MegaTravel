package com.megatravel.agent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.megatravel.agent.xml.dto.AccomodationTypeXMLDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AccomodationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @OneToMany(mappedBy = "accomodationType")
    private Set<Smestaj> smestajList = new HashSet<>();

    public AccomodationType() {}


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

    public AccomodationType(AccomodationTypeXMLDTO accXML){
        this.id= accXML.getId();
        this.naziv=accXML.getNaziv();
    }
}
