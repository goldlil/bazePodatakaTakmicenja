package com.bazepodataka.takmicenje.dao;



import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bazepodataka.takmicenje.service.KorisnikService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bazepodataka.takmicenje.entity.Korisnik;
import com.bazepodataka.takmicenje.entity.Test;
import com.bazepodataka.takmicenje.entity.Pitanje;

@Transactional
@Repository
public class TestDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Test dodajTest(Test t)
    {
        try {
            if (t.getImeTesta().length() == 0) {
                throw new IllegalArgumentException("Ime testa ne smije biti prazno");
            }
            entityManager.persist(t);
            return t;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public boolean dodajPitanja(List<Pitanje> listaPitanja)
    {
        try{
            Test t = listaPitanja.get(0).getIdTesta();
            int id = t.getTestId();
            String hq = "FROM Test as t WHERE t.testId = ?";
            List<Test> l = entityManager.createQuery(hq).setParameter(1, id).getResultList();
            if(l.size() == 0)
                throw  new IllegalArgumentException("Id testa ne postoji");

            for (Pitanje p : listaPitanja) {
                entityManager.persist(p);
            }
            return true;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean obrisiPitanje(List<Integer> listaIdeva) {
        try {

            String hq = "FROM Pitanje as p WHERE p.idPitanja IN ?";
            List<Pitanje> l = entityManager.createQuery(hq).setParameter(1, listaIdeva).getResultList();
            for(Pitanje p : l){
                entityManager.remove(p);
            }
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean obrisiTest(int id){
        try{
            Test t = (Test) entityManager.createQuery("FROM Test as p WHERE p.idTest = ?").setParameter(1, id).getSingleResult();
            entityManager.remove(t);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public List<Test> pretragaTesta(String test){
        try{
            String hq = "FROM Test as t WHERE t.imeTesta like ?";
            List<Test> listaTestova = (List<Test>) entityManager.createQuery(hq).setParameter(1, test + "%").setMaxResults(10).getResultList();
            return listaTestova;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Test> dajSveTestove(int id)
    {
        List<Test> l = (List<Test>) entityManager.createQuery("FROM Test as t WHERE t.testId > ?")
                .setParameter(1,id).setMaxResults(10).getResultList();
        return l;
    }

    public List<Pitanje> dajPitanjaTesta(int id)
    {
        List<Pitanje> lp = (List<Pitanje>) entityManager.createQuery("FROM Pitanje as p WHERE p.idTesta.testId = ?")
                .setParameter(1,id).getResultList();
        return lp;
    }
}
