import java.util.Random;
import java.util.Scanner;

public class CherryNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 1000; // Change this to 1000 as per your description
        int maxAttempts = 5; // Limiting the number of attempts
        int maxRounds = 3; // Adding more rounds
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Cherry'sNumber Game!");

        for (int round = 1; round <= maxRounds; round++) {
            System.out.println("Round " + round);
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int roundScore = 0;

            System.out.println("I have generated a random number between 1 and " + maxRange + " (inclusive).");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    roundScore += maxAttempts - attempts + 1;
                    System.out.println("Congratulations! You guessed the correct number!");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.println("Round " + round + " Score: " + roundScore);
            totalScore += roundScore;
            System.out.println("Total Score: " + totalScore);

            if (round < maxRounds) {
                System.out.print("Do you want to play the next round? (yes/no): ");
                String playNextRound = scanner.next().toLowerCase();
                if (!playNextRound.equals("yes")) {
                    break;
                }
            }
        }

        System.out.println("Thanks for playing Guess the Cherry'sNumber Game! Your final score is: " + totalScore);
        scanner.close();
    }
}
