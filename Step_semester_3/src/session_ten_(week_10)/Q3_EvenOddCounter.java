import java.util.Scanner;

public class Q3_EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll("[\\[\\],]", " ").trim();
        String[] parts = input.split("\\s+");
        int even = 0, odd = 0;

        for (String part : parts) {
            if (part.isEmpty()) continue;
            int number = Integer.parseInt(part);
            if (number % 2 == 0) even++;
            else odd++;
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
