import java.util.ArrayList;

public class Ordre {
private ArrayList <OrdreLinje> ordreLinje;
private double afhentningTidspunkt;
private String ordreStatus;

    public Ordre(double afhentningTidspunkt, ArrayList<OrdreLinje> ordreLinje) {
        afhentningTidspunkt = afhentningTidspunkt;
        this.ordreLinje = ordreLinje;
    }

    public double getAfhentningTidspunkt() {
        return afhentningTidspunkt;
    }

    public ArrayList<OrdreLinje> getOrdre() {
        return ordreLinje;
    }
}
