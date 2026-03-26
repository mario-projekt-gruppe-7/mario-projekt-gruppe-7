import java.util.ArrayList;

public class FasteKunder {
    private ArrayList<KundeLinje> kundeListe;


    public FasteKunder (){
        this.kundeListe = new ArrayList<>();
    }

    public ArrayList<KundeLinje> getKundeListe() {
        return kundeListe;
    }

    public void tilføjKunde (int kundeID, String fornavn, String efternavn, int telefonNr){
        KundeLinje kundeLinje = new KundeLinje(kundeID, fornavn, efternavn, telefonNr);
        kundeListe.add(kundeLinje);
    }
}
