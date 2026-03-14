package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {

    public static double averagePoints(List<Driver> drivers) {

        int total = 0;

        for(Driver d : drivers) {
            total += d.getTotalPoints();
        }

        return (double) total / drivers.size();
    }

    public static String mostSuccessfulCountry(List<Driver> drivers) {

        Map<String,Integer> countryPoints = new HashMap<>();

        for(Driver d : drivers) {

            countryPoints.put(
                d.getCountry(),
                countryPoints.getOrDefault(d.getCountry(),0) + d.getTotalPoints()
            );
        }

        String bestCountry = "";
        int max = 0;

        for(String country : countryPoints.keySet()) {

            if(countryPoints.get(country) > max) {
                max = countryPoints.get(country);
                bestCountry = country;
            }
        }

        return bestCountry;
    }

    public static int totalRaces(ChampionshipManager manager) {
        return manager.getRaces().size();
    }
}