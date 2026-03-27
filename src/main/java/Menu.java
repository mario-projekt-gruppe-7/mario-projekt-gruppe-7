import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private ArrayList<MenuLinje> pizzaer;

    public Menu() {
        pizzaer = new ArrayList<>();
    }

    public void bygStandardMenu() {
        MenuLinje[] standardPizzaer = {
                new MenuLinje(new Pizza("Margerita", new ArrayList<String>(Arrays.asList("ost", "tomatsovs")), 15.00), 75, 1),
                new MenuLinje(new Pizza("Pepperoni", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni")), 15.00), 85, 2),
                new MenuLinje(new Pizza("Vesuvio", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke")), 15.00), 85, 3),
                new MenuLinje(new Pizza("Amerikaner", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "oksefars", "oregano")), 15.00), 95, 4),
                new MenuLinje(new Pizza("Carbona", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "kødsovs", "spaghetti", "cocktailpølser", "oregano")), 15.00), 100, 5),
                new MenuLinje(new Pizza("Denis", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke", "pepperoni", "cocktailpølser", "oregano")), 15.00), 100, 6),
                new MenuLinje(new Pizza("Berthil", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "bacon", "oregano")), 15.00), 95, 7),
                new MenuLinje(new Pizza("Silvia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni", "rød peber", "løg", "oliven", "oregano")), 15.00), 105, 8),
                new MenuLinje(new Pizza("Victoria", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "skinke", "ananas", "champingon", "løg", "oregano")), 15.00), 100, 9),
                new MenuLinje(new Pizza("Mafia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs", "pepperoni", "bacon", "løg", "oregano")), 15.00), 100, 10)
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

    @Override
    public String toString (){
        String menuStreng = "-------Menu--------\n";
        for (MenuLinje menuLinje : pizzaer) {
            menuStreng += menuLinje + "\n\n";
        }
        return menuStreng;
    }

    public String topSolgtePizzaer(int pizzaerAtVise) {
        Menu sortedMenu = new Menu();
        for (MenuLinje menuLinje: pizzaer) {
            sortedMenu.tilføjMenuLinje(menuLinje);
        }
        sortedMenu.pizzaer.sort((a, b) -> a.getSolgte()- b.getSolgte());

        String string = String.format("De %s mest solgte pizzaer er:\n", pizzaerAtVise);
        List<MenuLinje> topLinjer = sortedMenu.getMenuLinjer().subList( 0, pizzaerAtVise);
        for (MenuLinje menuLinje: topLinjer) {
            string += String.format("%s (%s solgte)\n", menuLinje.getPizza().getNavn(),  menuLinje.getSolgte());
        }
        return string;
    }

    public void setPris(int nummer, double pris) {
        for (MenuLinje menuLinje: pizzaer) {
            if (menuLinje.getNr() == nummer) {
                menuLinje.setPris(pris);
            }
        }
    }
}
