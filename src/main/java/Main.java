public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.bygStandardMenu();
        UI ui = new UI(menu);
        ui.mainMenu();// systemet starter i main menu
    }
}
