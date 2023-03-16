import java.util.*;

public class realpiggame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int player1Score = 0;
            int player2Score = 0;
            boolean player1Turn = true;
            boolean gameOver = false;

            System.out.println("Welcome to Pig game!");

            while (!gameOver) {
                int roundScore = 0;
                int roll;

                System.out.println("Player " + (player1Turn ? "1" : "2") + "'s turn:");

                if (player1Turn) {
                    do {
                        roll = random.nextInt(6) + 1;

                        if (roll == 1) {
                            System.out.println("You rolled a 1! Round score is 0.");
                            roundScore = 0;
                            break;
                        }

                        System.out.println("You rolled a " + roll + ".");
                        roundScore += roll;

                        if (player1Score + roundScore >= 100) {
                            break;
                        }

                        System.out.print("Roll again? (y/n): ");
                    } while (scanner.next().equalsIgnoreCase("y"));

                    player1Score += roundScore;
                } else {
                    do {
                        roll = random.nextInt(6) + 1;

                        if (roll == 1) {
                            System.out.println("Computer rolled a 1! Round score is 0.");
                            roundScore = 0;
                            break;
                        }

                        System.out.println("Computer rolled a " + roll + ".");
                        roundScore += roll;

                        if (player2Score + roundScore >= 100) {
                            break;
                        }

                    } while (roundScore < 20);

                    player2Score += roundScore;
                }

                System.out.println("Player 1 score: " + player1Score);
                System.out.println("Player 2 score: " + player2Score);

                if (player1Score >= 100 || player2Score >= 100) {
                    gameOver = true;
                } else {
                    player1Turn = !player1Turn;
                }
            }

            System.out.println("Game over! " + (player1Score >= 100 ? "Player 1" : "Computer") + " wins!");
        }!");"
        }
    }
}
