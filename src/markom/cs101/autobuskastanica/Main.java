package markom.cs101.autobuskastanica;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static Baza baza;

    public static void main(String[] args) throws IOException {
        String file = "relacije.txt";
        baza = new BazaIzFajla(file);
        application();
    }

    public static void rezervisi() throws PrekidOperacije {

        //while(!prekid){}
        // sve moguce polazne lokacije
        ArrayList<String> polazneLokacije = baza.polazneLokacije();
        for (int i=0;i<polazneLokacije.size();i++){
            System.out.println((i+1)+". "+polazneLokacije.get(i));
        }
        System.out.println("---Odaberite polaznu lokaciju---");
        int pL=Tools.readInt(polazneLokacije.size()); // polazna lokacija

        // moguce destinacije za odabranu pocetnu lokaciju
        ArrayList<String> moguceDestinacije= baza.mogucaOdredista(polazneLokacije.get(pL-1));
        for (int i=0;i<moguceDestinacije.size();i++){
            System.out.println((i+1)+". "+moguceDestinacije.get(i));
        }
        System.out.println("---Odaberite destinaciju---");
        int d=Tools.readInt(moguceDestinacije.size()); // destinacija

        // moguci datumi polaska za odabranu destinaciju
        ArrayList<String> moguciDatumi = baza.datumPolaska(polazneLokacije.get(pL-1),moguceDestinacije.get(d-1));
        for (int i=0;i<moguciDatumi.size();i++){
            System.out.println((i+1)+". "+moguciDatumi.get(i));
        }
        System.out.println("---Odaberite datum polaska---");
        int datum = Tools.readInt(moguciDatumi.size()); // datum

        // moguci prevoznici za dato vreme polaska
        ArrayList<AutobuskaLinija> polasci = baza.moguciPolasci(polazneLokacije.get(pL-1),moguceDestinacije.get(d-1),moguciDatumi.get(datum-1));
        for (int i=0;i<polasci.size();i++){
            System.out.println((i+1) + ". " + polasci.get(i));
        }
        System.out.println("---Odaberite polazak---");
        int prevoznik = Tools.readInt(polasci.size()); // datum

        AutobuskaLinija polazak = polasci.get(prevoznik-1);

        // odabir sedista
        System.out.println("--- Koliko mesta zelite da rezervisete? (1-" + polazak.getBrSlobodnihMesta() + ")");
        int brMesta = Tools.readInt(polazak.getBrSlobodnihMesta());

        System.out.println("--- Na koje ime glasi rezervacija? ---");
        String ime = Tools.readString();

        Rezervacija rezervacija = new Rezervacija(polazak.getSifraPolaska(), ime, brMesta);
        if (baza.rezervisi(polazak, rezervacija)) {
            System.out.println("USPESNO STE REZERVISALI KARTU");
        }
        else {
            System.out.println("NEUSPESNA REZERVACIJA");
        }
    }

    public static void izvezi() throws PrekidOperacije {
        System.out.println("--- Unesite ime fajla ---");
        String imeFajla = Tools.readString();
        baza.exportRezervacije(imeFajla);
    }

    public static void printMenu(){
        System.out.println("=============Menu=============");
        System.out.println("1. Rezervisite kartu");
        System.out.println("2. Prikazite meni");
        System.out.println("3. Prikazite sve polaske");
        System.out.println("4. Prikazite sve rezervacije");
        System.out.println("5. Izvezite rezervacije u fajl");
        System.out.println("0. Izadjite iz aplikacije");
        System.out.println("==============================");
    }

    public static void application(){
        boolean quit=false;
        while (!quit){
            printMenu();
            System.out.println("Odaberite neku od opcija unosom broja opcije");
            try {
                int option = Tools.readInt(5);
                switch (option) {
                    case 1:
                        try {
                            rezervisi();
                        } catch (PrekidOperacije po) {
                            // uhvatili smo exception za prekid trenutne operacije i vracamo se na meni
                            System.out.println("Izasli ste iz kreiranja rezervacije");
                        }
                        break;
                    case 2:
                        break; // jer uvek stampamo...
                    case 3:
                        baza.stampajSveLinije();
                        break;
                    case 4:
                        baza.stampajSveRezervacije();
                        break;
                    case 5:
                        izvezi();
                        break;
                    default:
                        System.out.println("Niste odabrali validnu opciju, probajte ponovo");
                        break;
                }
            }
            catch (PrekidOperacije e) {
                quit = true;
                System.out.println("Exiting application...");
            }
        }
    }

}
