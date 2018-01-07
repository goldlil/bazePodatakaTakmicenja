package com.bazepodataka.takmicenje.dao;

import com.bazepodataka.takmicenje.entity.*;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;


@Transactional
@Repository
public class TakmicenjaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Takmicenje kreirajTakmicenje(Takmicenje t) {
        try {
            entityManager.persist(t);
            return t;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Desila se greska pri upisu u bazu");
        }
    }

    public PovratnaPoruka dodajTest(int idTakmicenja, int idTesta)
    {
        try {
            Takmicenje takmicenje = (Takmicenje) entityManager.createQuery("FROM Takmicenje as t WHERE t.takmicenjeId = ?")
                    .setParameter(1, idTakmicenja).getSingleResult();

            Test test = (Test) entityManager.createQuery("FROM Test as t WHERE t.testId = ?")
                    .setParameter(1, idTesta).getSingleResult();

            takmicenje.dodajTest(test);
            entityManager.persist(takmicenje);
            return new PovratnaPoruka();
        }
        catch (NoResultException e)
        {
            return new PovratnaPoruka("Ne mogu se naci objekti sa zadatim id-evima!");
        }
        catch (Exception e)
        {
            return new PovratnaPoruka(e.getMessage());
        }

    }

}
