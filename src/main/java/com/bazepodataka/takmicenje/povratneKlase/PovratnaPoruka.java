package com.bazepodataka.takmicenje.povratneKlase;

public class PovratnaPoruka {

    public boolean isUspjehZahtjeva() {
        return uspjehZahtjeva;
    }

    public void setUspjehZahtjeva(boolean uspjehZahtjeva) {
        this.uspjehZahtjeva = uspjehZahtjeva;
    }

    public String getPorukaGreske() {
        return porukaGreske;
    }

    public void setPorukaGreske(String porukaGreske) {
        this.porukaGreske = porukaGreske;
    }

    private boolean uspjehZahtjeva;
    private String porukaGreske;

    public PovratnaPoruka(boolean uspjehZahtjeva, String porukaGreske)
    {
        this.uspjehZahtjeva = uspjehZahtjeva;
        this.porukaGreske = porukaGreske;
    }

    public PovratnaPoruka(){
        this.uspjehZahtjeva = true;
        this.porukaGreske = "";
    }

    public PovratnaPoruka(String porukaGreske){
        this.porukaGreske = porukaGreske;
    }


}
