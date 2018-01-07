package com.bazepodataka.takmicenje.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Test")
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idTest", nullable = false)
    private int testId;
    @Column(name="imeTesta", nullable = false)
    private String imeTesta;

    @Column(name= "vrijemeZaIzdraduTesta", nullable = false)
    private int vrijemeIzradeTesta;

    @ManyToMany(mappedBy = "testovi")
    Set<Takmicenje> takmicenja = new HashSet<Takmicenje>();

    public Test(String imeTesta, int vrijemeIzradeTesta)
    {
        this.imeTesta = imeTesta;
        this.vrijemeIzradeTesta = vrijemeIzradeTesta;
    }

    public int getVrijemeIzradeTesta() {
        return vrijemeIzradeTesta;
    }

    public void setVrijemeIzradeTesta(int vrijemeIzradeTesta) {
        this.vrijemeIzradeTesta = vrijemeIzradeTesta;
    }

    public Test(){}



    public int getTestId() {
        return testId;
    }

    protected void setTestId(int testId) {
        this.testId = testId;
    }

    public String getImeTesta() {
        return imeTesta;
    }

    protected void setImeTesta(String imeTesta) {
        this.imeTesta = imeTesta;
    }
}