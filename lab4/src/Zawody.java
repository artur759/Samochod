public class Zawody {
    private String  zawody;
    private String data;
    Samochod samochodik2[] = new  Samochod[100];

    public Samochod[] getSamochodik2() {
        return samochodik2;
    }

   public void rozegrajZawody(Pozycja p)throws InterruptedException {
        Sprzeglo sprz1 = new Sprzeglo("clutch1",30,400);
        SkrzyniaBiegow sB1 = new SkrzyniaBiegow("gearbox1", 200, 20000, 6, sprz1);
        Silnik s1 = new Silnik("engine1", 700, 8000);
        samochodik2[0] = new Samochod("6dsa63", "AUDI", 200, s1, sB1);
        System.out.println("Waga : " + samochodik2[0].getWaga());

        Sprzeglo sprz2 = new Sprzeglo("clutch2",50,700);
        SkrzyniaBiegow sB2 = new SkrzyniaBiegow("gearbox2", 320, 2300, 5, sprz2);
        Silnik s2 = new Silnik("engine2", 500, 4200);
        samochodik2[1] = new Samochod("1ad3e", "BMW", 250, s2, sB2);

        System.out.println("Waga : " + samochodik2[1].getWaga());
        s1.uruchom();
        s2.uruchom();
        sB1.setAktualnePrzelozenie(1+(sB1.getIloscBiegow()*0.2));
        sB2.setAktualnePrzelozenie(1+(sB2.getIloscBiegow()*0.2));

        s1.setObroty(s1.getMaxObroty());
        s2.setObroty(s2.getMaxObroty());
         samochodik2[0].pozycja(p);
         samochodik2[1].pozycja(p);
        //samochodik2[1].pozycja(new Pozycja(100,500));
}
    public static void main(String[] args) {
        Zawody z = new Zawody();
        z.zawody= "Puchar sol=łtysa";
        z.data= "Poniedziałek";

        try{
            z.rozegrajZawody(new Pozycja(1000,500));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
}
