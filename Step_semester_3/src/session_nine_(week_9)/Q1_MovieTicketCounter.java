import java.util.Scanner;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;

    protected abstract double getSeatPrice();

    public double calculateAmount(int count) {
        return count * (getSeatPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    protected double getSeatPrice() { return 150.0; }
}

class PremiumTicket extends Ticket {
    protected double getSeatPrice() { return 250.0; }
}

class ReclinerTicket extends Ticket {
    protected double getSeatPrice() { return 400.0; }
}

public class Q1_MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String seat = input[0].toUpperCase();
            int count = Integer.parseInt(input[1]);
            Ticket ticket;

            switch (seat) {
                case "REGULAR": ticket = new RegularTicket(); break;
                case "PREMIUM": ticket = new PremiumTicket(); break;
                case "RECLINER": ticket = new ReclinerTicket(); break;
                default: throw new IllegalArgumentException("Unknown seat type: " + seat);
            }

            double amount = ticket.calculateAmount(count);
            total += amount;
            System.out.printf("%s: %.2f%n", seat, amount);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
