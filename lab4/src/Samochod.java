public class Samochod extends Thread{
    private boolean stanWlaczenia = false;
    public String getNrRejest() {
        return nrRejest;
    }
    private String nrRejest;

    private String model;
    private double predkoscMax;
    public String getModel() {
        return model;
    }
    private double predkosc = 0;
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Pozycja aktualnaPozycja = new Pozycja(0,0);
    private final double obwodKola= 0.015;
    private Pozycja cel = new Pozycja(0,0);
    private SkrzyniaBiegow skrzyniaBiegow;
    private double zwolnienieAkcji = 0.2;

    public float getWaga(){ return (silnik.getWaga()+ skrzynia.getWaga()); }
    public void setAktualnaPozycja(Pozycja aktualnaPozycja) {
        this.aktualnaPozycja = aktualnaPozycja;
    }
    public Silnik getSilnik() {
        return silnik;
    }
    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }
    public SkrzyniaBiegow getSkrzyniaBiegow() {
        return skrzyniaBiegow;
    }

    public void wlacz(){
        if(stanWlaczenia= false) {

            silnik.uruchom();

            stanWlaczenia = true;
        }
    }

    public void wylacz(){
        if(stanWlaczenia = true ) {
            silnik.zatrzymaj();
            skrzynia.setAktualnyBieg(0);
            skrzynia.setAktualnePrzelozenie(0);
            stanWlaczenia = false;
        }
    }


    public void pozycja(Pozycja cel){
        this.cel = cel;
    }

    public void jedzDo(){
        //public void jedzDo(double dt){
        double x = cel.getX()-aktualnaPozycja.getX();
        double y = cel.getY()-aktualnaPozycja.getY();
        double odleglosc = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double X = aktualnaPozycja.getX() + getAktPredkosc()*(x/odleglosc)*zwolnienieAkcji;
        double Y = aktualnaPozycja.getY() + getAktPredkosc()*(y/odleglosc)*zwolnienieAkcji;

        if(X>=cel.getX() && Y>=cel.getY()) {
            aktualnaPozycja.setPozycja(cel);
            System.out.println(model+" -  DOJECHAŁ!");
        }
        else{
            aktualnaPozycja.setPozycja(X,Y);
        }
    }



    public double getAktPredkosc(){
        predkosc = skrzynia.getAktPrzelozenie()*silnik.getObroty()*obwodKola*(predkoscMax/180);
        if(skrzynia.getAktBieg()==skrzynia.getIloscBiegow() & silnik.getObroty()== silnik.getMaxObroty()){predkosc=predkoscMax;}
        return predkosc;
    }
    public Pozycja getAktPozycja(){
        return aktualnaPozycja;
    }

    public Samochod(String nrRejest, String model, float predkoscMax, Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.start();
    }

    public void run(){
        while(true){
            if(aktualnaPozycja.getX()!=cel.getX() && aktualnaPozycja.getY()!=cel.getY()) {
                jedzDo();
                System.out.println(model);
                aktualnaPozycja.wyswietlPozycje();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

}
