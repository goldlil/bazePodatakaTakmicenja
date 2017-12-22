package com.bazepodataka.takmicenje.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bazepodataka.takmicenje.entity.Korisnik;


@Transactional
@Repository
public class KorisnikDao {
    @PersistenceContext
    private EntityManager entityManager;


    public boolean postojiKorisnik(String korisinckoIme, String sifra){
        String hq = "FROM Korisnik as k WHERE k.korisnickoIme = ? and k.sifra = ?";
        int count = entityManager.createQuery(hq).setParameter(1, korisinckoIme).setParameter(2, sifra).getResultList().size();

        return count != 0;
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
}
