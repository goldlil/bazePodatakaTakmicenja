package com.bazepodataka.takmicenje.service;

import com.bazepodataka.takmicenje.dao.TestDao;
import com.bazepodataka.takmicenje.entity.Pitanje;
import com.bazepodataka.takmicenje.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public Test DodajTest(Test t) {
        return testDao.dodajTest(t);
    }

    public boolean DodajPitanja(List<Pitanje> l){
        return testDao.dodajPitanja(l);
    }

    public boolean IzbrisiPitanja(List<Integer> l) {
        return testDao.obrisiPitanje(l);
    }

    public List<Test> PretragaTestova(String test){
        return testDao.pretragaTesta(test);
    }

    public boolean ObrisiTest(int id){
        return testDao.obrisiTest(id);
    }
}
