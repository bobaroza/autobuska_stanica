package markom.cs101.autobuskastanica;

public class Relacija {
    private String odMesta;
    private String doMesta;

    public Relacija(String odMesta, String doMesta) {
        this.odMesta = odMesta;
        this.doMesta = doMesta;
    }

    @Override
    public String toString() {
        return "Relacija{" +
                "odMesta='" + odMesta + '\'' +
                ", doMesta='" + doMesta + '\'' +
                '}';
    }

    public String getOdMesta() {
        return odMesta;
    }

    public void setOdMesta(String odMesta) {
        this.odMesta = odMesta;
    }

    public String getDoMesta() {
        return doMesta;
    }

    public void setDoMesta(String doMesta) {
        this.doMesta = doMesta;
    }
}

