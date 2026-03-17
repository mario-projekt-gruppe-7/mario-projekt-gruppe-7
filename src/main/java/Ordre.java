public class Ordre {
    private int antal;
    private int pizzaNr;

    public Ordre(int antal, int pizzaNr) {
        this.antal = antal;
        this.pizzaNr = pizzaNr;
    }

    public int getAntal() {
        return antal;
    }

    public int getPizzaNr() {
        return pizzaNr;
    }
}
