package com.bazepodataka.takmicenje.controller;



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
    public ResponseEntity<Prijava> Prijava(@RequestParam String korisnickoIme, @RequestParam String sifra)
    {
        String korisnikPostoji = korisnikService.daLiPostojiKorisnik(new Korisnik(korisnickoIme, sifra, "", ""));
        if(korisnikPostoji != null)
            return new ResponseEntity<Prijava>(new Prijava(true, korisnickoIme, korisnikPostoji, ""), HttpStatus.OK);
        else
            return  new ResponseEntity<Prijava>(new Prijava(false, "", "", ""), HttpStatus.OK);

    }

    @GetMapping("/odjava")
    public ResponseEntity<String> Odjava()
    {
        httpSession.invalidate();
        return new ResponseEntity<String>("odjava", HttpStatus.OK);
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

    @PostMapping("/obrisi/{id}")
    public ResponseEntity<Boolean> obrisiKorisnika(@PathVariable int id)
    {
        return new ResponseEntity<Boolean>(korisnikService.obrisiKorisnik(id), HttpStatus.OK);
    }

    @PostMapping("/svi/{id}")
    public ResponseEntity<List<Korisnik>> dajSveKorisnik(@PathVariable int id)
    {
        return new ResponseEntity<List<Korisnik>>(korisnikService.dajSveKorisnike(id), HttpStatus.OK);
    }


}
