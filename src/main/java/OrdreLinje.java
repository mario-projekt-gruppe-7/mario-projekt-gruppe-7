public class OrdreLinje {
    private int antal;
    private MenuLinje menuLinje;

    public OrdreLinje(int antal, MenuLinje menuLinje) {
        this.antal = antal;
        this.menuLinje = menuLinje;
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
        return menuLinje.getPris() * antal;
    }
    public String toString() {
        return String.format("%s x %s ... %s kr", antal, menuLinje.getNr(), getPris());
    }
}
