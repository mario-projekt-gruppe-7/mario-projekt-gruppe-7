package model;

public class KundeLinje {
    private int kundeID;
    private String fornavn;
    private String efternavn;
    private int telefonNr;

    public KundeLinje(int kundeID, String fornavn, String efternavn, int telefonNr){
        this.kundeID = kundeID;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.telefonNr = telefonNr;
    }

    public int getKundeID() {
        return kundeID;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public int getTelefonNr() {
        return telefonNr;
    }

    public String toString(){
        return String.format("Kunde ID: "+kundeID + "\nNavn: "+ fornavn + " " + efternavn +
                "\nTelefon Nummer: "+ telefonNr);
    }
}
