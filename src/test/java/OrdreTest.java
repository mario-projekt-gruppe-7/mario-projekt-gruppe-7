import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class OrdreTest {


    private Ordre ordre;
    private Menu menu;

    @BeforeEach
    void setUp() {
        OrdreLinje ordrelinje = new OrdreLinje(3, menu.getMenuLinjer().get(1));
        OrdreLinje ordrelinje2 = new OrdreLinje(4, menu.getMenuLinjer().get(1));
        ArrayList<OrdreLinje> liste = new ArrayList<>();
        liste.add(ordrelinje);
        liste.add(ordrelinje2);
        ordre = new Ordre( Duration.ofMinutes(0), liste, "");
        menu = new Menu();
        menu.bygStandardMenu();
    }


    @Test
    void getAfhentningTidspunkt() {


    }

    @Test
    void getOrdre() {
    }

    @Test
    void antalPizzaer() {

        // arrange
        int expected = 7;

        //act
        int actual = ordre.antalPizzaer();

        //assert
        Assert.assertEquals(expected, actual);


    }

    @Test
    void getOrdreStatus() {


    }

    @org.junit.jupiter.api.Test
    void getTotal() {

        // arrange
        double expected = 3* menu.getMenuLinjer().get(6).getPris() + 4 * menu.getMenuLinjer().get(9).getPris();

        //act
        double actual = ordre.getTotal();

        //assert
        Assert.assertEquals(expected, actual, 0.0001);


    }
}