package markom.cs101.autobuskastanica;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AutobuskaLinija extends Relacija{
    private String prevoznik;
    private LocalDateTime vremePolaska;
    private int brSedistaUAutobusu;
    private String sifraPolaska;

    public AutobuskaLinija(String odMesta, String doMesta, String prevoznik, LocalDateTime vremePolaska, int brSedistaUAutobusu, String sifraPolaska) {
        super(odMesta, doMesta);
        this.prevoznik = prevoznik;
        this.vremePolaska = vremePolaska;
        this.brSedistaUAutobusu = brSedistaUAutobusu;
        this.sifraPolaska = sifraPolaska;
    }

    public AutobuskaLinija(String odMesta, String doMesta) {
        super(odMesta, doMesta);
    }

    @Override
    public String toString() {
        return "AutobuskaLinija{ " +
                "prevoznik="+ prevoznik +
                ", odMesta="+ getOdMesta() +
                ", doMesta="+ getDoMesta() +
                ", vremePolaska=" + Tools.DATE_TIME_FORMAT.format(vremePolaska) +
                ", brSedistaUAutobusu=" + brSedistaUAutobusu +
                ", sifraPolaska='" + sifraPolaska + '\'' +
                '}';
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
}
