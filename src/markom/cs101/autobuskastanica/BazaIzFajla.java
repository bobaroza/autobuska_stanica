package markom.cs101.autobuskastanica;

import java.io.*;
import java.time.LocalDateTime;

public class BazaIzFajla extends BazaApstraktna {

  public BazaIzFajla(String polasciFajl) throws IOException {
    try(BufferedReader bf = new BufferedReader(new FileReader(polasciFajl))){
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
      throw e;
    }
  }

  private static LocalDateTime parsuj(String datum, String vreme){
    return LocalDateTime.from(Tools.DATE_TIME_FORMAT.parse(datum + " " + vreme));
  }

  public void exportRezervacije(String file) {
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

}
