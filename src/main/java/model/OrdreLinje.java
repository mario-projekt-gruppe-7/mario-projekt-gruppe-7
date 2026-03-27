package model;

public class OrdreLinje {
    private int antal;
    private MenuLinje menuLinje;
    private double pris;

    public OrdreLinje(int antal, MenuLinje menuLinje) {
        this(antal, menuLinje.getPris(), menuLinje);
    }

    public OrdreLinje(int antal, double pris, MenuLinje menuLinje) {
        this.antal = antal;
        this.menuLinje = menuLinje;
        this.pris = pris;
    }

    public void sælg() {
        menuLinje.sælg(antal);
    }


    public int getAntal() {
        return antal;
    }

    public MenuLinje getMenuLinje() {
        return menuLinje;
    }

    public double getPris() {
        return pris * antal;
    }
    public String toString() {
        return String.format(
                "%-4d x #%-4d (%-10s ... %6.2f kr)",
                antal,
                menuLinje.getNr(),
                menuLinje.getPizza().getNavn(),
                getPris()
        );
    }
}
