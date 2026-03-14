package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers;
    private List<RallyRaceResult> races;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRaceResult(RallyRaceResult race) {
        races.add(race);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RallyRaceResult> getRaces() {
        return races;
    }

    public Driver getLeader() {

        Driver leader = null;
        int max = -1;

        for (Driver d : drivers) {
            if (d.getTotalPoints() > max) {
                max = d.getTotalPoints();
                leader = d;
            }
        }

        return leader;
    }
}