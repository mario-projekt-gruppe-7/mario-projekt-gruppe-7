import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OrdreLinjeTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
        menu.bygStandardMenu();
    }

    @Test
    void getAntal() {
        //Arrange
        int expected = 3;
        OrdreLinje ordreLinje = new OrdreLinje(expected, menu.getMenuLinjer().get(1));
        //Act
        int actual = ordreLinje.getAntal();
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getMenuLinje() {
        //Arrange
        OrdreLinje ordreLinje = new OrdreLinje(2, menu.getMenuLinjer().get(1));
        MenuLinje expected = menu.getMenuLinjer().get(1);
        //Act
        MenuLinje actual = ordreLinje.getMenuLinje();
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
        OrdreLinje ordreLinje = new OrdreLinje(3, menu.getMenuLinjer().get(1));
        // act
        double actual = ordreLinje.getPris();
        //assert
        Assertions.assertEquals(expected, actual, 0.00001);
    }
}