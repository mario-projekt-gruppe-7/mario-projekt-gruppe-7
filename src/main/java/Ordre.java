import java.util.ArrayList;

public class Ordre {
    private ArrayList<OrdreLinje> ordreLinjer;
    private double afhentningTidspunkt;
    private String ordreStatus;
    private Menu menu;

    public Ordre(double afhentningTidspunkt, ArrayList<OrdreLinje> ordreLinjer, String ordreStatus, Menu menu) {
        afhentningTidspunkt = afhentningTidspunkt;
        this.ordreLinjer = ordreLinjer;
        this.ordreStatus = ordreStatus;
        this.menu = menu;
    }

    public double getAfhentningTidspunkt() {
        return afhentningTidspunkt;
    }

    public ArrayList<OrdreLinje> getOrdre() {
        return ordreLinjer;
    }

    public int antalPizzaer() {
        int antalPizzaer =0;


        for (OrdreLinje linje : ordreLinjer) {
            antalPizzaer += linje.getAntal();
        }
        return antalPizzaer;
    }

    public String getOrdreStatus() {
        return ordreStatus;
    }

    public double getTotal(Menu menu) {
        double total = 0;
        for (OrdreLinje ordreLinje : ordreLinjer) {
            total += ordreLinje.getPris(menu);
        }
        return total;
    }
    @Override
    public String toString() {
        String string = "";
        for (OrdreLinje ordrelinje : ordreLinjer) {
            string += ordrelinje.toString(menu) + "\n";
        }
        string += "I alt: " + Double.toString(getTotal(menu)) + "kr\n";
        return string;
    }
}
