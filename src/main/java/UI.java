import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Menu menu;
    private GemteOrdrer gemteOrdrer;

    public UI (Menu menu) {
        scanner = new Scanner(System.in);
        this.menu = menu;
        gemteOrdrer = new GemteOrdrer(menu);
    }

    void mainMenu() {
        System.out.println("velkommen til Marios Pizza \uD83C\uDF55  \n" +
                "Skriv 0 for exit.\n" +
                "Skriv 1 for opret en ordre\n" +
                "Skriv 2 for at printe menu\n" +
                "Skriv 3 for at printe alle ordrer\n");
        boolean fortsæt = true;
        while(fortsæt) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 3 -> printOrdreLinjer();
                    case 2 -> printMenu();
                    case 1 -> {
                        scanner.nextLine();
                        tilføjOrdre();
                    }
                    case 0 -> fortsæt = false; //quit
                    default -> System.out.println("Kom igen");
                }
            } else {
                scanner.nextLine();
            }
        }
    }

    public void printMenu (){
        System.out.println(menu);
        System.out.println("enter for exit");
        scanner.nextLine();
    }

    public void tilføjOrdre() {
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
        System.out.println(String.format("Du har bestilt: \n %s", ordre + "\nOrdren kan hentes om: " + afhentningstidspunkt+"min\n"));
        gemteOrdrer.tilføjOrdre(ordre);
        System.out.println("enter for exit");
        scanner.nextLine();
    }

    public void printOrdreLinjer (){
        System.out.println(gemteOrdrer.toString(menu));
    }
}
