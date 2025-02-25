import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to deposit money
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }
}

// Class to represent the ATM
class ATM {
    private final BankAccount bankAccount;

    // Constructor to connect the ATM with the bank account
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to check the balance
    public void checkBalance() {
        double balance = bankAccount.checkBalance();
        System.out.printf("\nYour current balance is: $%.2f\n", balance);
    }

    // Method to deposit money
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (bankAccount.deposit(amount)) {
            System.out.printf("$%.2f has been deposited successfully.\n", amount);
        } else {
            System.out.println("Deposit failed. Please try again.");
        }
    }

    // Method to withdraw money
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (bankAccount.withdraw(amount)) {
            System.out.printf("$%.2f has been withdrawn successfully.\n", amount);
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    // Method to run the ATM interface
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("\nThank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

// Main class to run the program
public class Task3 {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM instance connected to the user's bank account
        ATM atm = new ATM(userAccount);

        // Run the ATM interface
        atm.run();
    }
}