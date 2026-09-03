package OOP.BakingManagementSystem;

import java.util.*;

public class Admin {
    private final Scanner scanner = new Scanner(System.in);

    public void startOperation(Bank bank) {
        while (true) {
            try {
                dashboard();
                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> bank.displayAccountList();
                    case 2 -> createAccount(bank);
                    case 3 -> removeAccount(bank);
                    case 4 -> findAccount(bank);
                    case 5 -> System.out.println("System maintenance");
                    case 6 -> {
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

    private void dashboard() {
        System.out.println("""
        \n*******BANK MANAGEMENT SYSTEM*******
        1. Display accounts
        2. Create account
        3. Remove account
        4. Find account
        5. System maintenance
        6. Exit
        """);
    }

    public void createAccount(Bank bank) {
        try {
            System.out.print("Account Number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Account Password: ");
            String accountPassword = scanner.nextLine();

            Map<Integer, String> account = new HashMap<>();
            account.put(accountNumber, accountPassword);
            bank.addAccount(account);
            System.out.println("The account is successfully added to the bank system.");

        } catch (InputMismatchException e) {
            System.out.println("The input only accepts numbers");
        }
    }

    public void removeAccount(Bank bank) {
        try {
            System.out.print("Enter Account Number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();

            Account account = bank.findAccount(accountNumber);
            bank.removeAccount(account);
            System.out.println("The account is successfully removed.");

        } catch (InputMismatchException e) {
            System.out.println("The input only accepts numbers");
        }
    }

    public void findAccount(Bank bank) {
        try {
            System.out.print("Enter Account Number: ");
            int accountNumber = scanner.nextInt();

            Account a = bank.findAccount(accountNumber);
            if (a == null) {
                System.out.println("Account not found.");
            }
            else {
                System.out.println("Account " + a.getAccountNumber() + " has been found!");
            }
            System.out.println("Account " + a + " has been found!");

        } catch (InputMismatchException e) {
            System.out.println("The input only accepts numbers");
        }
    }
}