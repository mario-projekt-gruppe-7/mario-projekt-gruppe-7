import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

public class Ordre {
    private Clock clock;  // bruges for at gøre det muligt at fake tidspunktet, så vi får en deterministisk kode vi kan teste.
    private ArrayList<OrdreLinje> ordreLinjer;
    private LocalDateTime afhentningTidspunkt;
    private String ordreStatus;
    private boolean betalt;

    // constructor anvendes kun til test:
    public Ordre(Duration afhentningsTidsMængde, ArrayList<OrdreLinje> ordreLinjer, String ordreStatus, Clock clock) {
        this.clock = clock;
        this.afhentningTidspunkt = LocalDateTime.now(clock).plus(afhentningsTidsMængde);
        this.ordreLinjer = ordreLinjer;
        this.ordreStatus = ordreStatus;

    }

    public Ordre(Clock clock) {
        this.clock = clock;
        afhentningTidspunkt = LocalDateTime.now(clock);
        this.ordreLinjer = new ArrayList<>();
        this.ordreStatus = "tilberedes";
        this.betalt = false;
    }

    public void setAfhentningTidspunkt(Duration afhentningsTidsMængde) {
        this.afhentningTidspunkt = LocalDateTime.now(clock).plus(afhentningsTidsMængde);
    }

    public void betal(){
        if (!betalt) {
            for (OrdreLinje ordreLinje : ordreLinjer) {
                ordreLinje.sælg();
            }
            betalt = true;
        }
        System.out.println("du har allerede betalt!");
    }

    public void addOrder(OrdreLinje ordreLinje){
        ordreLinjer.add(ordreLinje);
    }

    public void udskydTilFremtiden(Duration afhentningsTidsMængde){
        afhentningTidspunkt = LocalDateTime.now(clock).plus(afhentningsTidsMængde);
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
