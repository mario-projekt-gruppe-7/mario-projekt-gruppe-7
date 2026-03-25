import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

public class Ordre {
    private Clock clock;
    private ArrayList<OrdreLinje> ordreLinjer;
    private LocalDateTime afhentningTidspunkt;
    private String ordreStatus;
    private boolean betalt;

    public Ordre(Duration afhentningsTidsMængde, ArrayList<OrdreLinje> ordreLinjer, String ordreStatus) {
        this.afhentningTidspunkt = LocalDateTime.now().plus(afhentningsTidsMængde);
        this.ordreLinjer = ordreLinjer;
        this.ordreStatus = ordreStatus;
    }
    public Ordre() {
        afhentningTidspunkt = LocalDateTime.now();
        this.ordreLinjer = new ArrayList<>();
        this.ordreStatus = "tilberedes";
        this.betalt = false;
    }

    public void setAfhentningTidspunkt(Duration afhentningsTidsMængde) {
        this.afhentningTidspunkt = LocalDateTime.now().plus(afhentningsTidsMængde);
    }

    public void betal(){
        if (!betalt) {
            for (OrdreLinje ordreLinje : ordreLinjer) {
                ordreLinje.sælg();
            }
            betalt = true;
        }
        System.out.println("fejl, du har allerede betalt!");
    }

    public void addOrder(OrdreLinje ordreLinje){
        ordreLinjer.add(ordreLinje);
    }

    public void udskydTilFremtiden(Duration afhentningsTidsMængde){
        afhentningTidspunkt = LocalDateTime.now().plus(afhentningsTidsMængde);
        ordreStatus = "venter";
    }

    public LocalDateTime getAfhentningTidspunkt() {
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

    public boolean isBetalt() {
        return betalt;

    }

    public void setBetalt(boolean betalt) {
        this.betalt = betalt;
    }
}
