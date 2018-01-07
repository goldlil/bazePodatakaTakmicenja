package com.bazepodataka.takmicenje.entity;


import javax.persistence.*;

@Entity
@Table(name = "Prijava")
public class Prijava {

    public Prijava(Takmicenje takmicenjeId, Korisnik korisnikId, boolean potvrdjena) {
        this.takmicenjeId = takmicenjeId;
        this.korisnikId = korisnikId;
        this.potvrdjena = potvrdjena;
    }

    public int getPrijavaId() {
        return prijavaId;
    }

    public void setPrijavaId(int prijavaId) {
        this.prijavaId = prijavaId;
    }

    public Takmicenje getTakmicenjeId() {
        return takmicenjeId;
    }

    public void setTakmicenjeId(Takmicenje takmicenjeId) {
        this.takmicenjeId = takmicenjeId;
    }

    public Korisnik getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
    }

    public boolean isPotvrdjena() {
        return potvrdjena;
    }

    public void setPotvrdjena(boolean potvrdjena) {
        this.potvrdjena = potvrdjena;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="idPrijava", nullable = false)
    private int prijavaId;

    @ManyToOne
    @JoinColumn(name = "idTest", nullable = false)
    private Takmicenje takmicenjeId;

    @ManyToOne
    @JoinColumn(name="idKorisnik", nullable = false)
    private Korisnik korisnikId;

    @Column(name = "potvrdjena", nullable = false)
    private boolean potvrdjena;
}
