package com.megatravel.admin.service;

import com.megatravel.admin.model.*;

import java.util.List;

public interface AdminService {
    public Usluga addUsluga(Usluga usluga);
    public Usluga deleteUsluga(Long id);
    public Usluga updateUsluga(Usluga usluga);
    public List<Usluga> getUsluge();
    public SJedinica setTip(Long id, TTipSmestaja tip);
    public Komentar odobriKomentar(Long id);
    public TKorisnik blockKorisnik(Long id);
    public TKorisnik activatKorisnik(Long id);
    public TKorisnik deleteKorisnik(Long id);
    public TKorisnik addAgent(TAgent agent);
}
