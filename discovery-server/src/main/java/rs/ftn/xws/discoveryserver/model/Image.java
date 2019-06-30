package rs.ftn.xws.discoveryserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Smestaj smestaj;

    @Lob
    private byte[] data;

    public Image() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    public Smestaj getSmestaj() {
        return smestaj;
    }

    @JsonIgnore
    public void setSmestaj(Smestaj smestaj) {
        this.smestaj = smestaj;
    }
}
