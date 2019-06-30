package com.megatravel.agent.xml.dto;


import com.megatravel.agent.model.Rezervacija;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RezervacijaXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class RezervacijaXMLDTO {

    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    @XmlJavaTypeAdapter(type=Long.class, value= WSLongAdapter.class)
    private Long id;

    @XmlAttribute(name = "sJedinicaID", required = true)
    @XmlSchemaType(name = "anySimpleType")
    @XmlJavaTypeAdapter(type=Long.class, value= WSLongAdapter.class)
    private Long sJedinicaID;

    private Date datumRez;

    private Date od;

    private Date _do;

    private double uCena;

    private String korisnik;

    private boolean canBeRated;

    private boolean rated;

    private boolean canceled;

    public RezervacijaXMLDTO(Rezervacija rezervacija){
        this._do=rezervacija.get_do();
        this.od=rezervacija.getOd();
        this.canBeRated=rezervacija.isCanBeRated();
        this.canceled=rezervacija.isCanceled();
        this.rated=rezervacija.isRated();
        this.datumRez=rezervacija.getDatumRez();
        this.id=rezervacija.getId();
        this.korisnik=rezervacija.getKorisnik().getUsername();
        this.uCena=rezervacija.getuCena();
        this.sJedinicaID=rezervacija.getSJedinica().getId();
    }

}
