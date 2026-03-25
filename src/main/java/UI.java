import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Menu menu;
    private GemteOrdrer gemteOrdrer;

    public UI(Menu menu) {
        scanner = new Scanner(System.in);
        this.menu = menu;
        gemteOrdrer = new GemteOrdrer();
    }

    void mainMenu() {
        boolean fortsæt = true;
        boolean showMenu = true;
        while (fortsæt) {
            if (showMenu) {
                System.out.println("velkommen til Marios Pizza \uD83C\uDF55  \n" +
                        "Skriv 0 for exit.\n" +
                        "Skriv 1 for opret en ordre\n" +
                        "Skriv 2 for at printe menu\n" +
                        "Skriv 3 for at printe alle ordrer\n");
            }
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 3 -> {
                        scanner.nextLine();
                        printOrdreLinjer();
                        showMenu = true;
                    }
                    case 2 -> {
                        scanner.nextLine();
                        printMenu();
                        showMenu = true;
                    }
                    case 1 -> {
                        scanner.nextLine();
                        tilføjOrdre();
                        showMenu = true;
                    }
                    case 0 -> fortsæt = false; //quit
                    default -> {
                        scanner.nextLine();
                        System.out.println("Kom igen, skriv et gyldigt tal fra listen");
                        showMenu = false;
                    }
                }
            } else {
                scanner.nextLine();
                System.out.println("Kom igen, skriv et tal");
                showMenu = false;
            }
        }
    }

    public void printMenu() {
        System.out.println(menu);
        System.out.println("enter for exit");




        System.out.println("1 hvis du vil ændre pris");

        int beslutningsNummer;

        while (true) {
            if (scanner.hasNext()) {
                beslutningsNummer = scanner.nextInt();
                scanner.nextLine();
                break;
            }
        }
        switch (beslutningsNummer) {
            case 0-> {
                redigerMenu();
            }
        }
        scanner.nextLine();
    }

    public void redigerMenu() {

        System.out.println("skriv det nummer du gerne vil redigere prisen på");
        int nummer;
        double pris;

        while (true) {
            if (scanner.hasNext()) {
                nummer = scanner.nextInt();
                scanner.nextLine();
                break;
            }
        }
        while (true) {
            if (scanner.hasNext()) {
                pris = scanner.nextDouble();
                scanner.nextLine();
                break;
            }
        }
        menu.setPris(nummer, pris);
        for (MenuLinje menuLinje: menu.getMenuLinjer()) {
            if (menuLinje.getNr() == nummer) {
                System.out.println("du har opdateret prisen på:"+ menuLinje.getPizza().getNavn() +"\n" + menu.toString());
            }
        }

    }

    public void tilføjOrdre() {
        boolean flere = true;
        Ordre ordre = new Ordre();
        while (flere) {
            int nummer;
            int antal;
            System.out.println("skriv nummeret på pizzaen du vil have: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    nummer = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }
                scanner.nextLine();
                System.out.println("skriv et heltal");
            }
            System.out.println("skriv antallet af pizzaer du vil have: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    antal = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }
                scanner.nextLine();
                System.out.println("skriv et heltal");
            }

            System.out.println("Vil du have flere pizzaer? Skriv ja for at bekræfte");
            ordre.addOrder(new OrdreLinje(antal, menu.getMenuLinjer().get(nummer)));
            flere = (scanner.nextLine().equals("ja"));
        }

        System.out.println("Om hvor mange minutter vil du hente pizzaen?");
        while (true) {
            if (scanner.hasNextInt()) {
                ordre.setAfhentningTidspunkt(scanner.nextInt());
                scanner.nextLine();
                break;
            }
            scanner.nextLine();
            System.out.println("skriv et kommatal");
        }

        System.out.println("Er ordren betalt? (j/n)");
        boolean gyldigtSvar = false;
        while (!gyldigtSvar) {
            String svar = scanner.nextLine();
            switch (svar) {
                case "n" -> {
                    ordre.betal();
                    System.out.println("ordren er betalt");
                    gyldigtSvar = true;
                }
                case "j" -> {
                    System.out.println("ordre ikke betalt");
                    gyldigtSvar = true;
                }
                default ->   System.out.println("Skriv j eller n:");
            }
        }
        System.out.println(String.format("Du har bestilt: \n %s", ordre + "\nOrdren kan hentes om: " + ordre.getAfhentningTidspunkt() + "min\n"));
        gemteOrdrer.tilføjOrdre(ordre);
        System.out.println("enter for exit");
        scanner.nextLine();
    }

    public void printOrdreLinjer() {
        System.out.println(gemteOrdrer.toString());
        System.out.println("enter for exit");
        scanner.nextLine();
    }

}
