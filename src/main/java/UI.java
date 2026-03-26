import java.time.Duration;
import java.util.Scanner;

public class UI {
    private Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public String inputString (String brugerInstruks) {
        System.out.println(brugerInstruks);
        return scanner.nextLine();
    }

    public boolean inputBoolean(String brugerInstruks) {
        System.out.println(brugerInstruks);
        while (true) {
            String svar = scanner.nextLine();
            switch (svar) {
                case "ja", "j" -> {
                    return true;
                }
                case "nej", "n" -> {
                    return false;
                }
                default -> System.out.println("skriv ja eller nej");
            }
        }
    }

    public int inputInt (String brugerInstruks) {
        System.out.println(brugerInstruks);
        while (true) {
            if (scanner.hasNextInt()) {
                int returnValue = scanner.nextInt();
                scanner.nextLine();
                return returnValue;
            }
            scanner.nextLine();
            System.out.println("Skriv et heltal");
        }
    }
    public int inputInt () {
        while (true) {
            if (scanner.hasNextInt()) {
                int returnValue = scanner.nextInt();
                scanner.nextLine();
                return returnValue;
            }
            scanner.nextLine();
            System.out.println("Skriv et heltal");
        }
    }

    public double inputDouble(String brugerInstruks) {
        System.out.println(brugerInstruks);
        while (true) {
            if (scanner.hasNextDouble()) {
                double returnValue = scanner.nextDouble();
                scanner.nextLine();
                return returnValue;
            }
            scanner.nextLine();
            System.out.println("Skriv et tal");
        }

    }

    public Duration inputMinutter(String brugerInstruks) {
        System.out.println(brugerInstruks);
        while (true) {
            if (scanner.hasNext()) {
                Duration returnValue = Duration.ofMinutes(scanner.nextInt());
                scanner.nextLine();
                return returnValue;
            }
            scanner.nextLine();
            System.out.println("Skriv et tal");
        }
    }

    public int inputValgmuligheder(String prompt, int min, int max) {
        System.out.println(prompt);
        while (true) {
            int valg = inputInt();
            if (valg >= min && valg <= max) {
                return valg;
            }
            System.out.printf("Ugyldigt valg (skal være mellem %d og %d)%n", min, max);
        }
    }

    public void enterForExit() {
        System.out.println("enter for exit");
        scanner.nextLine();
    }

    public void fortsæt() {
        scanner.nextLine();
    }
}
