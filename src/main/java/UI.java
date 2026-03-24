import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    static private Scanner scanner = new Scanner(System.in);

    static void mainMenu(Menu menu, GemteOrdrer gemteOrdrer) {
        System.out.println("velkommen til Marios Pizza \uD83C\uDF55  \n" +
                "Skriv 0 for exit.\n" +
//                "Skriv 1 UNDER CONSTRUCTION\n" +
                "Skriv 2 for at printe menu\n " +
                "Skriv 3 for opret en ordre\n");
        boolean fortsæt = true;
        while(fortsæt) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 3 -> {
                        scanner.nextLine();
                        tilføjOrdre(menu, gemteOrdrer);
                    }
                    case  2 -> printMenu(menu);
//                    case 1 -> {
//                        placeOrderUI(scanner, menu, gemteOrdrer);
//                        System.out.println("nu har du lavet en ordre");
//                        mainMenu(menu, gemteOrdrer);
//                    }
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
                )), "betalt", menu);
                gemteOrdrer.tilføjOrdre(ordre1);
                System.out.println("din ordre er nu gemt");
            }
        }
    }
    public static void printMenu (Menu menu){
        System.out.println(menu);
    }

    public static void tilføjOrdre(Menu menu, GemteOrdrer gemteOrdrer) {
        boolean flere = true;
        ArrayList<OrdreLinje> ordreLinjer = new ArrayList<>();
        while (flere) {
            int nummer;
            int antal;
            System.out.println("skriv nummeret på pizzaen du vil have: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    nummer = scanner.nextInt() ;
                    scanner.nextLine();
                    break;
                }
                scanner.nextLine();
                System.out.println("skriv et heltal");
            }
            System.out.println("skriv antallet af pizzaer du vil have: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    antal = scanner.nextInt() ;
                    scanner.nextLine();
                    break;
                }
                scanner.nextLine();
                System.out.println("skriv et heltal");
            }

        System.out.println("Vil du have flere pizzaer? Skriv ja for at bekræfte");
        ordreLinjer.add(new OrdreLinje(antal, nummer));
        flere = (scanner.nextLine() .equals("ja"));
    }

        System.out.println("Om hvor mange minutter vil du hente pizzaen?");
        double afhentningstidspunkt;
        while (true) {
            if (scanner.hasNextInt()) {
                afhentningstidspunkt = scanner.nextInt();
                scanner.nextLine();
                break;
            }
            scanner.nextLine();
            System.out.println("skriv et kommatal");
        }

        Ordre ordre = new Ordre(afhentningstidspunkt, ordreLinjer, "oprettet", menu);
        System.out.println(String.format("Du har bestilt: \n %s", ordre));
        gemteOrdrer.tilføjOrdre(ordre);
        mainMenu(menu, gemteOrdrer);
    }
}
