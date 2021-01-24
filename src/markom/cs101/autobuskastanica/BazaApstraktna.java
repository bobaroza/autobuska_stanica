package markom.cs101.autobuskastanica;

import java.util.ArrayList;
import java.util.List;

public abstract class BazaApstraktna implements Baza {
  protected List<AutobuskaLinija> listaLinija = new ArrayList<>();

  protected List<Rezervacija> rezervacije = new ArrayList<>();


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

  public ArrayList<AutobuskaLinija> moguciPolasci(String polaznaLokacija, String odrediste, String datum){
    ArrayList<AutobuskaLinija> prevoznici = new ArrayList<>();
    for (AutobuskaLinija linija: listaLinija){
      if (linija.getOdMesta().equals(polaznaLokacija) && linija.getDoMesta().equals(odrediste) && Tools.DATE_FORMATTER.format(linija.getVremePolaska()).equals(datum)){
        prevoznici.add(linija);
      }
    }
    return prevoznici;
  }

  public boolean rezervisi(AutobuskaLinija al, Rezervacija r) {
    if (r.getBrMesta() < al.getBrSlobodnihMesta()) {
      al.setBrSlobodnihMesta(al.getBrSlobodnihMesta() - r.getBrMesta());
      rezervacije.add(r);
      return true;
    }
    return false;
  }

  public void stampajSveLinije(){
    for (AutobuskaLinija autobuskaLinija: listaLinija){
      System.out.println(autobuskaLinija);
    }
  }

  public void stampajSveRezervacije(){
    for (Rezervacija rezervacija : rezervacije) {
      System.out.println(rezervacija);
    }
  }


}
