package rs.ftn.xws.discoveryserver.model;

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

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Smestaj> smestajList = new HashSet<>();

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


    public Set<Smestaj> getSmestajList() {
        return smestajList;
    }

    @JsonIgnore
    public void setSmestajList(Set<Smestaj> smestajList) {
        this.smestajList = smestajList;
    }

    public List<Usluga> getUslugaList() {
        return uslugaList;
    }



    @JsonIgnore
    public void setUslugaList(List<Usluga> uslugaList) {
        this.uslugaList = uslugaList;
    }

    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }
}
