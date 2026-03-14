package main;

import java.util.LinkedHashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult {

    private String raceName;
    private String location;
    private Map<Integer, Driver> results = new LinkedHashMap<>();

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(position, driver);
        driver.addPoints(points);
    }

    @Override
    public Map<Integer, Driver> getResults() {
        return results;
    }
}