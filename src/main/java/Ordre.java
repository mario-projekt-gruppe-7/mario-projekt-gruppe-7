import java.util.ArrayList;

public class Ordre {
    private ArrayList<OrdreLinje> ordreLinjer;
    private double afhentningTidspunkt;
    private String ordreStatus;
    private boolean betalt;

    public Ordre(double afhentningTidspunkt, ArrayList<OrdreLinje> ordreLinjer, String ordreStatus) {
        afhentningTidspunkt = afhentningTidspunkt;
        this.ordreLinjer = ordreLinjer;
        this.ordreStatus = ordreStatus;
    }
    public Ordre() {
        afhentningTidspunkt = 0;
        this.ordreLinjer = new ArrayList<>();
        this.ordreStatus = "tilberedes";
        this.betalt = false;
    }

    public void setAfhentningTidspunkt(double afhentningTidspunkt) {
        this.afhentningTidspunkt = afhentningTidspunkt;
    }

    public void betal(){
        betalt = true;
    }

    public void addOrder(OrdreLinje ordreLinje){
        ordreLinjer.add(ordreLinje);
    }

    public void udskydTilFremtiden(double minutter){
        afhentningTidspunkt = minutter;
        ordreStatus = "venter";
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

    public double getTotal() {
        double total = 0;
        for (OrdreLinje ordreLinje : ordreLinjer) {
            total += ordreLinje.getPris();
        }
        return total;
    }
    @Override
    public String toString() {
        String string = "";
        for (OrdreLinje ordrelinje : ordreLinjer) {
            string += ordrelinje.toString() + "\n";
        }
        string += "I alt: " + Double.toString(getTotal()) + "kr\n";
        return string;
    }
}
