package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void canEnterIf15AndUnder() {
        visitor = new Visitor(10, 250.00, 50.00);
        assertEquals(true, playground.isAllowedTo(visitor));
    }

    @Test
    public void canNotEnterIfOver15() {
        visitor = new Visitor(18, 250.00, 50.00);
        assertEquals(false, playground.isAllowedTo(visitor));
    }
}
