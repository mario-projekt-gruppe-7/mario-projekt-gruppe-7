import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    static private Scanner scanner = new Scanner(System.in);

    static void mainMenu(Menu menu, GemteOrdrer gemteOrdrer) {
        System.out.println("velkommen til Marios Pizza \uD83C\uDF55  \n Skriv 0 for exit. \n Skriv 1 for opret en ordre \n Skriv 2 for at printe menu");
        boolean fortsæt = true;
        while(fortsæt) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 2 -> printMenu(menu);
                    case 1 -> {
                        placeOrderUI(scanner, menu, gemteOrdrer);
                        System.out.println("nu har du lavet en ordre");
                        mainMenu(menu, gemteOrdrer);
                    }
                    case 0 -> fortsæt = false; //quit
                    default -> System.out.println("Kom igen");
                }
            } else {
                scanner.nextLine();
            }
        }
    }
    private static void placeOrderUI(Scanner scanner, Menu menu, GemteOrdrer gemteOrdrer) {
        boolean fortsæt = true;
        System.out.println("skriv hvad ordren er: ");
        while (fortsæt) {
            if (scanner.hasNext()) {
                Ordre ordre1 = new Ordre(15, new ArrayList<>(Arrays.asList(
                        new OrdreLinje(4, 5),
                        new OrdreLinje(4, 6)
                )), "betalt");
                gemteOrdrer.tilføjOrdre(ordre1);
                System.out.println("din ordre er nu gemt");
                break; // se om det rigtigt?
            }
        }
    }
    public static void printMenu (Menu menu){
        System.out.println(menu);
    }
}
