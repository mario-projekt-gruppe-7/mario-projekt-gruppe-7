package model;

import java.util.HashMap;

public class GemteOrdrer {
    private HashMap<Integer, Ordre> ordreListe;
    private int nextId;

    public GemteOrdrer() {
        this.ordreListe = new HashMap<>();
        this.nextId = 0;
    }

    public HashMap<Integer, Ordre> getOrdreListe() {
        return ordreListe;
    }

    private Integer nextId() {
        Integer ID = nextId;
        nextId ++;
        return ID;
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

    public String toStringConcise() {
        String string = "";

        for (HashMap.Entry<Integer, Ordre> entry : ordreListe.entrySet()) {
            Integer id = entry.getKey();
            Ordre ordre = entry.getValue();

            String betalt = ordre.isBetalt()
                    ? "\u001B[32mbetalt\u001B[0m"
                    : "\u001B[31mikke betalt\u001B[0m";

            string += String.format("ID: %-5d %-7.2fkr %-15s%n",
                    id,
                    ordre.getTotal(),
                    betalt);
        }

        return string;
    }
}
