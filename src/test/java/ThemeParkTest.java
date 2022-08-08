import attractions.Park;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    ThemePark themePark;
    RollerCoaster rollerCoaster;

    Park park;

    Visitor visitor;


    @Before
    public void before() {
        themePark = new ThemePark("Canada's Wonderland");

    }

    @Test
    public void hasName() {
        assertEquals("Canada's Wonderland", themePark.getName());
    }

    @Test
    public void canAddSights() {
        rollerCoaster = new RollerCoaster("Leviathon", 5);
        park = new Park("Meadows", 4);
        themePark.addSight(rollerCoaster);
        themePark.addSight(park);
        assertEquals(2, themePark.sightCount());
    }

    @Test
    public void canAddAttractionToVisitorsVisitedList() {
        visitor = new Visitor(20, 200, 2000);
        rollerCoaster = new RollerCoaster("Leviathon", 5);
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, visitor.visitedAttractionsCount());
    }

    @Test
    public void canIncrementAttractionVisitCount() {
        visitor = new Visitor(20, 200, 2000);
        rollerCoaster = new RollerCoaster("Leviathon", 5);
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
    }

}
