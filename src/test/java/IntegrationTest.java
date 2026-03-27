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
        MenuLinje menuLinje = menu.getMenuLinjer().get(0);
        double expected = menuLinje.getPris();
        ordre.addOrder(0, 1, menu);
        gemteOrdrer.tilføjOrdre(ordre);
        //act
        menuLinje.setPris(20);
        double actual = gemteOrdrer.getOrdreFraID(0).getOrdreLinjer().get(0).getPris();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    void menuGetMenuLinjerExposesInternalList() {
        menu.getMenuLinjer().clear();
        assertTrue(menu.getMenuLinjer().isEmpty());
    }

    @Test
    void gemteOrdrerGetOrdreListeExposesInternalMap() {
        gemteOrdrer.tilføjOrdre(ordre);
        assertEquals(1, gemteOrdrer.getOrdreListe().size());

        gemteOrdrer.getOrdreListe().clear();
        assertEquals(0, gemteOrdrer.getOrdreListe().size());
    }

    @Test
    void betalingOpdatererMenuLinjeSolgteViaOrdreLinjeReference() {
        MenuLinje menuLinje = menu.getMenuLinjer().get(2);
        OrdreLinje ordreLinje = new OrdreLinje(2, menuLinje);
        ordre.addOrder(ordreLinje);

        assertEquals(0, menuLinje.getSolgte());

        ordre.betal();

        assertEquals(2, menuLinje.getSolgte());
    }

}