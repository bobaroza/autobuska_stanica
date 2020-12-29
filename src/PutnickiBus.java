public class PutnickiBus extends Bus{

    private boolean postojiTelevizor; // postoje neki putnicki autobusi koji imaju TV, vidjao sam ih na ekskurziji

    public PutnickiBus(){
        this(2,70,true,110.00,true,false);
    }

    public PutnickiBus(int vrata, int brojSedista, boolean gepek, double maxBrzina, boolean klima, boolean postojiTelevizor) {
        super(vrata, brojSedista, gepek, maxBrzina, klima);
        this.postojiTelevizor=postojiTelevizor;
    }

    @Override
    public String toString() {
        return super.toString()+
                "postojiTelevizor=" + postojiTelevizor +
                '}';
    }

    public boolean isPostojiTelevizor() {
        return postojiTelevizor;
    }

    public void setPostojiTelevizor(boolean postojiTelevizor) {
        this.postojiTelevizor = postojiTelevizor;
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
        if (maxBrzina<72.00||maxBrzina>110.00){
            System.out.println("Brzina mora biti izmedju 72.0 i 110.0");
        }else {
            this.maxBrzina=maxBrzina;
        }
    }

    @Override
    public void setVrata(int vrata) {
        // Da li ovo valja ???
        if (vrata>2||vrata<1){
            System.out.println("Ne dozvoljeni broj vrata");
        }else {
            this.vrata=vrata;
        }
    }

    @Override
    public void setBrojSedista(int brojSedista) {
        // Da li ovo valja ???
        if (brojSedista<70||brojSedista>82){
            System.out.println("Broj sedista mora biti izmedju 70-82");
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
