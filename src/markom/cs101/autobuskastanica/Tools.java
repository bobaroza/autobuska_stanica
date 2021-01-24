package markom.cs101.autobuskastanica;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {
    public static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private static final Scanner scanner=new Scanner(System.in);

    public static int readInt(int max) throws PrekidOperacije {
        while (true){
            try {
                int i = scanner.nextInt();
                if (i == 0)
                    throw new PrekidOperacije();
                if (i > max) {
                    System.out.println("Unesite broj opcije izmedju 1 i "+max);
                } else {
                    return i;
                }
            }catch (InputMismatchException e){
                //go around again
                scanner.nextLine();
                System.out.println("Unesite broj opcije izmedju 1-"+max);
            }
        }
    }

    public static String readString() throws PrekidOperacije {
        while (true) {
            try {
                String s = scanner.next();
                if (s.length() == 0)
                    throw new InputMismatchException();
                if (s.equals("0"))
                    throw new PrekidOperacije();
                return s;
            } catch (InputMismatchException e) {
                System.out.println("Unesite znakovni niz");
            }
        }
    }
}
