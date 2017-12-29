package com.bazepodataka.takmicenje.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Test")
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idTest", nullable = false)
    private int testId;
    @Column(name="imeTesta", nullable = false)
    private String imeTesta;

    public Test(String imeTesta) {
        this.imeTesta = imeTesta;
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