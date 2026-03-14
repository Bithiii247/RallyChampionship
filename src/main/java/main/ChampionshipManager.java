package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if(instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRace(RallyRaceResult race) {
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

        for(Driver d : drivers) {
            if(leader == null || d.getTotalPoints() > leader.getTotalPoints()) {
                leader = d;
            }
        }

        return leader;
    }

    public int getTotalPoints() {

        int total = 0;

        for(Driver d : drivers) {
            total += d.getTotalPoints();
        }

        return total;
    }
}