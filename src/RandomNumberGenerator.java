import java.util.Scanner;

public class RandomNumberGenerator {

    static int highGuess = 100, lowGuess = 0;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean tryAgain;
        do {
            resetBounds();
            checkGuess();

            tryAgain = getTryAgain(input);
            RNG.resetCount();

        } while (tryAgain);
        System.out.println("Thanks for playing...");
    }

    static void resetBounds() {
        highGuess = 100;
        lowGuess = 0;
    }

    static void checkGuess() {
        int nextGuess;
        int randNum = RNG.rand();
        System.out.print("Enter your first guess: ");
        do {
            nextGuess = getGuess(randNum, input);
            System.out.println("Number of guesses is " + RNG.getCount());
            if (nextGuess > randNum) {
                System.out.println("Guess is too high, please guess again between " + lowGuess + " and " + highGuess + ".");
            } else if (nextGuess < randNum) {
                System.out.println("Guess is too low, please guess again between " + lowGuess + " and " + highGuess + ".");
            } else {
                System.out.println("Congradulations, you guessed correctly");
            }
        } while(!(nextGuess == randNum));
    }

    static int getGuess(int randNum, Scanner in) {
        int guess;
        do {
            guess = in.nextInt();
        } while (!RNG.inputValidation(guess, lowGuess, highGuess));

        if (guess > randNum && guess < highGuess) {
            highGuess = guess;
        } else if (guess > lowGuess && guess < randNum) {
            lowGuess = guess;
        }
        return guess;
    }

    static boolean getTryAgain(Scanner in) {
        String response;
        do {
            in.nextLine();
            System.out.println("Try Again? (yes or no)");
            response = in.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                return true;
            } else if (response.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Please enter either yes or no");
            }
        } while (true);
    }
}
