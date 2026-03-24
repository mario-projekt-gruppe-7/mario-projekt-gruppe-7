public class MenuLinje {
    private Pizza pizza;
    private double pris;
    private int nr;
    private int antalSolgtePizza;

    public MenuLinje(Pizza pizza, double pris, int nr) {
        this.pizza = pizza;
        this.pris = pris;
        this.nr = nr;
        antalSolgtePizza = 0;
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

    public String toString (){
        return nr + " " + pizza.getNavn() + pizza.getToppings()+" " + pris + " kr";
    }

    public int getAntalSolgtePizza() {
        return antalSolgtePizza;
    }

    public void øgAntalTotalPizza(int antal){
        antalSolgtePizza += antal;
    }
}
