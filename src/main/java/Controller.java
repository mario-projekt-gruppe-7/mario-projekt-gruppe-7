// Det er Controller-laget i MVC (model view controller) arkitektur.

import java.time.Clock;

public class Controller {
    private UI ui;
    private Menu menu;
    private GemteOrdrer gemteOrdrer;
    private Clock clock;
    private FasteKunder fasteKunder;

    public Controller(Menu menu, Clock clock) {
        ui = new UI();
        this.menu = menu;
        this.clock = clock;
        gemteOrdrer = new GemteOrdrer();
        this.fasteKunder = new FasteKunder();

    }


    public void start() {
        AsciiPrinter.printColoredFile("src/main/assets/mario.txt");
        mainMenu();
    }

    private void mainMenu() {
        boolean fortsæt = true;
        while (fortsæt) {
            int choice = ui.inputValgmuligheder("velkommen til Marios Pizza \uD83C\uDF55  \n" +
                    Styles.navigation(
                            "[0] exit.\n" +
                                    "[1] opret en ordre\n" +
                                    "[2] print menu\n" +
                                    "[3] print alle ordrer\n" +
                                    "[4] se hele omsætning\n" +
                                    "[5] print top solgte pizzaer\n" +
                                    "[6] færdiggør en ordre\n" + 
                                    "[7] opret en kunde), 0, 7);


            switch (choice) {
                case 0 -> fortsæt = false; //quit
                case 1 -> tilføjOrdre();
                case 2 -> printMenu();
                case 3 -> printOrdreLinjer();
                case 4 -> printOmsætning();
                case 5 -> printTopPizzaer();
                case 6 -> færdigOrdre();
                case 7 -> opretFastKunde();
            }
        }
    }

    private void printOmsætning() {
        System.out.println("hele omsætning: " + gemteOrdrer.omsætning() + " kr");
        ui.enterForExit();
    }

    private void printMenu() {
        System.out.println(menu);

        int beslutningsNummer = ui.inputValgmuligheder(
                Styles.navigation(
                        "[0] exit\n" +
                                "[1] ændre pris"),
                0,
                1
        );

        switch (beslutningsNummer) {
            case 0 -> {
                return;
            }
            case 1 -> redigerMenu();
        }
    }


    private void redigerMenu() {

        int nummer = ui.inputInt("skriv det nummer du gerne vil redigere prisen på");
        double pris = ui.inputDouble("Skriv prisen");

        menu.setPris(nummer, pris);
        for (MenuLinje menuLinje : menu.getMenuLinjer()) {
            if (menuLinje.getNr() == nummer) {
                System.out.println(
                        "du har opdateret prisen på:" +
                                menuLinje.getPizza().getNavn() +
                                "\n" +
                                menu.toString());
            }
        }
    }

    private void tilføjOrdre() {
        boolean flere = true;
        Ordre ordre = new Ordre(clock);
        while (flere) {
            int nummer = ui.inputInt("skriv nummeret på pizzaen du vil have:");
            int antal = ui.inputInt("skriv antallet af pizzaer du vil have: ");
            ordre.addOrder(new OrdreLinje(antal, menu.getMenuLinjer().get(nummer)));
            flere = ui.inputBoolean("Vil du have flere pizzaer? Skriv ja/nej");
        }

        ordre.setAfhentningTidspunkt(ui.inputMinutter("Om hvor mange minutter vil du hente pizzaen?"));
        boolean betalt = ui.inputBoolean("Er ordren betalt? (j/n)");
        if (betalt) ordre.betal();
        System.out.println(Styles.success(String.format(
                "Du har bestilt: \n " +
                        ordre +
                        "\nOrdren kan hentes: " +
                        ordre.getAfhentningTidspunkt() +
                        "\n")));
        gemteOrdrer.tilføjOrdre(ordre);
        ui.enterForExit();
    }

    private void printOrdreLinjer() {
        System.out.println(gemteOrdrer.toString());
        ui.enterForExit();
    }

    private void printTopPizzaer() {
        int antal = 3;
        System.out.println(menu.topSolgtePizzaer(antal));
        ui.enterForExit();
    }

    private void færdigOrdre() {
        System.out.println(gemteOrdrer.toStringConcise());
        int ordreID = ui.inputInt("skriv ID på ordren du vil færdiggøre");
        gemteOrdrer.getOrdreListe().get(ordreID).færdigOrdre();
            System.out.println(Styles.success("Ordren er færdig"));
        }

    private void opretFastKunde(){
        int kundeID = ui.inputInt("Skriv et kundeID");
        String fornavn = ui.inputString("Skriv fornavn på kunde");
        String efternavn = ui.inputString("Skriv efternavn på kunde");
        int telefonNr = ui.inputInt("Skriv telefon nummer på kunde");
        fasteKunder.tilføjKunde(kundeID, fornavn, efternavn, telefonNr);
        System.out.println("kunden er nu gemt :-)");
        ui.enterForExit();
    }
}
