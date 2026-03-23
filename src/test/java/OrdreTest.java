import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrdreTest {

    @Test
    void getAfhentningTidspunkt() {


    }

    @Test
    void getOrdre() {
    }

    @Test
    void antalPizzaer() {

        OrdreLinje ordrelinje = new OrdreLinje(3, 6);
        OrdreLinje ordrelinje2 = new OrdreLinje(4, 9);
        ArrayList<OrdreLinje> liste = new ArrayList<>();
        liste.add(ordrelinje);
        liste.add(ordrelinje2);
        Ordre ordre = new Ordre(10,liste,"");
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
    }
}