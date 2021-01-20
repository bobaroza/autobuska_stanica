package markom.cs101.autobuskastanica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner=new Scanner(System.in);

    public static int readInt(int max){
        while (true){
            try {
                int i = scanner.nextInt();
                if (i < 1 || i > max) {
                    System.out.println("Unesite broj opcije izmedju 1 i "+max);
                }else {
                    return i;
                }
            }catch (InputMismatchException e){
                //go around again
                scanner.nextLine();
                System.out.println("Unesite broj opcije izmedju 1-"+max);
            }
        }
    }

    public static void rezervisi(){
        Baza baza=new Baza();
        boolean prekid=false;

        //while(!prekid){}
        // sve moguce polazne lokacije
        ArrayList<String> polazneLokacije = baza.polazneLokacije();
        for (int i=0;i<polazneLokacije.size();i++){
            System.out.println((i+1)+". "+polazneLokacije.get(i));
        }
        System.out.println("---Odaberite polaznu lokaciju---");
        int pL=readInt(polazneLokacije.size()); // polazna lokacija

        // moguce destinacije za odabranu pocetnu lokaciju
        ArrayList<String> moguceDestinacije= baza.mogucaOdredista(polazneLokacije.get(pL-1));
        for (int i=0;i<moguceDestinacije.size();i++){
            System.out.println((i+1)+". "+moguceDestinacije.get(i));
        }
        System.out.println("---Odaberite destinaciju---");
        int d=readInt(moguceDestinacije.size()); // destinacija

        // moguci datumi polaska za odabranu destinaciju
        ArrayList<String> moguciDatumi = baza.datumPolaska(polazneLokacije.get(pL-1),moguceDestinacije.get(d-1));
        for (int i=0;i<moguciDatumi.size();i++){
            System.out.println((i+1)+". "+moguciDatumi.get(i));
        }
        System.out.println("---Odaberite datum polaska---");
        int datum = readInt(moguciDatumi.size()); // datum

        // moguca vremena polaska za odabrani datum polaska
        ArrayList<String> vremenaPolaska = baza.vremePolaska(polazneLokacije.get(pL-1),moguceDestinacije.get(d-1),moguciDatumi.get(datum-1));
        for (int i=0;i<vremenaPolaska.size();i++){
            System.out.println((i+1)+". "+vremenaPolaska.get(i));
        }
        System.out.println("---Odaberite vreme polaska---");
        int vreme = readInt(vremenaPolaska.size()); // datum

        // moguci prevoznici za dato vreme polaska
        ArrayList<String> prevoznici = baza.moguciPrevoznici(polazneLokacije.get(pL-1),moguceDestinacije.get(d-1),moguciDatumi.get(datum-1),vremenaPolaska.get(vreme-1));
        for (int i=0;i<prevoznici.size();i++){
            System.out.println((i+1)+". "+prevoznici.get(i));
        }
        System.out.println("---Odaberite prevoznika---");
        int prevoznik = readInt(prevoznici.size()); // datum

        // odabir sedista
        System.out.println("----Na kom mestu biste hteli da sedite----");
        // zavrsicu danas kad zavrsim  matematiku
    }

    public static void printMenu(){
        System.out.println("=============Menu=============");
        System.out.println("1. Izadjite iz aplikacije");
        System.out.println("2. Rezervisite mesto");
        System.out.println("3. Prikazite meni");
        System.out.println("==============================");
    }

    public static void application(){
        boolean quit=false;
        printMenu();
        while (!quit){
            System.out.println("==============================");
            System.out.println("Odaberite neku opciju iz menija");
            int option=readInt(3);
            switch (option){
                case 1:
                    quit=true;
                    System.out.println("Exiting application...");
                    break;
                case 2:
                    rezervisi();
                    break;
                case 3:
                    printMenu();
                    break;
                default:
                    System.out.println("Niste odabrali validnu opciju, probajte ponovo");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        application();
    }

}
