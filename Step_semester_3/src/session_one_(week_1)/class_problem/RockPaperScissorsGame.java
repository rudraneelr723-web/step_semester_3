import java.util.Random;
import java.util.Scanner;

public class Q6_RockPaperScissorsGame {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") &&
             computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") &&
             computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") &&
             computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int rounds = 5;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            System.out.print(
                "Enter your move for Round " + (i + 1) +
                " (Rock/Paper/Scissors): "
            );

            String playerMove = scanner.nextLine().trim();

            while (!playerMove.equalsIgnoreCase("Rock") &&
                   !playerMove.equalsIgnoreCase("Paper") &&
                   !playerMove.equalsIgnoreCase("Scissors")) {

                System.out.print(
                    "Invalid move. Enter Rock, Paper, or Scissors: "
                );
                playerMove = scanner.nextLine().trim();
            }

            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println(
                "Round " + (i + 1) +
                " — Player: " + playerMove +
                ", Computer: " + computerMove +
                " | " + result
            );
        }

        double winPercentage = ((double) wins / rounds) * 100;

        System.out.println("\nFinal Summary");
        System.out.printf(
            "%-8s %-15s %-17s %-15s%n",
            "Round", "Player Move", "Computer Move", "Result"
        );

        for (int i = 0; i < rounds; i++) {
            System.out.printf(
                "%-8d %-15s %-17s %-15s%n",
                i + 1, playerMoves[i], computerMoves[i], results[i]
            );
        }

        System.out.printf(
            "%nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
            wins, losses, draws, winPercentage
        );

        scanner.close();
    }
}
