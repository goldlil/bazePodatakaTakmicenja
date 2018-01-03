package com.bazepodataka.takmicenje.controller;



import com.bazepodataka.takmicenje.entity.Korisnik;
import com.bazepodataka.takmicenje.povratneKlase.PovratnaPoruka;
import com.bazepodataka.takmicenje.povratneKlase.Prijava;
import com.bazepodataka.takmicenje.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
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
        if(korisnikPostoji != "null")
            return new ResponseEntity<Prijava>(new Prijava(true, korisnickoIme, korisnikPostoji, ""), HttpStatus.OK);
        else
            return  new ResponseEntity<Prijava>(new Prijava(false, "", "", ""), HttpStatus.OK);

    }

    @CrossOrigin(origins =  "http://localhost:3000")
    @GetMapping("/odjava")
    public ResponseEntity<String> Odjava()
    {
        httpSession.invalidate();
        return new ResponseEntity<String>("odjava", HttpStatus.OK);
    }

    @PostMapping("registracija")
    public ResponseEntity<PovratnaPoruka> Registracija(@RequestBody Korisnik k) {
        return new ResponseEntity<PovratnaPoruka>(korisnikService.dodajKorisnika(k), HttpStatus.OK);

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
        return new ResponseEntity<List<Korisnik>>(korisnikService.dajSveKorisnike(id, "korisnik"), HttpStatus.OK);
    }

    @PostMapping("/sviOrganizatori/{id}")
    public ResponseEntity<List<Korisnik>> dajSveOrganizatore(@PathVariable int id)
    {
        return new ResponseEntity<List<Korisnik>>(korisnikService.dajSveKorisnike(id, "organizator"), HttpStatus.OK);
    }

    @PostMapping("/pretraga/{rijec}")
    public ResponseEntity<List<Korisnik>> pretragaKorisnika(@PathVariable String rijec)
    {
        return new ResponseEntity<List<Korisnik>>(korisnikService.pretragaKorisnika(rijec), HttpStatus.OK);
    }

    @PostMapping("promocijaOrganizator/{id}")
    public ResponseEntity<PovratnaPoruka> unaprijediKorisnikaOrganizator(@PathVariable int id)
    {
        return new ResponseEntity<PovratnaPoruka>(korisnikService.unaprijediKorisnikaOrganizator(id), HttpStatus.OK);
    }

    @PostMapping("degradirajOrganizatora/{id}")
    public ResponseEntity<PovratnaPoruka> degradirajOrganizatora(@PathVariable int id)
    {
        return new ResponseEntity<PovratnaPoruka>(korisnikService.degradirajOrganizatora(id), HttpStatus.OK);
    }

    @GetMapping("promjeniKorisnickoIme")
    public ResponseEntity<PovratnaPoruka> promjeniKorisnickoIme(@RequestParam int id, @RequestParam String korisnickoIme)
    {
        return new ResponseEntity<PovratnaPoruka>(korisnikService.promjeniKorisnickoIme(id, korisnickoIme), HttpStatus.OK);
    }

    @GetMapping("promjeniSifru")
    public ResponseEntity<PovratnaPoruka> promjeniSifru(@RequestParam int id, @RequestParam String sifra)
    {
        return new ResponseEntity<PovratnaPoruka>(korisnikService.promjeniSifru(id, sifra), HttpStatus.OK);
    }




}