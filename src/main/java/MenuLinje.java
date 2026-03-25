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

    public String toString (){
        return nr + " " + pizza.getNavn() + pizza.getToppings()+" " + pris + " kr";
    }
}
