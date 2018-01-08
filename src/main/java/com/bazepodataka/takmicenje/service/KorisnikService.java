package com.bazepodataka.takmicenje.service;

import com.bazepodataka.takmicenje.dao.KorisnikDao;
import com.bazepodataka.takmicenje.entity.Korisnik;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;
import com.bazepodataka.takmicenje.povratneKlase.Prijava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikDao korisnikDao;

    public PovratnaPoruka dodajKorisnika(Korisnik korisnik){
        if(!korisnikDao.slobodnoKorisnickoIme(korisnik.getKorisnickoIme())){
            return new PovratnaPoruka("Postoji korisnik sa odabranim korisnickim imenom!");
        }
        else{
            return korisnikDao.dodajKorisnika(korisnik);
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

    public List<Korisnik> dajSveKorisnike(int id, String tip)
    {
       return korisnikDao.dajSveKorisnike(id, tip);
    }

    public List<Korisnik> pretragaKorisnika(String rijec)
    {
        return korisnikDao.pretragaKorisnika(rijec);
    }

    public PovratnaPoruka unaprijediKorisnikaOrganizator(int id)
    {
        return korisnikDao.unaprijediKorisnikaOrganizator(id);
    }

    public PovratnaPoruka degradirajOrganizatora(int id)
    {
        return korisnikDao.degradirajOrganizatora(id);
    }

    public PovratnaPoruka promjeniKorisnickoIme(int id, String korisnickoIme)
    {
        if(korisnikDao.slobodnoKorisnickoIme(korisnickoIme))
            return new PovratnaPoruka("Korisnicko ime nije slobodno");
        return korisnikDao.promjeniKorisnickoIme(id, korisnickoIme);
    }

    public PovratnaPoruka promjeniSifru(int id, String sifra)
    {
        return korisnikDao.promjeniSifru(id, sifra);
    }

    public Prijava prijava(String korisnickoIme, String sifra)
    {
        try {
            Korisnik k = korisnikDao.dajKorisnikaPoKorisnickomImenu(korisnickoIme);
            System.out.println(k.getSifra() + " - " + sifra);
            if(k.getSifra().equals(sifra))
                return new Prijava(true, k.getKorisnickoIme(), k.getTipKorisnika(), Integer.toString(k.getKorisnikId()));
            else
                return new Prijava(false, "Pogresna sifra", "", "");

        }
        catch (Exception e)
        {
            return new Prijava(false, "Pogresan username", "", "");
        }
    }


}
