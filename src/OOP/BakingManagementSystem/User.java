package OOP.BakingManagementSystem;

import java.util.*;

public class User {
    final Scanner scanner = new Scanner(System.in);

    public void startOperation(Account account, Bank bank) {
        while (true) {
            try {
                operations();
                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> System.out.println("Balance: Php" + account.getBalance());
                    case 2 -> withdraw(account);
                    case 3 -> deposit(account);
                    case 4 -> transfer(account, bank);
                    case 5 -> makeLoan(account);
                    case 6 -> System.out.println("Loan balance: Php" + account.getLoan());
                    case 7 -> payLoan(account);
                    case 8 -> {
                        System.out.print("Leaving...");
                        return;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                }

            } catch (NumberFormatException e) {
                System.out.println("The system only accepts numbers to do the operations");
            }
        }
    }

    private void operations() {
        System.out.println("""
        \n*******BANK MANAGEMENT SYSTEM*******
        1. Check balance
        2. Withdraw
        3. Deposit
        4. Transfer
        5. Loan
        6. Check loans
        7. Pay loans
        8. Exit
        """);
    }

    private void withdraw(Account account) {
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            account.withdraw(amount);
            System.out.println("The money has been successfully withdrawn");

        } catch (InputMismatchException e) {
            System.out.println("The input only accepts numbers");
        }
    }

    private void deposit(Account account) {
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            account.deposit(amount);
            System.out.println("The money has been successfully deposited");

        } catch (InputMismatchException e) {
            System.out.println("The input only accepts numbers");
        }
    }

    private void transfer(Account sender, Bank bank) {
        try {
            System.out.print("Receiver Account Number: ");
            int accountNumber = scanner.nextInt();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            Account receiver = bank.findAccount(accountNumber);
            if (receiver == null) {
                throw new IllegalArgumentException("Receiver account not found.");
            }

            sender.transfer(receiver, amount);
            System.out.println("Transfer completed");

        } catch (InputMismatchException e) {
            System.out.println("The input you've typed is invalid. Please try again");
        }
    }

    private void makeLoan(Account account) {
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextInt();

            account.makeLoan(amount);
            System.out.println("You've successfully loaned Php" + account.getLoan() + ", please pay it on time.");

        } catch (InputMismatchException e) {
            System.out.println("The input you've typed is invalid. Please try again");
        }
    }

    private void payLoan(Account account) {
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            account.payLoan(amount);
            System.out.println("You've successfully paid the load. Check for the loan balance to confirm");

        } catch (InputMismatchException e) {
            System.out.println("The input you've typed is invalid. Please try again");
        }
    }
}