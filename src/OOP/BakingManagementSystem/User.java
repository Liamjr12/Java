package OOP.BakingManagementSystem;

import java.util.*;

public class User {
    final Scanner scanner = new Scanner(System.in);
    private final Bank bank;

    public User(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void startOperation(Bank bank) {
        while (true) {
            try {
                operations();
                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> System.out.println("Balance: Php" + bank.getBalance());
                    case 2 -> withdraw(bank);
                    case 3 -> deposit(bank);
                    case 4 -> transfer(bank);
                    case 5 -> loan(bank);
                    case 6 -> System.out.println("Loan balance: Php" + bank.getLoan());
                    case 7 -> payLoan(bank);
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

    private void withdraw(Bank bank) {
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            bank.withdraw(amount);
            System.out.println("The money has been successfully withdrawn");
        } catch (InputMismatchException e) {
            System.out.println("The input only accepts numbers");
        }
    }

    private void deposit(Bank bank) {
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            bank.deposit(amount);
            System.out.println("The money has been successfully deposited");
        } catch (InputMismatchException e) {
            System.out.println("The input only accepts numbers");
        }
    }

    private void transfer(Bank bank) {
        try {
            System.out.print("Enter Account Number: ");
            int accountNumber = scanner.nextInt();
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            Account account = bank.findAccount(accountNumber);
            bank.transfer(account, amount);

            System.out.println("Transfer completed");
        } catch (InputMismatchException e) {
            System.out.println("The input you've typed is invalid. Please try again");
        }
    }

    private void loan(Bank bank) {
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextInt();
            bank.setLoan(amount);
            System.out.println("You've successfully loaned Php" + bank.getLoan() + ", please pay it on time.");
        } catch (InputMismatchException e) {
            System.out.println("The input you've typed is invalid. Please try again");
        }
    }

    private void payLoan(Bank bank) {
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            bank.payLoan(amount);
            System.out.println("You've successfully paid the load. Check for the loan balance to confirm");
        } catch (InputMismatchException e) {
            System.out.println("The input you've typed is invalid. Please try again");
        }
    }
}