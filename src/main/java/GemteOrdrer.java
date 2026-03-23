import java.util.ArrayList;
import java.util.HashMap;

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

    // count if (tæl hvor mange gange en pizza er nævnt i arrayliste gemteordrer)
    public String topTrePizza (){
        HashMap<String, Integer> pizzaScoreTable = new HashMap<>();
        for (Ordre ordre : ordreListe) {
            for (OrdreLinje ordreLinje : ordre.getOrdre()) {
                String pizzaNr = String.valueOf (ordreLinje.getPizzaNr());
                if (pizzaScoreTable.containsKey(pizzaNr)) {
                    pizzaScoreTable.put(pizzaNr, pizzaScoreTable.get(pizzaNr) + ordreLinje.getAntal());
                } else {
                    pizzaScoreTable.put(pizzaNr, ordreLinje.getAntal());
                }
            }
        }
    }
}
