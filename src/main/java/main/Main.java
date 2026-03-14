package main;

public class Main {

    public static void main(String[] args) {

        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelCar = new GravelCar("Toyota", "Yaris", 380);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20", 380);

        Driver d1 = new Driver("Sebastien Ogier", "France", gravelCar);
        Driver d2 = new Driver("Kalle Rovanpera", "Finland", asphaltCar);
        Driver d3 = new Driver("Ott Tanak", "Estonia", gravelCar);
        Driver d4 = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        manager.registerDriver(d1);
        manager.registerDriver(d2);
        manager.registerDriver(d3);
        manager.registerDriver(d4);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyvaskyla");

        race1.recordResult(d1,1,25);
        race1.recordResult(d3,2,18);
        race1.recordResult(d2,3,15);
        race1.recordResult(d4,4,12);

        manager.addRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");

        race2.recordResult(d2,1,25);
        race2.recordResult(d4,2,18);
        race2.recordResult(d1,3,15);
        race2.recordResult(d3,4,12);

        manager.addRaceResult(race2);

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");

        for (Driver d : manager.getDrivers()) {
            System.out.println(d.getName() + " (" + d.getCountry() + "): " + d.getTotalPoints() + " points");
        }

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeader().getName());

        System.out.println("\n===== STATISTICS =====");

        System.out.println("Average Points: " +
                ChampionshipStatistics.averagePoints(manager.getDrivers()));

        System.out.println("Most Successful Country: " +
                ChampionshipStatistics.mostSuccessfulCountry(manager.getDrivers()));

        System.out.println("Total Points: " +
                ChampionshipStatistics.totalPoints(manager.getDrivers()));

        System.out.println("\n===== CAR PERFORMANCE =====");

        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}