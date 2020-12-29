public class MiniBus extends Bus{

    private boolean postojiRadio;

    public MiniBus(){
        // 3 vrata za -> vozac, suvozac, putnici
        this(3,15,true,80.00,true,true);
    }

    // treba modifikovati konstruktor ??? (seteri)
    public MiniBus(int vrata, int brojSedista, boolean gepek, double maxBrzina, boolean klima, boolean postojiRadio) {
        super(vrata, brojSedista, gepek, maxBrzina, klima);
        this.postojiRadio=postojiRadio;
    }

    // toString() da li valja ???
    @Override
    public String toString() {
        return super.toString()+
            "postojiRadio=" + postojiRadio +
                '}';
    }

    public boolean isPostojiRadio() {
        return postojiRadio;
    }

    public void setPostojiRadio(boolean postojiRadio) {
        this.postojiRadio = postojiRadio;
    }

    @Override
    public boolean isKlima() {
        return super.isKlima();
    }

    @Override
    public void setKlima(boolean klima) {
        super.setKlima(klima);
    }

    @Override
    public double getMaxBrzina() {
        return super.getMaxBrzina();
    }

    @Override
    public void setMaxBrzina(double maxBrzina) {
        // Da li ovo valja ???
        if (maxBrzina<40.00||maxBrzina>95.00){
            System.out.println("Brzina mora biti izmedju 72.0 i 110.0");
        }else {
            this.maxBrzina=maxBrzina;
        }
    }

    @Override
    public void setVrata(int vrata) {
        // Da li ovo valja ???
        if (vrata>3||vrata<1){
            System.out.println("Ne dozvoljeni broj vrata");
        }else {
            this.vrata=vrata;
        }
    }

    @Override
    public void setBrojSedista(int brojSedista) {
        // Da li ovo valja ???
        if (brojSedista<15||brojSedista>30){
            System.out.println("Broj sedista mora biti izmedju 15-30");
        }else {
            this.brojSedista=brojSedista;
        }
    }

    @Override
    public void setGepek(boolean gepek) {
        super.setGepek(gepek);
    }

    @Override
    public int getVrata() {
        return super.getVrata();
    }

    @Override
    public int getBrojSedista() {
        return super.getBrojSedista();
    }

    @Override
    public boolean isGepek() {
        return super.isGepek();
    }
}
