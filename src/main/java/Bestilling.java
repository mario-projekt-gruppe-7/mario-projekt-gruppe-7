import java.util.ArrayList;

public class Bestilling {
private ArrayList <Ordre> ordrer;
private double AfhentningTidspunkt;
private MenuLinje menuLinje; // ???

    public Bestilling(double afhentningTidspunkt, ArrayList<Ordre> ordrer) {
        AfhentningTidspunkt = afhentningTidspunkt;
        this.ordrer = ordrer;
    }

    //Er det her rigtigt?
    public double getTotalPris(){
        double totalPris = 0;
        for (Ordre ordre : ordrer){
            totalPris += ordre.getPris(menuLinje); // ???
        }
        return totalPris;
    }

    public double getAfhentningTidspunkt() {
        return AfhentningTidspunkt;
    }

    public ArrayList<Ordre> getOrdrer() {
        return ordrer;
    }
}
