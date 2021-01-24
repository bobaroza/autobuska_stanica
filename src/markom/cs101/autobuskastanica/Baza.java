package markom.cs101.autobuskastanica;

import java.util.ArrayList;

public interface Baza {

    ArrayList<String> polazneLokacije();

    ArrayList<String> mogucaOdredista(String polaznaLokacija);

    ArrayList<String> datumPolaska(String polaznaLokacija, String odrediste);

    ArrayList<AutobuskaLinija> moguciPolasci(String polaznaLokacija, String odrediste, String datum);

    boolean rezervisi(AutobuskaLinija al, Rezervacija r);

    void stampajSveLinije();

    void stampajSveRezervacije();

    void exportRezervacije(String file);

}
