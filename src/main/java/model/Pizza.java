package model;

import java.util.ArrayList;

public class Pizza {
    private String navn;
    private ArrayList<String> toppings;
    private double tilberedningsTid;

    public Pizza(String navn, ArrayList<String> toppings, double tilberedningsTid) {
        this.navn = navn;
        this.toppings = toppings;
        this.tilberedningsTid = tilberedningsTid;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public double getTilberedningsTid() {
        return tilberedningsTid;
    }
    @Override
    public String toString() {
        return ("pizza: " + getNavn() + "  tilberedningstid: " + getTilberedningsTid());


    }
}
