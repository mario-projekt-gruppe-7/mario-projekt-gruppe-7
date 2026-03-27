package model;

import UI.Styles;

public class MenuLinje {
    private Pizza pizza;
    private double pris;
    private int nr;
    private int solgte;

    public MenuLinje(Pizza pizza, double pris, int nr) {
        this.pizza = pizza;
        this.pris = pris;
        this.nr = nr;
        this.solgte = 0;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getSolgte() {
        return solgte;
    }

    public void sælg(int antal) {
        solgte += antal;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public double getPris() {
        return pris;
    }

    public int getNr() {
        return nr;
    }

    @Override
    public String toString (){

        String toppings = "(";

        for (String topping : pizza.getToppings()) {
            toppings += topping + ", ";
        }
        toppings = toppings.substring(0, toppings.length()-2) + ")";

        String pizzaString = Styles.fed(pizza.getNavn()) + Styles.detalje(toppings);

        return String.format("#%-2s %-92s %6.2f kr", nr, pizzaString, pris);

    }
}
