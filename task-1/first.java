import java.util.Random;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        System.out.println("Welcome to Guess the Number!");

        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            System.out.println("\nNew Game\n");
            int secretNumber = generateRandomNumber(1, 100);
            int attempts = 0;
            boolean guessed = false;

            while (!guessed) {
                attempts++;
                int guess = getUserGuess();

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.printf("Congratulations! You guessed the number in %d attempts.%n", attempts);
                    score++;
                    guessed = true;
                }

                if (attempts == 10) {
                    System.out.printf("Oops! You reached the maximum number of attempts. The secret number was %d.%n", secretNumber);
                    break;
                }
            }

            playAgain = askToPlayAgain();
        }

        System.out.printf("%nGame Over%nYour score: %d%n", score);
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static int getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess (1-100): ");
        return scanner.nextInt();
    }

    private static boolean askToPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want to play again? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();
        return response.startsWith("y");
    }
}
