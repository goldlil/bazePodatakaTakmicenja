package com.bazepodataka.takmicenje.service;

import com.bazepodataka.takmicenje.dao.KorisnikDao;
import com.bazepodataka.takmicenje.entity.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;


import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikDao korisnikDao;

    public boolean dodajKorisnika(Korisnik korisnik){
        if(korisnikDao.slobodnoKorisnickoIme(korisnik.getKorisnickoIme())){
            return false;
        }
        else{
            korisnikDao.dodajKorisnika(korisnik);
            return true;
        }
    }

    public String daLiPostojiKorisnik(Korisnik korisnik)
    {
        return korisnikDao.postojiKorisnik(korisnik.getKorisnickoIme(), korisnik.getSifra());
    }

    public boolean daLiJeSlobodnoKorisnickoIme(String korisnickoIme)
    {
        return korisnikDao.slobodnoKorisnickoIme(korisnickoIme);
    }

    public boolean obrisiKorisnik(int id)
    {
        return korisnikDao.obrisiKorisnika(id);
    }

    public List<Korisnik> dajSveKorisnike(int id)
    {
       return korisnikDao.dajSveKorisnike(id);
    }

    public List<Korisnik> pretragaKorisnika(String rijec)
    {
        return korisnikDao.pretragaKorisnika(rijec);
    }

    public PovratnaPoruka unaprijediKorisnikaOrganizator(int id)
    {
        return korisnikDao.unaprijediKorisnikaOrganizator(id);
    }



}
