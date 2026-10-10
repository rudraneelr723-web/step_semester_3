import java.util.Scanner;
import java.util.Arrays;

public class Q4_InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll("[\\[\\],]", " ").trim();
        if (input.isEmpty()) {
            System.out.println("[]");
            sc.close();
            return;
        }
        String[] parts = input.split("\\s+");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) numbers[i] = Integer.parseInt(parts[i]);

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(numbers));
        sc.close();
    }
}
