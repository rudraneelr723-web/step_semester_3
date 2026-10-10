import java.util.Scanner;

abstract class Cab {
    protected final double distanceKm;
    protected Cab(double distanceKm) { this.distanceKm = distanceKm; }
    protected abstract double ratePerKm();
    public double calculateFare() { return Math.max(100.0, distanceKm * ratePerKm()); }
}

interface NightService {
    default double applyNightCharge(double fare) { return fare * 1.20; }
}

class MiniCab extends Cab {
    MiniCab(double km) { super(km); }
    protected double ratePerKm() { return 10.0; }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) { super(km); }
    protected double ratePerKm() { return 14.0; }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) { super(km); }
    protected double ratePerKm() { return 18.0; }
}

public class Q4_CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0].toUpperCase();
            double km = Double.parseDouble(input[1]);
            String time = input[2].toUpperCase();
            Cab cab;
            switch (type) {
                case "MINI": cab = new MiniCab(km); break;
                case "SEDAN": cab = new SedanCab(km); break;
                case "SUV": cab = new SUVCab(km); break;
                default: throw new IllegalArgumentException("Unknown cab type: " + type);
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.calculateFare();
            if (time.equals("NIGHT")) fare = ((NightService) cab).applyNightCharge(fare);
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
