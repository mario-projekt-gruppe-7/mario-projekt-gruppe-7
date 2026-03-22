import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    static private Scanner scanner = new Scanner(System.in);

    static void mainMenu(Menu menu, GemteOrdrer gemteOrdrer) {
        System.out.println("velkommen til Marios Pizza \uD83C\uDF55  \n Skriv 1 for ny ordre. \n Skriv 0 for exit");
        boolean fortsæt = true;
        while(fortsæt) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> placeOrderUI(scanner, menu, gemteOrdrer);
                    case 0 -> fortsæt = false; //quit
                    default -> System.out.println("Kom igen");
                }
            } else {
                scanner.nextLine();
            }
        }
    }
    private static void placeOrderUI(Scanner scanner, Menu menu, GemteOrdrer gemteOrdrer) {
        //while ...
        Ordre ordre1 = new Ordre(15, new ArrayList<>(Arrays.asList(
                new OrdreLinje(4, 5),
                new OrdreLinje(4, 6)
        )), "betalt");

        gemteOrdrer.add(ordre1);
    }
}
