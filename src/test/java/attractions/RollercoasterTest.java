package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.00);
    }

    @Test
    public void canRideRollerCoaster() {
        visitor = new Visitor(14, 250.00, 50.00);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canNotRideRollerCoasterFailedOneRequirement() {
        visitor = new Visitor(14, 100.00, 50.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canNotRideRollerCoasterFailedBothRequirements() {
        visitor = new Visitor(10, 100.00, 50.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canChargeDefaultPriceIfHeightUnder200() {
        visitor = new Visitor(14, 140.00, 50.00);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void canChargeDoubleIfHeightOver200() {
        visitor = new Visitor(14, 250.00, 50.00);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }


}
