package com.megatravel.admin.service;

import com.megatravel.admin.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements  AdminService{

    @Override
    public Usluga addUsluga(Usluga usluga){
        return new Usluga();
    }

    @Override
    public Usluga deleteUsluga(Long id){
        return new Usluga();
    }

    @Override
    public Usluga updateUsluga(Usluga usluga){
        return new Usluga();
    }

    @Override
    public List<Usluga> getUsluge(){
        return new ArrayList<Usluga>();
    }

    @Override
    public SJedinica setTip(Long id, TTipSmestaja tip){
        return new SJedinica();
    }

    @Override
    public Komentar odobriKomentar(Long id){
        return new Komentar();
    }

    @Override
    public TKorisnik blockKorisnik(Long id){
        return new TRegKorisnik();
    }

    @Override
    public TKorisnik activatKorisnik(Long id){
        return new TRegKorisnik();
    }

    @Override
    public TKorisnik deleteKorisnik(Long id){
        return new TRegKorisnik();
    }

    @Override
    public TKorisnik addAgent(TAgent agent){
        return new TAdmin();
    }
}
