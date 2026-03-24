import java.util.ArrayList;


public class GemteOrdrer {
    private ArrayList<Ordre> ordreListe;
    private Menu menu;

    public GemteOrdrer(ArrayList<Ordre> ordreListe, Menu menu) {
        this.ordreListe = ordreListe;
        this.menu = menu;
    }

    public GemteOrdrer(Menu menu) {
        this.menu = menu;
        this.ordreListe = new ArrayList<>();
    }

    public ArrayList<Ordre> getOrdreListe() {
        return ordreListe;
    }

    public double omsætning () {
        double omsætning = 0;
        for (Ordre ordre : ordreListe) {
            if (ordre.getOrdreStatus() == "betalt") {
                omsætning += ordre.getTotal(menu);
            }
        }
        return omsætning;
    }

    public void tilføjOrdre (Ordre ordre) {
        ordreListe.add(ordre);

    }

    public String toString (Menu menu){
        String string = "";
        for (Ordre ordre : ordreListe){
            string += ordre.toString() +"\n";
        }
        return string;
    }


    public String topTrePizza(){
    }
}
