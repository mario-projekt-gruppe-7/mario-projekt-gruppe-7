package model;

import java.util.HashMap;
import UI.Styles;

public class GemteOrdrer {
    private HashMap<Integer, Ordre> ordreListe;
    private int nextId;

    public GemteOrdrer() {
        this.ordreListe = new HashMap<>();
        this.nextId = 0;
    }

    public Ordre getOrdreFraID (int id) {
        return ordreListe.get(id);
    }


    private Integer nextId() {
        Integer ID = nextId;
        nextId ++;
        return ID;
    }

    public void færdigørOrdre(int ordreID) {
        ordreListe.get(ordreID).færdigOrdre();
    }

    public double omsætning () {
        double omsætning = 0;
        for (Ordre ordre : ordreListe.values()) {
            if (ordre.isBetalt()) {
                omsætning += ordre.getTotal();
            }
        }
        return omsætning;
    }

    public void tilføjOrdre (Ordre ordre) {
        ordreListe.put(nextId(), ordre);

    }

    @Override
    public String toString (){
        String string = "";
        for (Ordre ordre : ordreListe.values()){
            string += ordre.toString() +"\n";
        }
        return string;
    }

    public String toStringConcise() {   // for færdiggør ordre
        String string = "";

        for (HashMap.Entry<Integer, Ordre> entry : ordreListe.entrySet()) {
            Integer id = entry.getKey();
            Ordre ordre = entry.getValue();

            String betalt = ordre.isBetalt()
                    ? Styles.success("betalt")
                    : Styles.error("ikke betalt");

            String status = ordre.getOrdreStatus() == "færdig"
                    ? Styles.success(ordre.getOrdreStatus())
                    : Styles.error(ordre.getOrdreStatus());

            string += String.format("ID: %-5d %-7.2fkr %-40s %-40s\n",
                    id,
                    ordre.getTotal(),
                    betalt,
                    status);
        }

        return string;
    }
}
