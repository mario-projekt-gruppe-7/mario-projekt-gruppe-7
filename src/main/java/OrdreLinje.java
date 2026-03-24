public class OrdreLinje {
    private int antal;
    private int pizzaNr;

    public OrdreLinje(int antal, int pizzaNr) {
        this.antal = antal;
        this.pizzaNr = pizzaNr;
    }

    public int getAntal() {
        return antal;
    }

    public int getPizzaNr() {
        return pizzaNr;
    }

    public double getPris( Menu menu) {
        double pris = 0;
        for (MenuLinje menuLinje : menu.getMenuLinjer()) {
            if (menuLinje.getNr() == pizzaNr) {
                pris = menuLinje.getPris() * antal;
            }
        }
        return pris;
    }
    public String toString(Menu menu) {
        return String.format("%s x %s ... %s kr", antal, pizzaNr, getPris(menu));
    }
}
