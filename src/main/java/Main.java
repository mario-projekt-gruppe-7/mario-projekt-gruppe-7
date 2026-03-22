public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.bygStandardMenu();
        UI.mainMenu(menu, new GemteOrdrer(menu)); // systemet starter i main menu
    }
}