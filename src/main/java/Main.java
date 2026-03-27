import UI.UI;
import model.Menu;

import java.time.Clock;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.bygStandardMenu();
        Controller controller = new Controller(menu, Clock.systemDefaultZone(), new UI());
        controller.start();
    }
}
