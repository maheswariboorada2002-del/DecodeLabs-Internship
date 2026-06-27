import java.util.*;

class DecodeLabs_Java_P1 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int round = 0;
        char choice = 'Y';
        while (choice == 'Y' || choice == 'y') {
            int target = rand.nextInt(100) + 1; // Random number between 1 and 100
            int guess = 0;
            int attempts = 0;
            int score = 100;
            System.out.println("==================================");
            System.out.println(" 🎯Welcome to the Number Guessing Game!");
            while (guess != target) {
                System.out.print("Enter your guess(1-100): ");
                try {
                    guess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next(); // Clear the invalid input
                    continue; // Skip the rest of the loop and prompt again
                }
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue; // Skip the rest of the loop and prompt again
                }
                if (guess < target) {
                    System.out.println("Too low");
                } else if (guess > target) {
                    System.out.println("Too high");
                } else {
                    System.out.println("\n🎉 CONGRATULATIONS! 🎉");
                    System.out.println("You guessed the correct number!");
                }
                attempts++;
                score = Math.max(0, 100 - (attempts * 5)); // Decrease score by 5 for each attempt, but not below 0
            }
            System.out.println("Number of attempts: " + attempts);
            System.out.println("Final score: " + score);
            System.out.print("Do you want to play again? (Y/N): ");
            choice = scanner.next().charAt(0);
            round++;
        }
        System.out.println("Round " + round);

        scanner.close();
    }
}