import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {
    private Menu menu;
    private GemteOrdrer gemteOrdrer;
    private Clock clock;
    private FasteKunder fasteKunder;
    private Ordre ordre;

    @BeforeEach
    void setUp() {
        menu = new Menu();
        menu.bygStandardMenu();
        clock = Clock.fixed(
                Instant.parse("2026-03-27T12:00:00Z"),
                ZoneId.of("UTC")
        );
        fasteKunder = new FasteKunder();
        gemteOrdrer = new GemteOrdrer();
        ordre = new Ordre(clock);
    }

    @Test
    void prisPåOrdreBliverIkkeByttetNårPrisPåPizzaGør() { // reference type fejl
        //arrange
        int nummer = 1;
        MenuLinje menuLinje = menu.getMenuLinjer().get(0);
        double expected = menuLinje.getPris();
        ordre.addOrder(nummer, 1, menu);
        gemteOrdrer.tilføjOrdre(ordre);
        //act
        menuLinje.setPris(20);
        double actual = gemteOrdrer.getOrdreFraID(nummer-1).getOrdreLinjer().get(0).getPris();
        //assert
//        System.out.println("expected:" + expected);
//        System.out.println("actual:" + actual);
        assertEquals(expected, actual);
    }
}