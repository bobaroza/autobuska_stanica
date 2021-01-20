package markom.cs101.autobuskastanica;

import javax.xml.crypto.Data;
import java.io.*;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Baza {


    private static List<AutobuskaLinija> listaLinija = new ArrayList<AutobuskaLinija>();

    public Baza(){}

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

    public ArrayList<String> moguciPrevoznici(String polaznaLokacija, String odrediste,String datum,String vreme){
        ArrayList<String> prevoznici=new ArrayList<String>();
        for (AutobuskaLinija linija: listaLinija){
            if (linija.getOdMesta().equals(polaznaLokacija) && linija.getDoMesta().equals(odrediste) && Tools.DATE_FORMATTER.format(linija.getVremePolaska()).equals(datum) && Tools.TIME_FORMAT.format(linija.getVremePolaska()).equals(vreme)){
                prevoznici.add(linija.getPrevoznik());
            }
        }
        return prevoznici;
    }

    private static LocalDateTime parsuj(String datum, String vreme){
        return LocalDateTime.from(Tools.DATE_TIME_FORMAT.parse(datum + " " + vreme));

//        String[] arrayDatum = datum.split("-");
//        System.out.println(Arrays.toString(arrayDatum));
//        int dan=Integer.parseInt(arrayDatum[0]);
//        int mesec=Integer.parseInt(arrayDatum[1]);
//        int godina=Integer.parseInt(arrayDatum[2]);
//
//        String[] arrayVreme=vreme.split(":");
//        int sat=Integer.parseInt(arrayVreme[0]);
//        int minut=Integer.parseInt(arrayVreme[1]);
//
//
//        LocalDateTime a = LocalDateTime.of(godina,mesec,dan,sat,minut);
//
//        //verovatno je dobra ideja da se ovako uradi
////        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
////        String formatDateTime = datetime2.format(format);
//
//        return a;
    }

    /*public static void citanje() throws IOException*/static {
        try(BufferedReader bf = new BufferedReader(new FileReader("relacije.txt"))){
            String s;
            while ((s=bf.readLine())!=null){
                String[] data=s.split(",");
                String sifra=data[0];
                String kompanija=data[1];
                String pocetak=data[2];
                String odrediste=data[3];

                String datum=data[4];
                String vreme=data[5];
                LocalDateTime a = parsuj(datum,vreme);

                int brojMesta=Integer.parseInt(data[6]);
                AutobuskaLinija novaLinija=new AutobuskaLinija(pocetak, odrediste, kompanija, a, brojMesta, sifra);
                listaLinija.add(novaLinija);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected static void stampajListeLinija(List<AutobuskaLinija> linijeLista){
        for (AutobuskaLinija autobuskaLinija: linijeLista){
            System.out.println(autobuskaLinija);
        }
    }

    public static void main(String[] args) throws IOException {
        stampajListeLinija(listaLinija);
    }



}
