package main;

import java.util.HashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult {

    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        driver.addPoints(points);
        results.put(driver, points);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return results;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }
}