import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private ArrayList<MenuLinje> pizzaer;

    public Menu() {
        pizzaer = new ArrayList<>();
    }

    public void bygStandardMenu() {
        MenuLinje[] standardPizzaer = {
                new MenuLinje(new Pizza("Margerita", new ArrayList<String>(Arrays.asList("ost", "tomatsovs")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Pepperoni", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Vesuvio", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Amerikaner", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "oksefars", "oregano")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Carbona", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "kødsovs", "spaghetti", "cocktailpølser", "oregano")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Denis", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke", "pepperoni", "cocktailpølser", "oregano")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Berthil", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "bacon", "oregano")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Silvia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni", "rød peber", "løg", "oliven", "oregano")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Victoria", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke", "ananas", "champingon", "løg", "oregano")), 15.00), 100, 1),
                new MenuLinje(new Pizza("Mafia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni", "bacon", "løg", "oregano")), 15.00), 100, 1)
        };
        for (MenuLinje menuLinje : standardPizzaer) {
            tilføjMenuLinje(menuLinje);
        }
    }

    public ArrayList<MenuLinje> getMenuLinjer() {
        return pizzaer;
    }

    public void tilføjMenuLinje(MenuLinje menuLinje) {
        pizzaer.add(menuLinje);
    }

}
