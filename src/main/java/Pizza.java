import java.util.ArrayList;

public class Pizza {
    private String navn;
    private ArrayList<String> toppings;
    private int nr;
    private double pris;
    private double tilberedningsTid;

    public Pizza(String navn, ArrayList<String> toppings, int nr, double pris, double tilberedningsTid) {
        this.navn = navn;
        this.toppings = toppings;
        this.nr = nr;
        this.pris = pris;
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

    public double getPris() {
        return pris;
    }

    public double getTilberedningsTid() {
        return tilberedningsTid;
    }
}
