package markom.cs101.autobuskastanica;

public class Rezervacija {
  String sifraPolaska;
  String ime;
  int brMesta;

  public Rezervacija(String sifraPolaska, String ime, int brMesta) {
    this.sifraPolaska = sifraPolaska;
    this.ime = ime;
    this.brMesta = brMesta;
  }

  @Override
  public String toString() {
    return
            "sifra polaska='" + sifraPolaska + '\'' +
            ", ime='" + ime + '\'' +
            ", br mesta=" + brMesta
            ;
  }

  public String getSifraPolaska() {
    return sifraPolaska;
  }

  public void setSifraPolaska(String sifraPolaska) {
    this.sifraPolaska = sifraPolaska;
  }

  public String getIme() {
    return ime;
  }

  public void setIme(String ime) {
    this.ime = ime;
  }

  public int getBrMesta() {
    return brMesta;
  }

  public void setBrMesta(int brMesta) {
    this.brMesta = brMesta;
  }
}
