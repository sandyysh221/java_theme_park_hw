package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(4.50, dodgems.defaultPrice(), 0.00);
    }

    @Test
    public void canChargeHalfPriceIfUnder12() {
        visitor = new Visitor(10, 250.00, 50.00);
        assertEquals(2.25, dodgems.priceFor(visitor), 0.01);
    }

    @Test
    public void canChargeFullPriceIfOver12() {
        visitor = new Visitor(14, 250.00, 50.00);
        assertEquals(4.50, dodgems.priceFor(visitor), 0.01);
    }
}
