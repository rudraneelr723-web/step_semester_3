import java.util.Scanner;

public class Q1_VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int vowels = 0, consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if ("aeiou".indexOf(ch) >= 0) vowels++;
            else if (ch >= 'a' && ch <= 'z') consonants++;
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        sc.close();
    }
}
