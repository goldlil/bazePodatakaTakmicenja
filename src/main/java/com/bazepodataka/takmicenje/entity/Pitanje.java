package com.bazepodataka.takmicenje.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Pitanje")
public class Pitanje implements Serializable{
    public Pitanje(String tekstPitanja, String odgovor, Test idTesta) {
        System.out.println("tu sam");
        this.tekstPitanja = tekstPitanja;
        this.odgovor = odgovor;
        this.idTesta = idTesta;
    }

   /* public Pitanje(String tekstPitanja, String odgovor, int idTesta) {
        this.tekstPitanja = tekstPitanja;
        this.odgovor = odgovor;
        this.idTesta = new Test(idTesta);
    }*/

    public  Pitanje()
    {

    }


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idPitanja", nullable = false)
    private int idPitanja;
    @Column(name="", nullable = false)
    private String tekstPitanja;
    @Column(name="odgovor", nullable = false)
    private String odgovor;

    @ManyToOne
    @JoinColumn(name = "idTest", nullable = false)
    protected Test idTesta;

    public int getIdPitanja() {
        return idPitanja;
    }

    public void setIdPitanja(int idPitanja) {
        this.idPitanja = idPitanja;
    }

    public String getTekstPitanja() {
        return tekstPitanja;
    }

    public void setTekstPitanja(String tekstPitanja) {
        this.tekstPitanja = tekstPitanja;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public Test getIdTesta() {
        return idTesta;
    }

    public void setIdTesta(Test idTesta) {
        this.idTesta = idTesta;
    }
}
