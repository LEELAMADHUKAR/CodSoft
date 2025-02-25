import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int start = 1;
        int end = 100;
        int maxAttempts = 10;
        int roundsWon = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = generateRandomNumber(start, end, random);
            System.out.println("\nGuess the number between " + start + " and " + end + ". You have " + maxAttempts + " attempts.");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                attempts++;
                int guess = getUserGuess(scanner);

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    roundsWon++;
                    totalAttempts += attempts;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (!guessedCorrectly && attempts < maxAttempts) {
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nOut of attempts! The correct number was " + targetNumber + ".");
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        if (roundsWon > 0) {
            displayScore(roundsWon, totalAttempts);
        }
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int generateRandomNumber(int start, int end, Random random) {
        return random.nextInt(end - start + 1) + start;
    }

    private static int getUserGuess(Scanner scanner) {
        while (true) {
            System.out.print("Enter your guess: ");
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void displayScore(int roundsWon, int totalAttempts) {
        double averageAttempts = (double) totalAttempts / roundsWon;
        System.out.println("\nGame Over! You won " + roundsWon + " round(s) with an average of " + String.format("%.1f", averageAttempts) + " attempts per win.");
    }
}