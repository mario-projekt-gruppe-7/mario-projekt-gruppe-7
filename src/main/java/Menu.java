import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuLinje> pizzaer;

    public Menu(ArrayList<MenuLinje> pizzaer) {
        this.pizzaer = pizzaer;

    }

    public ArrayList<MenuLinje> getPizzaer() {
        return pizzaer;
    }
}
