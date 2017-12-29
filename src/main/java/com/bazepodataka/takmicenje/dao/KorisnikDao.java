package com.bazepodataka.takmicenje.dao;


import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bazepodataka.takmicenje.service.KorisnikService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bazepodataka.takmicenje.entity.Korisnik;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;


@Transactional
@Repository
public class KorisnikDao {
    @PersistenceContext
    private EntityManager entityManager;


    public String postojiKorisnik(String korisinckoIme, String sifra){
        String hq = "FROM Korisnik as k WHERE k.korisnickoIme = ? and k.sifra = ?";
        List<Korisnik> l = entityManager.createQuery(hq).setParameter(1, korisinckoIme).setParameter(2, sifra).getResultList();
        if(l.size() == 0)
            return "null";
        else return l.get(0).getTipKorisnika();
    }

    public boolean slobodnoKorisnickoIme(String korisinckoIme){
        String hq = "FROM Korisnik as k WHERE k.korisnickoIme = ?";
        int count = entityManager.createQuery(hq).setParameter(1, korisinckoIme).getResultList().size();



        return count != 0;
    }

    public void dodajKorisnika(Korisnik k)
    {
        entityManager.persist(k);
    }

    public boolean obrisiKorisnika(int id)
    {
        try {
            String hq = "FROM Korisnik as k WHERE k.korisnikId = ?";
            Korisnik k = (Korisnik) entityManager.createQuery(hq).setParameter(1, id).getSingleResult();
            entityManager.remove(k);
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Korisnik> dajSveKorisnike(int id)
    {
        String hq = "FROM Korisnik as k WHERE k.korisnikId > ?";
        List<Korisnik> l= entityManager.createQuery(hq).setParameter(1, id).setMaxResults(10).getResultList();
        return l;
    }

    public List<Korisnik> pretragaKorisnika(String rijec)
    {
        try{
            String hq = "FROM Korisnik as k WHERE k.korisnickoIme like ?";
            List<Korisnik> listaKorisnika = (List<Korisnik>) entityManager.createQuery(hq).setParameter(1, rijec + "%").setMaxResults(10).getResultList();
            return listaKorisnika;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public PovratnaPoruka unaprijediKorisnikaOrganizator(int id)
    {
        try{
            String hq = "FROM Korisnik as k WHERE k.korisnikId = ?";
            Korisnik k = (Korisnik) entityManager.createQuery(hq).setParameter(1, id).getSingleResult();
            k.setTipKorisnika("organizator");
            entityManager.persist(k);
            return new PovratnaPoruka();
        }
        catch (Exception e)
        {
            return new PovratnaPoruka(e.getMessage());
        }
    }
}
