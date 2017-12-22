package com.bazepodataka.takmicenje.controller;


import jdk.nashorn.internal.ir.ObjectNode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bazepodataka.takmicenje.entity.Korisnik;
import com.bazepodataka.takmicenje.service.KorisnikService;

import javax.servlet.http.HttpSession;
import javax.servlet.http.*;
import java.util.*;
import com.bazepodataka.takmicenje.povratneKlase.Prijava;


@Controller
@RequestMapping("/korisnik")
public class KorisnikContoller {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private  HttpSession httpSession;

    @GetMapping("/prijava")
    public ResponseEntity<Prijava> Prijava(@RequestParam(value = "korisnickoIme") String korisnickoIme, @RequestParam String sifra)
    {
        if(korisnikService.daLiPostojiKorisnik(new Korisnik(korisnickoIme, sifra, "", "")))
            return new ResponseEntity<Prijava>(new Prijava(true, "korisnik", httpSession.getId(), korisnickoIme), HttpStatus.OK);
        else
            return  new ResponseEntity<Prijava>(new Prijava(false, "", "", ""), HttpStatus.OK);

    }

    @GetMapping("/odjava")
    public ResponseEntity<String> Odjava()
    {
        httpSession.invalidate();
        return new ResponseEntity<String>("odjava", HttpStatus.OK);
    }

    @RequestMapping("/proba")
    public ResponseEntity<String> Proba()
    {
         return new ResponseEntity<String>("hi", HttpStatus.OK);
    }
    @PostMapping("registracija")
    public ResponseEntity<Boolean> Registracija(@RequestBody Korisnik k) {
        if (korisnikService.dodajKorisnika(k))
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        else
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }

    @GetMapping("slobodnoKorisnickoIme")
    public ResponseEntity<Boolean> SlobodnoKorisnickoIme(@RequestParam String korisnickoIme)
    {
        boolean x = korisnikService.daLiJeSlobodnoKorisnickoIme(korisnickoIme);
        return new ResponseEntity<Boolean>(x, HttpStatus.OK);

    }

   /* @PostMapping("test")
    public ResponseEntity<Boolean> Test(HttpServletRequest request)//, @RequestParam LinkedList<Korisnik> listaKorisnika)
    {
        String test = request.getParameter("test");
        LinkedList<Korisnik> listaKorisnika = request.getParameter("listaKorisnika");
        System.out.println(test);
        for (Korisnik k: listaKorisnika) {
            System.out.println(k);

        }
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    } */
}
