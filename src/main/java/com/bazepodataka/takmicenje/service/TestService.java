package com.bazepodataka.takmicenje.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bazepodataka.takmicenje.dao.TestDao;
import com.bazepodataka.takmicenje.entity.Test;
import com.bazepodataka.takmicenje.entity.Pitanje;


@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public Test DodajTest(String imeTesta) {
        return testDao.dodajTest(imeTesta);
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
