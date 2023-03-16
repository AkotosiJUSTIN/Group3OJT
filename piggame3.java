import java.util.*;

public class realpiggame {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random dice = new Random();
    boolean yourturn = true;
    boolean gameover = false;
    int you = 0;
    int computer = 0;
    int score = 0;
    int roll;

    System.out.println("!!PIG GAME!!");
    System.out.println("Score 100 first before the Computer to win!!");

    while (!gameover) {
      System.out.println((yourturn ? "Your " : "Computer ") + "turn:");

      if (yourturn) {
        do {
          roll = dice.nextInt(6) + 1;

          if (roll == 1) {
            System.out.println("You rolled a 1! Your score is 0.");
            score = 0;
            break;
          }

          System.out.println("You rolled a " + roll + ".");
          score += roll;

          if (you + score >= 100) {
            break;
          }

          System.out.print("Want to roll again? (Y(yes)/N(no)): ");
        } while (input.next().equalsIgnoreCase("y"));

        you += score;
      } else {
        do {
          roll = dice.nextInt(6) + 1;

          if (roll == 1) {
            System.out.println("Computer rolled a 1! Computer's score is 0.");
            score = 0;
            break;
          }

          System.out.println("Computer rolled a " + roll + ".");
          score += roll;

          if (computer + score >= 100) {
            break;
          }
        } while (score < 25);

        computer += score;
      }

      System.out.println("Player 1 score: " + you);
      System.out.println("Computer's score: " + computer);

      if (you >= 100 || computer >= 100) {
        gameover = true;
      } else {
        yourturn = !yourturn;
      }
    }

    System.out.println(
      "Game Over! " + (you >= 100 ? "Player 1" : "Computer") + " wins!"
    );
  }
}
