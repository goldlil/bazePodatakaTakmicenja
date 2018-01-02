package com.bazepodataka.takmicenje.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Pitanje")
public class Pitanje implements Serializable{
    public Pitanje(String tekstPitanja, String tacanOdgovor, Test idTesta) {
        System.out.println("tu sam");
        this.tekstPitanja = tekstPitanja;
        this.tacanOdgovor = tacanOdgovor;
        this.idTesta = idTesta;
    }

   /* public Pitanje(String tekstPitanja, String tacanOdgovor, int idTesta) {
        this.tekstPitanja = tekstPitanja;
        this.tacanOdgovor = tacanOdgovor;
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
    @Column(name="tacanOdgovor", nullable = false)
    private String tacanOdgovor;

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

    public String getTacanOdgovor() {
        return tacanOdgovor;
    }

    public void setTacanOdgovor(String tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    public Test getIdTesta() {
        return idTesta;
    }

    public void setIdTesta(Test idTesta) {
        this.idTesta = idTesta;
    }
}
