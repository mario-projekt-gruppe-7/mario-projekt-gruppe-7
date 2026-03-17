import java.util.ArrayList;

public class Bestillinger {
private ArrayList <Ordre> ordre;
private double AfhentningTidspunkt;

    public Bestillinger(double afhentningTidspunkt, ArrayList<Ordre> ordre) {
        AfhentningTidspunkt = afhentningTidspunkt;
        this.ordre = ordre;
    }

    public double getAfhentningTidspunkt() {
        return AfhentningTidspunkt;
    }

    public ArrayList<Ordre> getOrdre() {
        return ordre;
    }
}
