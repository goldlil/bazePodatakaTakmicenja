package com.bazepodataka.takmicenje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bazepodataka.takmicenje.entity.Test;
import com.bazepodataka.takmicenje.entity.Pitanje;
import com.bazepodataka.takmicenje.service.TestService;

import javax.servlet.http.HttpSession;
import javax.servlet.http.*;
import javax.swing.text.StyledEditorKit;
import java.util.*;
import com.bazepodataka.takmicenje.povratneKlase.Prijava;


@Controller
@RequestMapping("/test")

public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/dodajTest/{imeTesta}")
    ResponseEntity<Test> DodajTest(@PathVariable String imeTesta) {
        return new ResponseEntity<Test>(testService.DodajTest(imeTesta), HttpStatus.OK);
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
}


