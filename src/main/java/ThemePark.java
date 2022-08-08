import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark {
    private ArrayList<IReviewed> attractionsAndStalls;
    private String name;

    public ThemePark(String name) {
        this.name = name;
        this.attractionsAndStalls = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return attractionsAndStalls;
    }

    public void addSight(IReviewed sight) {
        attractionsAndStalls.add(sight);
    }

    public int sightCount() {
        return attractionsAndStalls.size();
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addAttraction(attraction);
        attraction.incrementVisitCount();
    }
}
