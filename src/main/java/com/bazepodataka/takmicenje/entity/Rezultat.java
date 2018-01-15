package com.bazepodataka.takmicenje.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Rezultat")
public class Rezultat implements Serializable{


    public Korisnik getIdKorisnika() {
        return idKorisnika;
    }

    public Test getIdTesta() {
        return idTesta;
    }

    public int getRezultat() {
        return rezultat;
    }


    private void setIdKorisnika(Korisnik idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    private void setIdTesta(Test idTesta) {
        this.idTesta = idTesta;
    }

    private void setRezultat(int rezultat) {
        this.rezultat = rezultat;
    }

    public int getRezultatId() {
        return rezultatId;
    }

    public void setRezultatId(int rezultatId) {
        this.rezultatId = rezultatId;
    }

    public Rezultat(Korisnik idKorisnika, Test idTesta, int rezultat) {
        this.idKorisnika = idKorisnika;
        this.idTesta = idTesta;
        this.rezultat = rezultat;
    }

    public Rezultat() {}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idRezultata", nullable = false)
    private int rezultatId;

    @ManyToOne
    @JoinColumn(name="idKorisnika", nullable = false)
    private Korisnik idKorisnika;

    @ManyToOne
    @JoinColumn(name="idTesta", nullable = false)
    private Test idTesta;

    @Column(name="rezultat", nullable = false)
    private int rezultat;
}
