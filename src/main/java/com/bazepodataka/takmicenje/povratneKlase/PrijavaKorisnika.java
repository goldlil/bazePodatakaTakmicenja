package com.bazepodataka.takmicenje.povratneKlase;

public class PrijavaKorisnika {
    public Boolean getPrijavljen() {
        return prijavljen;
    }

    public void setPrijavljen(Boolean prijavljen) {
        this.prijavljen = prijavljen;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Boolean prijavljen;
    private String username;
    private String tip;
    private String id;

    public PrijavaKorisnika(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PrijavaKorisnika(Boolean prijavljen, String username, String tip, String id) {
        this.prijavljen = prijavljen;
        this.tip = tip;
        this.username = username;
        this.id = id;
    }
}
