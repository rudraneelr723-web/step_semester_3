import java.math.BigInteger;
import java.util.Scanner;

public class Q7_FactorialCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid input");
        } else {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println(factorial);
        }
        sc.close();
    }
}
