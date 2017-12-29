package com.bazepodataka.takmicenje.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Korisnik")
public class Korisnik implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idKorisnik", nullable = false)
    private int korisnikId;
    @Column(name="korisnickoIme", nullable = false)
    private String korisnickoIme;
    @Column(name="sifra", nullable = false)
    private String sifra;

    public Korisnik() {}

    public Korisnik(String korisnickoIme, String sifra, String email, String tipKorisnika) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.email = email;
        this.tipKorisnika = tipKorisnika;
    }


    @Column(name="email", nullable = false)
    private String email;

    public String getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(String tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    @Column(name="tipKorisnika", nullable = false)
    private String tipKorisnika;

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return this.korisnickoIme + " " + this.sifra + " " + this.email + " " + this.tipKorisnika;
    }
}
