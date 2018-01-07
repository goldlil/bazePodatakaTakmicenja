package com.bazepodataka.takmicenje.controller;

import com.bazepodataka.takmicenje.entity.Pitanje;
import com.bazepodataka.takmicenje.entity.Test;
import com.bazepodataka.takmicenje.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/dodajTest")
    ResponseEntity<Test> DodajTest(@RequestBody Test t) {
        return new ResponseEntity<Test>(testService.DodajTest(t), HttpStatus.OK);
    }

    @PostMapping("/dodajPitanja")
    ResponseEntity<Boolean> DodajPitanja(@RequestBody List<Pitanje> listaPitanja) {
        return new ResponseEntity<Boolean>(testService.DodajPitanja(listaPitanja), HttpStatus.OK);
    }

    @PostMapping("/obrisiTest/{id}")
    ResponseEntity<Boolean> ObrisiTest(@PathVariable Integer id) {
        return new ResponseEntity<Boolean>(testService.ObrisiTest(id), HttpStatus.OK);
    }

    @PostMapping("/obrisiPitanja")
    ResponseEntity<Boolean> ObrisiPitanja(@RequestBody List<Integer> listaIdeva)
    {
        return new ResponseEntity<Boolean>(testService.IzbrisiPitanja(listaIdeva), HttpStatus.OK);
    }

    @GetMapping("dajTestove")
    ResponseEntity<List<Test>> dajSveTestove(@RequestParam int id)
    {
        return new ResponseEntity<List<Test>>(testService.dajSveTestove(id), HttpStatus.OK);
    }

    @GetMapping("dajPitanjaTesta")
    ResponseEntity<List<Pitanje>> dajPitanjaTesta(@RequestParam int id)
    {
        return new ResponseEntity<List<Pitanje>>(testService.dajPitanjaTesta(id), HttpStatus.OK);
    }
}


