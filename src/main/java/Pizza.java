import java.util.ArrayList;

public class Pizza {
    private String navn;
    private ArrayList<String> toppings;
    private int nr;
    private double tilberedningsTid;

    public Pizza(String navn, ArrayList<String> toppings, int nr, double pris, double tilberedningsTid) {
        this.navn = navn;
        this.toppings = toppings;
        this.nr = nr;
        this.tilberedningsTid = tilberedningsTid;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public int getNr() {
        return nr;
    }

    public double getTilberedningsTid() {
        return tilberedningsTid;
    }
}
