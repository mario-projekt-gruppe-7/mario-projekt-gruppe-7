import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static void main(String[] args) {


        Pizza[] pizzaer = {
                new Pizza("Margerita", new ArrayList<String>(Arrays.asList("ost", "tomatsovs")), 90.00, 15.00),
                new Pizza("Pepperoni", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni")), 90.00, 15.00),
                new Pizza("Vesuvio", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke")), 90.00, 15.00),
                new Pizza("Amerikaner", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "oksefars", "oregano")), 90.00, 15.00),
                new Pizza("Carbona", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "kødsovs", "spaghetti", "cocktailpølser", "oregano")), 90.00, 15.00),
                new Pizza("Denis", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke", "pepperoni", "cocktailpølser", "oregano")), 90.00, 15.00),
                new Pizza("Berthil", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "bacon", "oregano")), 90.00, 15.00),
                new Pizza("Silvia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni", "rød peber", "løg", "oliven", "oregano")), 90.00, 15.00),
                new Pizza("Victoria", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke", "ananas", "champingon", "løg", "oregano")), 90.00, 15.00),
                new Pizza("Mafia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni", "bacon", "løg", "oregano")), 90.00, 15.00),
        };
        MenuLinje[] menulinjer = new MenuLinje[pizzaer.length];
        for (int i = 0; i < pizzaer.length; i++) {
            menulinjer[i] = new MenuLinje(pizzaer[i], 100, i);
        }
        ;

        Menu menu = new Menu(new ArrayList<>(Arrays.asList(menulinjer)));

        System.out.println("første pizza i menuen er " + menu.getPizzaer().getFirst().getPizza().getNavn());


        for (Pizza pizza : pizzaer) {
            System.out.println("pizza: " + pizza.getNavn() + "  tilberedningstid: " + pizza.getTilberedningsTid());
        }
    }
}