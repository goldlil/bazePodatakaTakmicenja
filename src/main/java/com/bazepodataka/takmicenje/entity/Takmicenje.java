package com.bazepodataka.takmicenje.entity;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Takmicenje")
public class Takmicenje {

    public Takmicenje(String nazivTakmicenja, Date datumPocektaOdrzavanja, int trajanje, Korisnik organizator) {
        this.nazivTakmicenja = nazivTakmicenja;
        this.datumPocektaOdrzavanja = datumPocektaOdrzavanja;
        this.trajanje = trajanje;
        this.organizator = organizator;
    }

    public int getTakmicenjeId() {
        return takmicenjeId;
    }

    public void setTakmicenjeId(int takmicenjeId) {
        this.takmicenjeId = takmicenjeId;
    }

    public String getNazivTakmicenja() {
        return nazivTakmicenja;
    }

    public void setNazivTakmicenja(String nazivTakmicenja) {
        this.nazivTakmicenja = nazivTakmicenja;
    }

    public String getDatumPocektaOdrzavanja() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateformat.format(this.datumPocektaOdrzavanja);
    }

    public void setDatumPocektaOdrzavanja(String datumPocektaOdrzavanja) {
        DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try{
            this.datumPocektaOdrzavanja = df2.parse(datumPocektaOdrzavanja);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Korisnik getOrganizator() {
        return organizator;
    }

    public void setOrganizator(Korisnik organizator) {
        this.organizator = organizator;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="idTakmicenja", nullable = false)
    private int takmicenjeId;


    @Column(name="nazivTakmicenja", nullable = false)
    private String nazivTakmicenja;

    @Column(name="datumPocektaOdrzavanja", nullable = false)
    private Date datumPocektaOdrzavanja;

    @Column(name = "trajanje", nullable = false) //u minutama
    private int trajanje;

    @ManyToOne
    @JoinColumn(name = "idKorisnik", nullable = false)
    private Korisnik organizator;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "takmicenje_test",
            joinColumns = { @JoinColumn(name="idTakmicenja")},
            inverseJoinColumns = {@JoinColumn(name = "idTest")}
    )
    Set<Test> testovi = new HashSet<Test>();

    public void dodajTest(Test t)
    {
        testovi.add(t);
    }


    public Takmicenje() {
    }

    public Set<Test> getTestovi() {
        return testovi;
    }

    public void setTestovi(Set<Test> testovi) {
        this.testovi = testovi;
    }
}
