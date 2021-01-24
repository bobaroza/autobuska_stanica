package markom.cs101.autobuskastanica;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Baza {


    private static List<AutobuskaLinija> listaLinija = new ArrayList<>();

    private static List<Rezervacija> rezervacije = new ArrayList<>();

    public static List<AutobuskaLinija> getListaLinija() {
        return new ArrayList<AutobuskaLinija>(listaLinija);
    }

    // vraca sve polazne lokacije za sve Autobuske linije (AutobuskaLinija)
    public ArrayList<String> polazneLokacije(){
        ArrayList<String> polaznaLokacija=new ArrayList<String>();
        for (AutobuskaLinija linija: listaLinija){
            if (!polaznaLokacija.contains(linija.getOdMesta()))
                polaznaLokacija.add(linija.getOdMesta());
        }
        return polaznaLokacija;
    }

    public ArrayList<String> mogucaOdredista(String polaznaLokacija){
        ArrayList<String> krajnjaLokacija=new ArrayList<String>();
        for (AutobuskaLinija linija: listaLinija){
            if (linija.getOdMesta().equals(polaznaLokacija))
                krajnjaLokacija.add(linija.getDoMesta());
        }
        return krajnjaLokacija;
    }

    public ArrayList<String> datumPolaska(String polaznaLokacija, String odrediste){
        ArrayList<String> datumPolaska=new ArrayList<String>();
        for (AutobuskaLinija linija: listaLinija){
            if (linija.getOdMesta().equals(polaznaLokacija) && linija.getDoMesta().equals(odrediste)){
                datumPolaska.add(Tools.DATE_FORMATTER.format(linija.getVremePolaska()));
            }
        }
        return datumPolaska;
    }

    public ArrayList<String> vremePolaska(String polaznaLokacija, String odrediste,String datum){
        ArrayList<String> vremenaPolaska = new ArrayList<String>();
        for (AutobuskaLinija linija: listaLinija){
            if (linija.getOdMesta().equals(polaznaLokacija) && linija.getDoMesta().equals(odrediste) && Tools.DATE_FORMATTER.format(linija.getVremePolaska()).equals(datum)){
                vremenaPolaska.add(Tools.TIME_FORMAT.format(linija.getVremePolaska()));
            }
        }
        return vremenaPolaska;
    }

    public ArrayList<AutobuskaLinija> moguciPolasci(String polaznaLokacija, String odrediste, String datum){
        ArrayList<AutobuskaLinija> prevoznici = new ArrayList<>();
        for (AutobuskaLinija linija: listaLinija){
            if (linija.getOdMesta().equals(polaznaLokacija) && linija.getDoMesta().equals(odrediste) && Tools.DATE_FORMATTER.format(linija.getVremePolaska()).equals(datum)){
                prevoznici.add(linija);
            }
        }
        return prevoznici;
    }

    private static LocalDateTime parsuj(String datum, String vreme){
        return LocalDateTime.from(Tools.DATE_TIME_FORMAT.parse(datum + " " + vreme));
    }

    /*public static void citanje() throws IOException*/static {
        try(BufferedReader bf = new BufferedReader(new FileReader("relacije.txt"))){
            String s;
            while ((s=bf.readLine())!=null){
                String[] data=s.split(",");
                if (data.length < 9)
                    continue;

                String sifra=data[0];
                String kompanija=data[1];
                String pocetak=data[2];
                String odrediste=data[3];

                String datum=data[4];
                String vreme=data[5];
                LocalDateTime a = parsuj(datum,vreme);

                int brojMesta=Integer.parseInt(data[6]);
                TipVozila tip = TipVozila.valueOf(data[7]);
                int cena=Integer.parseInt(data[8]);

                AutobuskaLinija novaLinija=new AutobuskaLinija(pocetak, odrediste, kompanija, a, brojMesta, sifra, tip, cena);
                listaLinija.add(novaLinija);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void exportRezervacije(String file) {
        try(BufferedWriter w = new BufferedWriter(new FileWriter(file))) {
            for (Rezervacija r : rezervacije) {
                w.write(r.getSifraPolaska());
                w.write(",\"");
                w.write(r.getIme());
                w.write("\",");
                w.write(String.valueOf(r.getBrMesta()));
                w.write('\n');
            }
        } catch (IOException e) {
            System.err.println("Neuspesan upis u fajl: " + e.getMessage());
        }
    }

    public static boolean rezervisi(AutobuskaLinija al, Rezervacija r) {
        if (r.getBrMesta() < al.getBrSlobodnihMesta()) {
            al.setBrSlobodnihMesta(al.getBrSlobodnihMesta() - r.getBrMesta());
            rezervacije.add(r);
            return true;
        }
        return false;
    }

    protected static void stampajSveLinije(){
        for (AutobuskaLinija autobuskaLinija: listaLinija){
            System.out.println(autobuskaLinija);
        }
    }

    protected static void stampajSveRezervacije(){
        for (Rezervacija rezervacija : rezervacije) {
            System.out.println(rezervacija);
        }
    }

//
//    public static void main(String[] args) throws IOException {
//        stampajListeLinija(listaLinija);
//    }


}
