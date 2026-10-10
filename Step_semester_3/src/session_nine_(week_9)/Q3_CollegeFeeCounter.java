import java.util.Scanner;

abstract class Student {
    protected final String name;
    protected Student(String name) { this.name = name; }
    public abstract double tuitionFee();
    public double otherFees() { return 0.0; }
    public double totalFee() { return tuitionFee() + otherFees(); }
}

interface BusUser {
    double TRANSPORT_FEE = 12000.0;
    default double transportFee() { return TRANSPORT_FEE; }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) { super(name); }
    public double tuitionFee() { return 40000.0; }
    public double otherFees() { return transportFee(); }
}

class Hosteller extends Student {
    Hosteller(String name) { super(name); }
    public double tuitionFee() { return 40000.0; }
    public double otherFees() { return 60000.0; }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) { super(name); }
    public double tuitionFee() { return 20000.0; }
    public double otherFees() { return transportFee(); }
}

public class Q3_CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCollected = 0.0;
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0].toUpperCase();
            String name = input[1];
            Student student;
            switch (type) {
                case "DAY_SCHOLAR": student = new DayScholar(name); break;
                case "HOSTELLER": student = new Hosteller(name); break;
                case "SCHOLAR": student = new ScholarshipStudent(name); break;
                default: throw new IllegalArgumentException("Unknown student type: " + type);
            }
            double fee = student.totalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
