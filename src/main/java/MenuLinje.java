public class MenuLinje {
    private Pizza pizza;
    private double pris;
    private int nr;

    public MenuLinje(Pizza pizza, double pris, int nr) {
        this.pizza = pizza;
        this.pris = pris;
        this.nr = nr;
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
        return nr + " " + pizza.getNavn() + " " + pris;
    }
}
