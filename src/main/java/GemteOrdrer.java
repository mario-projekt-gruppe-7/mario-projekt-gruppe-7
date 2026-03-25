import java.util.ArrayList;

public class GemteOrdrer {
    private ArrayList<Ordre> ordreListe;

    public GemteOrdrer() {
        this.ordreListe = new ArrayList<>();
    }

    public ArrayList<Ordre> getOrdreListe() {
        return ordreListe;
    }

    public double omsætning () {
        double omsætning = 0;
        for (Ordre ordre : ordreListe) {
            if (ordre.getOrdreStatus() == "betalt") {
                omsætning += ordre.getTotal();
            }
        }
        return omsætning;
    }

    public void tilføjOrdre (Ordre ordre) {
        ordreListe.add(ordre);

    }

    public String toString (){
        String string = "";
        for (Ordre ordre : ordreListe){
            string += ordre.toString() +"\n";
        }
        return string;
    }
}
