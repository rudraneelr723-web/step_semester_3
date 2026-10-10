import java.util.Scanner;

abstract class Appliance {
    protected final double hours;
    protected Appliance(double hours) { this.hours = hours; }
    protected abstract double powerWatts();
    public double calculateUnits() { return powerWatts() * hours / 1000.0; }
    public double calculateCost() { return calculateUnits() * 8.0; }
}

interface SaverMode {
    default double reduceUnitsBySaver(double units) { return units * 0.75; }
}

class Fridge extends Appliance {
    Fridge(double hours) { super(hours); }
    protected double powerWatts() { return 150.0; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) { super(hours); }
    protected double powerWatts() { return 1500.0; }
}

class Television extends Appliance {
    Television(double hours) { super(hours); }
    protected double powerWatts() { return 100.0; }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) { super(hours); }
    protected double powerWatts() { return 500.0; }
}

public class Q5_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0].toUpperCase();
            double hours = Double.parseDouble(input[1]);
            boolean saverRequested = input.length >= 3 && input[2].equalsIgnoreCase("SAVER");
            Appliance appliance;
            switch (type) {
                case "FRIDGE": appliance = new Fridge(hours); break;
                case "AC": appliance = new AirConditioner(hours); break;
                case "TV": appliance = new Television(hours); break;
                case "WASHER": appliance = new WashingMachine(hours); break;
                default: throw new IllegalArgumentException("Unknown appliance: " + type);
            }
            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = appliance.calculateUnits();
            if (saverRequested) {
                units = ((SaverMode) appliance).reduceUnitsBySaver(units);
            }
            double cost = units * 8.0;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
