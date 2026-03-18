public class OrdreLinje {
    private int antal;
    private int pizzaNr;

    public OrdreLinje(int antal, int pizzaNr) {
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
