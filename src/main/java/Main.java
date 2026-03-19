import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Pizza[] pizzaer = {
                new Pizza("Margerita", new ArrayList<String>(Arrays.asList("ost", "tomatsovs")), 15.00),
                new Pizza("Pepperoni", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni")), 15.00),
                new Pizza("Vesuvio", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke")), 15.00),
                new Pizza("Amerikaner", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "oksefars", "oregano")), 15.00),
                new Pizza("Carbona", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "kødsovs", "spaghetti", "cocktailpølser", "oregano")), 15.00),
                new Pizza("Denis", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke", "pepperoni", "cocktailpølser", "oregano")), 15.00),
                new Pizza("Berthil", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "bacon", "oregano")), 15.00),
                new Pizza("Silvia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni", "rød peber", "løg", "oliven", "oregano")), 15.00),
                new Pizza("Victoria", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke", "ananas", "champingon", "løg", "oregano")), 15.00),
                new Pizza("Mafia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni", "bacon", "løg", "oregano")), 15.00),
        };
        MenuLinje[] menulinjer = new MenuLinje[pizzaer.length];
        for (int i = 0; i < pizzaer.length; i++) {
            menulinjer[i] = new MenuLinje(pizzaer[i], 100, i);
        }
        ;

        Menu menu = new Menu(new ArrayList<>(Arrays.asList(menulinjer)));

        System.out.println("første pizza i menuen er " + menu.getMenuLinjer().getFirst().getPizza().getNavn());


        for (Pizza pizza : pizzaer) {
            System.out.println(pizza);
        }

        Ordre ordre1 = new Ordre(15, new ArrayList<>(Arrays.asList(
                new OrdreLinje(4, 5),
                new OrdreLinje(4, 6)
        )), "betalt");

        OrdreLinje ordreLinje3 = new OrdreLinje(1, 2);
        OrdreLinje ordreLinje4 = new OrdreLinje(3, 4);
        Ordre ordre2 = new Ordre(15, new ArrayList<>(Arrays.asList(ordreLinje3,ordreLinje4)), "ikke betalt");

        System.out.println(ordre1.antalPizzaer());

        GemteOrdrer gemteOrdrer = new GemteOrdrer(new ArrayList<>(Arrays.asList(ordre1, ordre2)), menu);

        System.out.println(gemteOrdrer.omsætning());

        gemteOrdrer.tilføjOrdre(ordre1);

        System.out.println(gemteOrdrer.omsætning());
    }

}