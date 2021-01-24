package markom.cs101.autobuskastanica;

import java.time.LocalDateTime;

public class AutobuskaLinija extends Relacija {
    private String prevoznik;
    private LocalDateTime vremePolaska;
    private int brSedistaUAutobusu;
    private String sifraPolaska;
    private TipVozila tipVozila;
    private int cena;
    private int brSlobodnihMesta;


    public AutobuskaLinija(String odMesta, String doMesta, String prevoznik, LocalDateTime vremePolaska, int brSedistaUAutobusu, String sifraPolaska, TipVozila tipVozila, int cena) {
        super(odMesta, doMesta);
        this.prevoznik = prevoznik;
        this.vremePolaska = vremePolaska;
        this.brSedistaUAutobusu = brSedistaUAutobusu;
        this.sifraPolaska = sifraPolaska;
        this.tipVozila = tipVozila;
        this.cena = cena;

        this.brSlobodnihMesta = brSedistaUAutobusu;
    }

    @Override
    public String toString() {
        return
                "prevoznik: "+ prevoznik +
                ", od: "+ getOdMesta() +
                ", do: "+ getDoMesta() +
                ", vreme polaska: " + Tools.DATE_TIME_FORMAT.format(vremePolaska) +
                ", tip: " + tipVozila.toString().toLowerCase().replace('_', ' ') +
                ", max sedista: " + brSedistaUAutobusu +
                ", sifra polaska: " + sifraPolaska +
                ", cena: " + cena +
                ", slobodnih mesta: " + brSlobodnihMesta
                ;
    }

    public String getPrevoznik() {
        return prevoznik;
    }

    public void setPrevoznik(String prevoznik) {
        this.prevoznik = prevoznik;
    }

    public LocalDateTime getVremePolaska() {
        return vremePolaska;
    }

    public void setVremePolaska(LocalDateTime vremePolaska) {
        this.vremePolaska = vremePolaska;
    }

    public int getBrSedistaUAutobusu() {
        return brSedistaUAutobusu;
    }

    public void setBrSedistaUAutobusu(int brSedistaUAutobusu) {
        this.brSedistaUAutobusu = brSedistaUAutobusu;
    }

    public String getSifraPolaska() {
        return sifraPolaska;
    }

    public void setSifraPolaska(String sifraPolaska) {
        this.sifraPolaska = sifraPolaska;
    }

    public TipVozila getTipVozila() {
        return tipVozila;
    }

    public void setTipVozila(TipVozila tipVozila) {
        this.tipVozila = tipVozila;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getBrSlobodnihMesta() {
        return brSlobodnihMesta;
    }

    public void setBrSlobodnihMesta(int brSlobodnihMesta) {
        this.brSlobodnihMesta = brSlobodnihMesta;
    }
}
