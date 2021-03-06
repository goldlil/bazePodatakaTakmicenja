package com.bazepodataka.takmicenje.dao;

import com.bazepodataka.takmicenje.entity.*;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;


@Transactional
@Repository
public class TakmicenjaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private KorisnikDao korisnikDao;

    public Takmicenje kreirajTakmicenje(Takmicenje t) {
        try {
            entityManager.persist(t);
            return t;
        } catch (Exception e) {
            throw new IllegalArgumentException("Desila se greska pri upisu u bazu");
        }
    }

    public PovratnaPoruka dodajTest(int idTakmicenja, int idTesta) {
        try {
            Takmicenje takmicenje = (Takmicenje) entityManager.createQuery("FROM Takmicenje as t WHERE t.takmicenjeId = ?")
                    .setParameter(1, idTakmicenja).getSingleResult();

            Test test = (Test) entityManager.createQuery("FROM Test as t WHERE t.testId = ?")
                    .setParameter(1, idTesta).getSingleResult();

            takmicenje.dodajTest(test);
            entityManager.persist(takmicenje);
            return new PovratnaPoruka();
        } catch (NoResultException e) {
            return new PovratnaPoruka("Ne mogu se naci objekti sa zadatim id-evima!");
        } catch (Exception e) {
            return new PovratnaPoruka(e.getMessage());
        }

    }

    public List<Takmicenje> dajSvaTakmicenja(int id) {
        return (List<Takmicenje>) entityManager.createQuery("FROM Takmicenje AS t WHERE t.takmicenjeId > ?")
                .setParameter(1, id).setMaxResults(10).getResultList();
    }

    public Takmicenje dajTakmicenjePoIdu(int id) {
        return (Takmicenje) entityManager.createQuery("FROM Takmicenje AS t WHERE t.takmicenjeId = ?")
                .setParameter(1, id).getSingleResult();
    }


    public PovratnaPoruka dodajKorisnikaUTakmicenje(int idTakmicenja, int idKorisnika, boolean potvrdjen) {
        try {

            Takmicenje t = dajTakmicenjePoIdu(idTakmicenja);
            Korisnik k = korisnikDao.dajKorisnikaPoIdu(idKorisnika);

            Prijava p = new Prijava(t, k, potvrdjen);
            entityManager.persist(p);
            return new PovratnaPoruka();
        } catch (NoResultException e) {
            return new PovratnaPoruka("Trazeni objekti nisu pronadjeni u bazi!");
        } catch (Exception e) {
            return new PovratnaPoruka(e.getMessage());
        }
    }
}

    /*List<Test> dajTestoveZaTakmicenjeOrganizator(int id)
    {
        return (List<Test>) entityManager.createQuery("FROM Test as t WHERE t.organizator.")
    }*/


