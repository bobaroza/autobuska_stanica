public abstract class Bus {
    protected String kompanija; //treba se dodati u konstruktore ...
    protected int vrata;
    protected int brojSedista;
    protected boolean gepek;
    protected double maxBrzina;
    protected boolean klima;

    public Bus(int vrata, int brojSedista, boolean gepek,double maxBrzina, boolean klima) {
        this.vrata = vrata;
        this.brojSedista = brojSedista;
        this.gepek = gepek;
        this.maxBrzina=maxBrzina;
        this.klima=klima;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "vrata=" + vrata +
                ", brojSedista=" + brojSedista +
                ", gepek=" + gepek +
                ", maxBrzina=" + maxBrzina +
                ", klima=" + klima;
    }

    public boolean isKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    public double getMaxBrzina() {
        return maxBrzina;
    }

    public void setMaxBrzina(double maxBrzina) {
        this.maxBrzina = maxBrzina;
    }

    public void setVrata(int vrata) {
        this.vrata = vrata;
    }

    public void setBrojSedista(int brojSedista) {
        this.brojSedista = brojSedista;
    }

    public void setGepek(boolean gepek) {
        this.gepek = gepek;
    }

    public int getVrata() {
        return vrata;
    }

    public int getBrojSedista() {
        return brojSedista;
    }

    public boolean isGepek() {
        return gepek;
    }
}
