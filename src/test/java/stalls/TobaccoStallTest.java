package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void hasRating() {
        assertEquals(3, tobaccoStall.getRating());
    }

    @Test
    public void isAllowedToTobaccoStall() {
        visitor = new Visitor(20, 200, 2000);
        assertEquals(true, tobaccoStall.isAllowedTo(visitor));
    }

    @Test
    public void isNotAllowedToTobaccoStall() {
        visitor = new Visitor(16, 200, 2000);
        assertEquals(false, tobaccoStall.isAllowedTo(visitor));
    }
}
