import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class OrdreLinjeTest {

    @Test
    void getAntal() {
        //Arrange
        int expected = 3;
        OrdreLinje ordreLinje = new OrdreLinje(expected, 2);
        //Act
        int actual = ordreLinje.getAntal();
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPizzaNr() {
        //Arrange
        int expected = 3;
        OrdreLinje ordreLinje = new OrdreLinje(2, expected);
        //Act
        int actual = ordreLinje.getPizzaNr();
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPris() {
        // arrange
        Menu menu = new Menu();
        menu.bygStandardMenu();
        int nr = 2;
        int antal = 3;
        double expected = menu.getMenuLinjer().get(nr).getPris() * antal;
        OrdreLinje ordreLinje = new OrdreLinje(3, nr);
        // act
        double actual = ordreLinje.getPris(menu);
        //assert
        Assertions.assertEquals(expected, actual, 0.00001);
    }
}