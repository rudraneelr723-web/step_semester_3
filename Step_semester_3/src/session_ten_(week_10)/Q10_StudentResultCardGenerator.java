import java.util.Locale;
import java.util.Scanner;

class StudentResult {
    private final String name;
    private final int[] marks;

    StudentResult(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int total = 0;
        for (int mark : marks) total += mark;
        return total / (double) marks.length;
    }

    char grade() {
        double avg = average();
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }

    void printResult() {
        System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n",
                name.toUpperCase(Locale.ROOT), average(), grade());
    }
}

public class Q10_StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = new int[3];
            for (int j = 0; j < marks.length; j++) marks[j] = sc.nextInt();
            new StudentResult(name, marks).printResult();
        }
        sc.close();
    }
}
