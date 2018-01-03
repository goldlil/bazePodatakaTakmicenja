package com.bazepodataka.takmicenje.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="Pitanje")
public class Pitanje implements Serializable{

    public Pitanje(String tekstPitanja, List<String> listaOdgovora, String tipPitanja,  String tacniOdgovori, Test idTesta) {
        this.tekstPitanja = tekstPitanja;
        this.idTesta = idTesta;
        this.listaOdgovora = listaOdgovora;
        this.tipPitanja = tipPitanja;
        this.tacniOdgovori = tacniOdgovori;
    }
    public  Pitanje() {}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idPitanja", nullable = false)
    private int idPitanja;

    @Column(name="tekstPitanja", nullable = false)
    private String tekstPitanja;

    @ElementCollection
    @CollectionTable(
            name="Odgovori",
            joinColumns=@JoinColumn(name="idPitanja", referencedColumnName = "idPitanja")
    )
    @Column(name="listaOdgovora", nullable = false)
    private List<String> listaOdgovora;

    @Column(name="tipPitanja", nullable = false)
    private String tipPitanja;


    //ukoluko nije odgovor sa vise mogucnosti ovo može biti null i tacan odgovor je prvi element liste, inace
    //je ovo lista tacnih odgovora odvojenih zarezom ako ih ima vise npr 1,2,3,4 ili samo 1 npr ako je jedan tacan
    @Column(name="tacniOdgovori")
    private String tacniOdgovori;

    @ManyToOne
    @JoinColumn(name = "idTest", nullable = false)
    protected Test idTesta;

    public List<String> getListaOdgovora() {
        return listaOdgovora;
    }

    public void setListaOdgovora(List<String> listaOdgovora) {
        this.listaOdgovora = listaOdgovora;
    }

    public String getTipPitanja() {
        return tipPitanja;
    }

    public void setTipPitanja(String tipPitanja) {
        this.tipPitanja = tipPitanja;
    }

    public String getTacniOdgovori() {
        return tacniOdgovori;
    }

    public void setTacniOdgovori(String tacniOdgovori) {
        this.tacniOdgovori = tacniOdgovori;
    }

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

    public Test getIdTesta() {
        return idTesta;
    }

    public void setIdTesta(Test idTesta) {
        this.idTesta = idTesta;
    }
}
