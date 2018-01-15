package com.bazepodataka.takmicenje.service;


import com.bazepodataka.takmicenje.dao.TakmicenjaDao;
import com.bazepodataka.takmicenje.entity.Takmicenje;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TakmicenjeService {
    @Autowired
    private TakmicenjaDao takmicenjaDao;

    public Takmicenje kreirajTakmicenje(Takmicenje t)
    {
        return takmicenjaDao.kreirajTakmicenje(t);
    }

    public PovratnaPoruka dodajTest(int idTakmicenja, int idTesta)
    {
        return takmicenjaDao.dodajTest(idTakmicenja, idTesta);
    }

    public List<Takmicenje> dajSvaTakmicenja(int id)
    {
        return takmicenjaDao.dajSvaTakmicenja(id);
    }

    /*public List<Takmicenje> dajTestoveZaTakmicenjeOrganizator(int id)
    {
        return takmicenjaDao.dajTestoveZaTakmicenjeOrganizator(int id);
    }*/
}
