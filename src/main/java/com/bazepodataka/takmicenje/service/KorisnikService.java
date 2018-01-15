package com.bazepodataka.takmicenje.service;

import com.bazepodataka.takmicenje.dao.KorisnikDao;
import com.bazepodataka.takmicenje.entity.Korisnik;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;
import com.bazepodataka.takmicenje.povratneKlase.PrijavaKorisnika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikDao korisnikDao;

    @Autowired
    private HttpSession httpSession;

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
        if(!korisnikDao.slobodnoKorisnickoIme(korisnickoIme))
            return new PovratnaPoruka("Korisnicko ime nije slobodno");
        return korisnikDao.promjeniKorisnickoIme(id, korisnickoIme);
    }

    public PovratnaPoruka promjeniSifru(int id, String sifra)
    {
        return korisnikDao.promjeniSifru(id, sifra);
    }

    public PrijavaKorisnika prijava(String korisnickoIme, String sifra)
    {
        try {
            Korisnik k = korisnikDao.dajKorisnikaPoKorisnickomImenu(korisnickoIme);
            System.out.println(k.getSifra() + " - " + sifra);
            if(k.getSifra().equals(sifra)) {

                return new PrijavaKorisnika(true, k.getKorisnickoIme(), k.getTipKorisnika(), Integer.toString(k.getKorisnikId()));
            }
            else
                return new PrijavaKorisnika(false, "Pogresna sifra", "", "");

        }
        catch (Exception e)
        {
            return new PrijavaKorisnika(false, "Pogresan username", "", "");
        }
    }

    public PrijavaKorisnika dajPrijavljenogKorisnika()
    {
        try{
            return (PrijavaKorisnika) httpSession.getAttribute("korisnik");
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Nemate pravo pristupa!");
        }
    }

    public boolean daLiJeKorisnik()
    {
        try{
            return httpSession.getAttribute("korisnik") != null;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Nemate pravo pristupa!");
        }
    }

   /* public PrijavaKorisnika dajPrijavljenogKorisnika()
    {
        try{
            return (PrijavaKorisnika) httpSession.getAttribute("korisnik");
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Nemate pravo pristupa!");
        }
    }*/


}
