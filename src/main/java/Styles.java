public final class Styles {

    private Styles() {} // kan ikke instantieres

    private static final String RESET = "\u001B[0m";
    private static final String FED = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";

    // 256-color palette
    public enum Farve {
        RED(167),        // dusty red
        GREEN(108),      // sage green
        BLUE(110),       // nordic blue
        YELLOW(180),     // sand
        ORANGE(173),     // muted orange
        PINK(181),
        GRAY(246),
        WHITE(252),
        MINT(121),
        SKY(117),
        LAVENDER(183);

        private final String kode;

        Farve(int ansiCode) {
            this.kode = "\u001B[38;5;" + ansiCode + "m";
        }

        private String kode() {
            return kode;
        }
    }

    public static String farve(String text, Farve farve) {
        return farve.kode() + text + RESET;
    }

    public static String fed(String text) {
        return FED + text + RESET;
    }

    public static String underline(String text) {
        return UNDERLINE + text + RESET;
    }



    public static String navigation(String text) {
        return farve(text, Farve.ORANGE);
    }

    public static String success(String text) {
        return farve(text, Farve.GREEN);
    }

    public static String error(String text) {
        return farve(text, Farve.RED);
    }
}