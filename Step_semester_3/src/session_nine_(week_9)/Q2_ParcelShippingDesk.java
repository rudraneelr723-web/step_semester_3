import java.util.Scanner;

abstract class Parcel {
    protected final double weightKg;
    protected final double declaredValue;

    protected Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public double calculateInsurance() { return 0.0; }

    public double calculateTotal() { return calculateCharge() + calculateInsurance(); }
}

interface Insurable {
    double INSURANCE_RATE = 0.02;
    double calculateInsurance(double declaredValue);
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) { super(weight, value); }
    public double calculateCharge() { return 40.0 + 10.0 * weightKg; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double value) { super(weight, value); }
    public double calculateCharge() { return 80.0 + 15.0 * weightKg; }
    public double calculateInsurance() { return calculateInsurance(declaredValue); }
    public double calculateInsurance(double value) { return value * INSURANCE_RATE; }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double value) { super(weight, value); }
    public double calculateCharge() { return 40.0 + 10.0 * weightKg + 50.0; }
    public double calculateInsurance() { return calculateInsurance(declaredValue); }
    public double calculateInsurance(double value) { return value * INSURANCE_RATE; }
}

public class Q2_ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0].toUpperCase();
            double weight = Double.parseDouble(input[1]);
            double value = Double.parseDouble(input[2]);
            Parcel parcel;
            switch (type) {
                case "STANDARD": parcel = new StandardParcel(weight, value); break;
                case "EXPRESS": parcel = new ExpressParcel(weight, value); break;
                case "FRAGILE": parcel = new FragileParcel(weight, value); break;
                default: throw new IllegalArgumentException("Unknown parcel type: " + type);
            }
            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
