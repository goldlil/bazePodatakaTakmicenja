package com.bazepodataka.takmicenje.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Rezultat")
public class Rezultat implements Serializable{

    public int getTestTd() {
        return testTd;
    }

    public Korisnik getIdKorisnika() {
        return idKorisnika;
    }

    public Test getIdTesta() {
        return idTesta;
    }

    public String getRezultat() {
        return rezultat;
    }

    private void setTestTd(int testTd) {
        this.testTd = testTd;
    }

    private void setIdKorisnika(Korisnik idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    private void setIdTesta(Test idTesta) {
        this.idTesta = idTesta;
    }

    private void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public Rezultat(Korisnik idKorisnika, Test idTesta, String rezultat) {
        this.idKorisnika = idKorisnika;
        this.idTesta = idTesta;
        this.rezultat = rezultat;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idTest", nullable = false)
    private int testTd;

    @ManyToOne
    @JoinColumn(name="idKorisnika", nullable = false)
    private Korisnik idKorisnika;

    @ManyToOne
    @JoinColumn(name="idTesta", nullable = false)
    private Test idTesta;

    @Column(name="rezultat", nullable = false)
    private String rezultat;
}
