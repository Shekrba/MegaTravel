package com.megatravel.agentback.controller;


import com.megatravel.agentback.client.AgentClient;
import com.megatravel.agentback.dto.*;
import com.megatravel.agentback.model.*;
import com.megatravel.agentback.repository.SmestajRepository;
import com.megatravel.agentback.service.AgentService;
import com.megatravel.agentback.xml.dto.*;
import com.megatravel.agentback.xml.dto.RezervacijaMakeXMLDTO;
import generated.GetTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "api", produces = "application/json;charset=UTF-8")

public class AgentController {

    @Autowired
    AgentService agentService;

    @Autowired
    AgentClient client;


    @RequestMapping(value = "/accomodations",method = RequestMethod.GET)
    public List<SmestajDTO> getSmestaje()
    {
        RezervacijaMakeXMLDTO r=new RezervacijaMakeXMLDTO();
        List<Smestaj> list = agentService.getSmestaje();
        List<SmestajDTO> listDTO = new ArrayList<>();

        for (Smestaj s : list) {
            SmestajDTO sDTO = new SmestajDTO();
            smestajToDto(s, sDTO);
            listDTO.add(sDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/hoteli/{id}", method = RequestMethod.GET)
    public SmestajDTO getSmestaj(@PathVariable("id") Long id) {

        Smestaj smestaj = agentService.getSmestaj(id);
        SmestajDTO smestajDTO = new SmestajDTO();

        smestajToDto(smestaj, smestajDTO);

        return smestajDTO;
    }

    @RequestMapping(value = "/smestajAdd", method = RequestMethod.POST)
    public ResponseEntity<Smestaj> addSJedinica(@RequestBody SmestajDTO smestaj) {

        SmestajXMLDTO x = new SmestajXMLDTO();
        x.setNaziv(smestaj.getNaziv());
        x.setOpis(smestaj.getOpis());
        x.setPeriodOtkaza(smestaj.getPeriodOtkaza());

        AdresaXMLDTO adr = new AdresaXMLDTO();
        adr.setBroj(smestaj.getBroj());
        adr.setBrojStana(smestaj.getBroj());
        adr.setMesto(smestaj.getMesto());
        adr.setUlica(smestaj.getUlica());
        adr.setPosBroj(smestaj.getPosBroj());
        adr.setLatitude(smestaj.getLatitude());
        adr.setLongitude(smestaj.getLongitude());

        x.setAdresa(adr);

        Smestaj addedSmestaj = null;

        try {
            AddAccommodationResponse r = client.addSmestaj(x);
            smestaj.setIdGlBaza(Long.parseLong(r.getAccommodation().getId()));
            addedSmestaj = agentService.addSmestaj(smestaj);
            return new ResponseEntity<Smestaj>(addedSmestaj, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Autowired
    SmestajRepository smestajRepository;


    @PostMapping(value = "/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam("images") MultipartFile[] files, @PathVariable("id") Long id) throws IOException {
        System.out.println(id);

        Smestaj smes=smestajRepository.findOneById(id);
        ImageXMLDTO x = new ImageXMLDTO();
        x.setSmestajID(smes.getIdGlBaza().toString());
        for(MultipartFile file : files){
            byte[] encodeBase64 = Base64.getEncoder().encode(file.getBytes());
            String base64Encoded = new String(encodeBase64, "UTF-8");
            x.getSlike().add(base64Encoded);

        }

        AddImagesResponse r = client.dodajSliku(x);
        agentService.uploadImages(id, files);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "images/{id}", method = RequestMethod.GET)
    List<String> getImages(@PathVariable("id") Long id) throws UnsupportedEncodingException {
        List<String> images = agentService.getImages(id);
        return images;
    }

    @RequestMapping(value = "/smestajUpdate", method = RequestMethod.PUT)
    public ResponseEntity<Smestaj> updateSmestaj(@RequestBody SmestajDTO smestaj) {

        SmestajXMLDTO x = new SmestajXMLDTO();
        x.setNaziv(smestaj.getNaziv());
        x.setOpis(smestaj.getOpis());
        x.setPeriodOtkaza(smestaj.getPeriodOtkaza());

        AdresaXMLDTO adr = new AdresaXMLDTO();
        adr.setBroj(smestaj.getBroj());
        adr.setBrojStana(smestaj.getBroj());
        adr.setMesto(smestaj.getMesto());
        adr.setUlica(smestaj.getUlica());
        adr.setPosBroj(smestaj.getPosBroj());
        adr.setLatitude(smestaj.getLatitude());
        adr.setLongitude(smestaj.getLongitude());

        x.setAdresa(adr);

        Smestaj updatedSmestaj = null;

        try {
            EditAccommodationResponse r = client.editSmestaj(x);
            updatedSmestaj = agentService.updateSmestaj(smestaj);
            return new ResponseEntity<Smestaj>(updatedSmestaj, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<AccomodationType> getTypes() {
        return agentService.getAccTypes();
    }


    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<UslugaDTO> getServices() {
        return agentService.allServices();
    }


    @RequestMapping(value = "/accomodationUnits/{id}", method = RequestMethod.GET)
    public List<SJedinicaDTO> getSveSJedinice(@PathVariable("id") Long id) {
        List<SJedinica> list = agentService.getSveSJedinice(id);
        List<SJedinicaDTO> listDTO = new ArrayList<>();

        for (SJedinica s : list) {
            SJedinicaDTO sDTO = new SJedinicaDTO();
            sJedinicaToDto(s, sDTO);
            listDTO.add(sDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/accomodationUnit/{id}", method = RequestMethod.GET)
    public SJedinicaDTO getSJedinica(@PathVariable("id") Long id) {

        SJedinica sJedinica = agentService.getSJedinica(id);
        SJedinicaDTO sJedinicaDTO = new SJedinicaDTO();

        sJedinicaToDto(sJedinica, sJedinicaDTO);

        return sJedinicaDTO;
    }

    @RequestMapping(value = "/accomodationUnit/{smestajId}", method = RequestMethod.POST)
    public ResponseEntity<SJedinica> addSJedinica(@PathVariable("smestajId") Long smestajId, @RequestBody SJedinicaDTO sJedinica) {


        SJedinicaXMLDTO xdto = new SJedinicaXMLDTO();
        xdto.setBroj(sJedinica.getBroj());
        xdto.setBrojKreveta(sJedinica.getBroj());
        xdto.setCena(sJedinica.getCena());
        xdto.setDostupnost(sJedinica.getDostupnost());
        xdto.setSmestajID(smestajId.toString());

        SJedinica addedSJedinica = null;

        try {
            AddAccommodationUnitResponse r = client.addSJedinica(xdto);
            sJedinica.setIdGlBaza(Long.parseLong(r.getAccommodationUnit().getId()));
            addedSJedinica = agentService.addSJedinica(sJedinica, smestajId);
            return new ResponseEntity<SJedinica>(addedSJedinica, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping(value = "/accomodationUnit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SJedinica> updateSJedinica(@PathVariable("id") Long id, @RequestBody SJedinicaDTO sJedinica) {

        SJedinicaXMLDTO xdto = new SJedinicaXMLDTO();
        xdto.setBroj(sJedinica.getBroj());
        xdto.setBrojKreveta(sJedinica.getBroj());
        xdto.setCena(sJedinica.getCena());
        xdto.setDostupnost(sJedinica.getDostupnost());
        xdto.setSmestajID(sJedinica.getIdSmestaj().toString());

        SJedinica updatedSJedinica = null;

        try {
            EditAccommodationUnitResponse r = client.editSJedinica(xdto);
            updatedSJedinica = agentService.updateSJedinica(sJedinica);
            return new ResponseEntity<SJedinica>(updatedSJedinica, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



    @RequestMapping(value = "/occupancy/{id}",method = RequestMethod.POST)
    public ResponseEntity<Rezervacija> zauzmiSJedinica(@PathVariable("id")Long id, @RequestBody ZauzetostDTO zauzetostDTO){

        RezervacijaMakeXMLDTO re = new RezervacijaMakeXMLDTO();
        re.getFrom().toGregorianCalendar().setTime(zauzetostDTO.getOdDatum());
        re.getTo().toGregorianCalendar().setTime(zauzetostDTO.getDoDatum());
        re.setCost(zauzetostDTO.getCena());
        re.setSjedinicaId(id);
        String g = zauzetostDTO.getDoDatum().toString();



        Rezervacija r = null;

        try {
            MakeReservationResponse res = client.napraviRezervaciju(re);
            zauzetostDTO.setIdGlBaza(res.getReservation().getId());
            r = agentService.zauzmiSJedinicu(id, zauzetostDTO.getOdDatum(), zauzetostDTO.getDoDatum());
            return  new ResponseEntity<Rezervacija>(r, HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/reservations/{id}",method = RequestMethod.GET)
    public List<RezervacijaDTO> getRezervacijeSJedinice(@PathVariable("id")Long id)
    {
        List<Rezervacija> list = agentService.getRezervacijeSJedinice(id);
        List<RezervacijaDTO> listDTO = new ArrayList<>();

        for (Rezervacija r: list) {
            RezervacijaDTO rDTO = new RezervacijaDTO();
            rezervacijaToDto(r,rDTO);
            listDTO.add(rDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/confirmReservation/{id}",method = RequestMethod.PUT)
    public Rezervacija realizovanaRezervacija(@PathVariable("id")Long id)
    {
        Rezervacija r = agentService.realizovanaRezervacija(id);

        return r;
    }

    @RequestMapping(value = "/declineReservation/{id}",method = RequestMethod.PUT)
    public Rezervacija nerealizovanaRezervacija(@PathVariable("id")Long id)
    {
        Rezervacija r = agentService.nerealizovanaRezervacija(id);

        return r;
    }

    @RequestMapping(value = "/messages",method = RequestMethod.GET)
    public List<PorukaDTO> getSvePoruke()
    {
        //List<Poruka> list = agentService.getSvePoruke();

        PollingPorukeResponse po = client.pokupiPoruke();

        List<PorukaXMLDTO> poruke = po.getPoruke();

        List<PorukaDTO> listDTO = new ArrayList<>();

        for(int i=0; i<poruke.size(); i++) {
            PorukaXMLDTO p = poruke.get(i);
            PorukaDTO dto = new PorukaDTO();
            dto.setIdGlBaza(Long.parseLong(p.getId()));
            dto.setPrimalac(p.getPrimalac());
            dto.setPosaljilac(p.getPosiljalac());
            dto.setSadrzaj(p.getSadrzaj());
            dto.setDatumSlanja(new Date());

            listDTO.add(dto);
        }


        return listDTO;
    }

    @RequestMapping(value = "/unansweredMessages",method = RequestMethod.GET)
    public List<PorukaDTO> getNeodgovorenePoruke()
    {
        List<Poruka> list = agentService.getNeodgovorenePoruke();
        List<PorukaDTO> listDTO = new ArrayList<>();

        for (Poruka p: list) {
            PorukaDTO pDTO = new PorukaDTO();
            porukaToDto(p,pDTO);
            listDTO.add(pDTO);
        }

        return listDTO;
    }


    @RequestMapping(value = "/answerMessage/{messageId}",method = RequestMethod.POST)
    public ResponseEntity<Poruka> addSJedinica(@PathVariable("messageId")Long messageId, @RequestBody PorukaDTO poruka){

        PorukaXMLDTO xDTO = new PorukaXMLDTO();
        xDTO.setPosiljalac(poruka.getPosaljilac());
        xDTO.setPrimalac(poruka.getPrimalac());
        xDTO.setSadrzaj(poruka.getSadrzaj());

        Poruka addedPoruka = null;


        try {
            SendPorukaResponse sr = client.posaljiPoruku(xDTO);
            //addedPoruka = agentService.addOdgovor(poruka, messageId);
            return new ResponseEntity<Poruka>(addedPoruka, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping(value = "/message/{id}",method = RequestMethod.GET)
    public PorukaDTO getPoruka(@PathVariable("id")Long id)
    {
        Poruka p = agentService.getPoruka(id);

        PorukaDTO porukaDTO = new PorukaDTO();
        porukaToDto(p, porukaDTO);

        return porukaDTO;
    }


    @RequestMapping(value = "/pricelist/{id}",method = RequestMethod.POST)
    public Cenovnik postaviCenovnikSJedinice(@PathVariable("id")Long id, @RequestBody CenovnikSJediniceDTO cenovnikSJediniceDTO){

        Cenovnik c = null;

        try {
            c = agentService.postaviCenu(cenovnikSJediniceDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }


    public void rezervacijaToDto(Rezervacija r, RezervacijaDTO rDTO) {

        rDTO.setId(r.getId());
        rDTO.setKorisnik(r.getKorisnik());
        rDTO.setuCena(r.getuCena());
        rDTO.setStatusRezervacije(r.getStatusRezervacije());
        rDTO.setDatumRez(r.getDatumRez());
        rDTO.setOd(r.getOd());
        rDTO.set_do(r.get_do());
        rDTO.setIdGlBaza(r.getIdGlBaza());

    }




    public void smestajToDto(Smestaj s, SmestajDTO sDTO){
        sDTO.setId(s.getId());
        sDTO.setNaziv(s.getNaziv());
        sDTO.setOpis(s.getOpis());
        sDTO.setPeriodOtkaza(s.getPeriodOtkaza());
        sDTO.setMesto(s.getAdresa().getMesto());
        sDTO.setBroj(s.getAdresa().getBroj());
        sDTO.setUlica(s.getAdresa().getUlica());
        sDTO.setLatitude(s.getAdresa().getLatitude());
        sDTO.setLongitude(s.getAdresa().getLongitude());
        sDTO.setPosBroj(s.getAdresa().getPosBroj());
        sDTO.setIdGlBaza(s.getIdGlBaza());


        for (Usluga usluga: s.getUslugaList()) {
            UslugaDTO uslugaDTO = new UslugaDTO();
            uslugaDTO.setId(usluga.getId());
            uslugaDTO.setNaziv(usluga.getNaziv());
            uslugaDTO.setCena(usluga.getCena());
            uslugaDTO.setOpis(usluga.getOpis());
            sDTO.getUsluge().add(uslugaDTO);
            sDTO.getAdditionalServices().add(usluga.getId());
        }

        for (SJedinica sj: s.getSJedinica()) {
            SJedinicaDTO sjDTO = new SJedinicaDTO();
            sjDTO.setId(sj.getId());
            sjDTO.setNaziv(sj.getNaziv());
            sjDTO.setBroj(sj.getBroj());
            sjDTO.setBrojKreveta(sj.getBrojKreveta());
            sjDTO.setCena(sj.getCena());
            sjDTO.setIdGlBaza(sj.getIdGlBaza());

            sDTO.getSjedinice().add(sjDTO);
        }

        sDTO.setTip(s.getAccomodationType().getId());

    }

    public void sJedinicaToDto(SJedinica s, SJedinicaDTO sDTO){

        sDTO.setId(s.getId());
        sDTO.setBroj(s.getBroj());
        sDTO.setBrojKreveta(s.getBrojKreveta());
        sDTO.setCena(s.getCena());
        sDTO.setNaziv(s.getNaziv());
        sDTO.setIdGlBaza(s.getIdGlBaza());
    }

    public void porukaToDto(Poruka p, PorukaDTO pDTO) {

        pDTO.setId(p.getId());
        pDTO.setDatumSlanja(p.getDatumSlanja());
        pDTO.setSadrzaj(p.getSadrzaj());
        pDTO.setStatusPoruke(p.getStatusPoruke());
        pDTO.setIdOdgovora(p.getIdOdgovor());
        pDTO.setPosaljilac(p.getPosaljilac());
        pDTO.setPrimalac("Agent");
        pDTO.setNaslov(p.getNaslov());
        pDTO.setIdGlBaza(p.getIdGlBaza());
    }
}
