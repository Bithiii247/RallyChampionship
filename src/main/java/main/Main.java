package main;

public class Main {

    public static void main(String[] args) {

        ChampionshipManager manager = ChampionshipManager.getInstance();

        Driver ogier = new Driver("Sebastien Ogier","France",
                new GravelCar("Toyota","Yaris",380));

        Driver rovanpera = new Driver("Kalle Rovanpera","Finland",
                new AsphaltCar("Toyota","Yaris",390));

        Driver tanak = new Driver("Ott Tanak","Estonia",
                new GravelCar("Hyundai","i20",385));

        Driver neuville = new Driver("Thierry Neuville","Belgium",
                new AsphaltCar("Hyundai","i20",395));

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland","Jyväskylä");

        race1.recordResult(ogier,1,25);
        race1.recordResult(tanak,2,18);
        race1.recordResult(rovanpera,3,15);
        race1.recordResult(neuville,4,12);

        manager.addRace(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally","Monaco");

        race2.recordResult(rovanpera,1,25);
        race2.recordResult(neuville,2,18);
        race2.recordResult(ogier,3,15);
        race2.recordResult(tanak,4,12);

        manager.addRace(race2);

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");

        for(Driver d : manager.getDrivers()) {

            System.out.println(
                    d.getName() + " (" + d.getCountry() + "): " + d.getTotalPoints() + " points"
            );
        }

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");

        Driver leader = manager.getLeader();

        System.out.println(
                leader.getName() + " with " + leader.getTotalPoints() + " points"
        );

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");

        System.out.println("Total Drivers: " + manager.getDrivers().size());

        System.out.println("Total Races: " +
                ChampionshipStatistics.totalRaces(manager));

        System.out.println("Average Points Per Driver: " +
                ChampionshipStatistics.averagePoints(manager.getDrivers()));

        System.out.println("Most Successful Country: " +
                ChampionshipStatistics.mostSuccessfulCountry(manager.getDrivers()));

        System.out.println("Total Championship Points: " +
                manager.getTotalPoints());

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");

        System.out.println("Gravel Car Performance: " +
                ogier.getCar().calculatePerformance());

        System.out.println("Asphalt Car Performance: " +
                rovanpera.getCar().calculatePerformance());
    }
}