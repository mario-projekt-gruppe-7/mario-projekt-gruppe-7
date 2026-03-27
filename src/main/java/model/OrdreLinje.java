package model;//public class model.OrdreLinje {
//    private int antal;
//    private model.Pizza pizza;
//    private double pris;
//    private int nr;
//
//
//    public model.OrdreLinje(int antal, model.MenuLinje menuLinje) {
//        this(antal, menuLinje.getPris(), menuLinje.getPizza(), menuLinje.getNr());
//    }
//
//    public model.OrdreLinje(int antal, double pris, model.Pizza pizza, int nr){
//        this.antal = antal;
//        this.pris = pris;
//        this.pizza = pizza;
//        this.nr = nr;
//    }
//
//    public void sælg(model.Menu menu) {
//        for (model.MenuLinje menuLinje: menu.getMenuLinjer()) {
//            if (menuLinje.getNr() == nr) menuLinje.sælg();
//        }
//    }
//
//
//    public int getAntal() {
//        return antal;
//    }
//
//    public model.Pizza getPizza() {
//        return pizza;
//    }
//
//    public double getPris() {
//        return pris * antal;
//    }
//
//    public int getNr() {
//        return nr;
//    }
//
//    public String toString() {
//        return String.format("%s x %s ... %s kr", antal, getNr(), getPris());
//    }
//}

public class OrdreLinje {
    private int antal;
    private MenuLinje menuLinje;
    private double pris;


//    public model.OrdreLinje(int antal, model.MenuLinje menuLinje) {
//        this.antal = antal;
//        this.menuLinje = menuLinje;
//    }

    public OrdreLinje(int antal, MenuLinje menuLinje) {
        this(antal, menuLinje.getPris(), menuLinje);
    }

    public OrdreLinje(int antal, double pris, MenuLinje menuLinje) {
        this.antal = antal;
        this.menuLinje = menuLinje;
        this.pris = pris;
    }

    // metode virker ikke fordi vi mangler reference menuLinje i kopiering
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
        return String.format("%s x %s ... %s kr", antal, menuLinje.getNr(), getPris());
    }
}
