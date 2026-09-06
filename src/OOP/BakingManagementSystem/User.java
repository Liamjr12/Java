package OOP.BakingManagementSystem;

import java.util.Scanner;

public class User {
    private final Account account = new Account();
    private final Admin admin = new Admin();
    private final Scanner scanner = new Scanner(System.in);

    public void startOperation() {
        if (admin.isSystemMaintenance()) {
            System.out.print("The system is currently under maintenance. Please try again later.\n");
            return;
        }

        try {
            System.out.print("""
            \n*******BANK MANAGEMENT SYSTEM*******
            1. Check balance
            2. Withdraw
            3. Deposit
            4. Transfer
            5. Check transaction
            6. Exit
            
            Choice:""");
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch(choice) {
                case 1 -> displayBalance();
                case 2 -> withdraw();
                case 3 -> deposit();
                case 4 -> transfer();
                case 5 -> displayTransaction();
                case 6 -> {
                    System.out.print("Returning\n");
                    return;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid user input. Please try again.");
        }
    }

    public void displayBalance() {
        System.out.println("Balance: " + account.getBalance());
    }

    public void withdraw() {
        double amount = readDouble(scanner);
        account.withdraw(amount);
    }

    public void deposit() {
        double amount = readDouble(scanner);
        account.deposit(amount);
    }

    public void transfer() {
        int accountNumber = readInt(scanner);
        double amount = readDouble(scanner);
        Account receiver = Bank.isFound(accountNumber);
        account.transfer(receiver, amount);
    }

    public void displayTransaction() {
        System.out.print("*******TRANSACTIONS*******\n");
        account.displayTransactions();
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Receiver's Account Number: ");
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("The input is only accepting whole numbers. Please try again");
            }
        }
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter amount: ");
                return Double.parseDouble(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("The input is only accepting decimal numbers. Please try again");
            }
        }
    }
}