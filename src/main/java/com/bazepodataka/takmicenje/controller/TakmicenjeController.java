package com.bazepodataka.takmicenje.controller;

import com.bazepodataka.takmicenje.entity.Takmicenje;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;
import com.bazepodataka.takmicenje.povratneKlase.PrijavaKorisnika;
import com.bazepodataka.takmicenje.service.TakmicenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/takmicenje")
public class TakmicenjeController {

    @Autowired
    TakmicenjeService takmicenjeService;

    @Autowired
    private HttpSession httpSession;

    @PostMapping("/dodaj")
    public ResponseEntity<Takmicenje> dodajTakmicenje(@RequestBody Takmicenje t)
    {
        PrijavaKorisnika p = (PrijavaKorisnika) httpSession.getAttribute("korisnik");
        int id = Integer.parseInt(p.getId());
        return new ResponseEntity<Takmicenje>(takmicenjeService.kreirajTakmicenje(t), HttpStatus.OK);
    }

    @GetMapping("dodajTest")
    public ResponseEntity<PovratnaPoruka> dodajTest(@RequestParam int idTakmicenja, @RequestParam int idTesta)
    {
        return new ResponseEntity<PovratnaPoruka>(takmicenjeService.dodajTest(idTakmicenja, idTesta), HttpStatus.OK);
    }

    @GetMapping("dajSvaTakmicenja")
    public ResponseEntity<List<Takmicenje>> dajSvaTakmicenja(@RequestParam int id)
    {
        return new ResponseEntity<List<Takmicenje>>(takmicenjeService.dajSvaTakmicenja(id), HttpStatus.OK);
    }

    /*@GetMapping("dajTestoveZaTakmicenjeOrganizator")
    public ResponseEntity<List<Test>> dajTestoveZaTakmicenjeOrganizator(@RequestParam int id)
    {

        return new ResponseEntity<List<Test>>(takmicenjeService.dajTestoveZaTakmicenjeOrganizator(id), HttpStatus.OK);
    }*/
}
