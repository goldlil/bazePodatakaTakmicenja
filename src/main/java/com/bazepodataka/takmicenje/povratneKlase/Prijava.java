package com.bazepodataka.takmicenje.povratneKlase;

public class Prijava {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private Boolean prijavljen;
    private String username;
    private String tip;
    private String token;

    public Prijava(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Prijava(Boolean prijavljen, String username, String tip, String token) {
        this.prijavljen = prijavljen;
        this.tip = tip;
        this.username = username;
        this.token = token;
    }
}
