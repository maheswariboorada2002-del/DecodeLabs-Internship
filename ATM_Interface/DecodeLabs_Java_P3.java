import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class ATM {

    private ArrayList<String> history = new ArrayList<>();

    public void deposit(BankAccount account, Scanner sc) {

        System.out.print("Enter amount to deposit: ");

        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid amount: ");
            sc.next();
        }

        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        account.setBalance(account.getBalance() + amount);

        history.add("Deposited ₹" + amount);

        System.out.println("\nAmount deposited successfully!");
        System.out.println("Current Balance : ₹" + account.getBalance());
    }

    public void withdraw(BankAccount account, Scanner sc) {

        System.out.print("Enter amount to withdraw: ");

        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid amount: ");
            sc.next();
        }

        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Insufficient Balance!");
            return;
        }

        account.setBalance(account.getBalance() - amount);

        history.add("Withdrawn ₹" + amount);

        System.out.println("\nAmount withdrawn successfully!");
        System.out.println("Remaining Balance : " + account.getBalance());
    }

    public void checkBalance(BankAccount account) {

        System.out.println("\nCurrent Balance : " + account.getBalance());
    }

    public void transactionHistory() {

        System.out.println("\n========== Transaction History ==========");

        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : history) {
                System.out.println(transaction);
            }
        }
    }
}

public class DecodeLabs_Java_P3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(5000);

        ATM atm = new ATM();

        int pin = 1234;
        int attempts = 3;

        System.out.println("=======================================");
        System.out.println("         WELCOME TO JAVA ATM");
        System.out.println("=======================================");

        while (attempts > 0) {

            System.out.print("Enter your 4-digit PIN: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid PIN! Enter numbers only: ");
                sc.next();
            }

            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {
                System.out.println("\nLogin Successful!\n");
                break;
            } else {

                attempts--;

                if (attempts == 0) {
                    System.out.println("Too many incorrect attempts.");
                    System.out.println("Your account has been blocked.");
                    sc.close();
                    return;
                }

                System.out.println("Incorrect PIN!");
                System.out.println("Attempts Remaining: " + attempts);
            }
        }

        while (true) {

            System.out.println("\n=======================================");
            System.out.println("               ATM MENU");
            System.out.println("=======================================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid choice! Enter a number: ");
                sc.next();
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    atm.deposit(account, sc);
                    break;

                case 2:
                    atm.withdraw(account, sc);
                    break;

                case 3:
                    atm.checkBalance(account);
                    break;

                case 4:
                    atm.transactionHistory();
                    break;

                case 5:
                    System.out.println("\nThank you for using our ATM!");
                    System.out.println("Have a Great Day!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }
}