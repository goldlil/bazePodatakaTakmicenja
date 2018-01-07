package com.bazepodataka.takmicenje.controller;

import com.bazepodataka.takmicenje.entity.Takmicenje;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;
import com.bazepodataka.takmicenje.service.TakmicenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/takmicenje")
public class TakmicenjeController {

    @Autowired
    TakmicenjeService takmicenjeService;

    @PostMapping("/dodaj")
    public ResponseEntity<Takmicenje> dodajTakmicenje(@RequestBody Takmicenje t)
    {
        //System.out.println(t.getDatumPocektaOdrzavanja().toString());
        return new ResponseEntity<Takmicenje>(takmicenjeService.kreirajTakmicenje(t), HttpStatus.OK);
    }

    @GetMapping("dodajTest")
    public ResponseEntity<PovratnaPoruka> dodajTest(@RequestParam int idTakmicenja, @RequestParam int idTesta)
    {
        return new ResponseEntity<PovratnaPoruka>(takmicenjeService.dodajTest(idTakmicenja, idTesta), HttpStatus.OK);
    }

   // @GetMapping("dajSvaTakmicenja")
}
