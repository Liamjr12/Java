package  OOP.BakingManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        Admin admin = new Admin();
        User user = new User();

        while (true) {
            try {
                System.out.print("""
                \n*******BANK MANAGEMENT SYSTEM*******
                1. User login
                2. Admin login
                3. Exit
                """);
                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> logUser(scanner, bank, user);
                    case 2 -> logAdmin(scanner, bank, admin);
                    case 3 -> {
                        System.out.print("\nSystem terminated");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> throw new IllegalStateException("Invalid choice: " + choice);
                }

            } catch (NumberFormatException e) {
                System.out.println("The input only accepts numbers");
            }
        }
    }

    public static void logUser(Scanner scanner, Bank bank, User user) {
        try {
            System.out.print("Enter Account Number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Account Password: ");
            int accountPassword = scanner.nextInt();

            Account account = bank.findAccount(accountNumber);
            if (account == null) {
                System.out.print("Account not found.\n");
                return;
            }

            if (!account.getAccountPassword().equals(String.valueOf(accountPassword))) {
                System.out.print("Incorrect password.\n");
                return;
            }

            System.out.print("Login successful.\n");
            user.startOperation(account, bank);

        } catch (InputMismatchException e) {
            System.out.println("Invalid user input. Please try again");
        }
    }

    public static void logAdmin(Scanner scanner, Bank bank, Admin admin) {
        try {
            System.out.print("Enter ID Number: ");
            int idNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Admin Password: ");
            String adminPassword = scanner.nextLine();

            int adminID = 12345;
            String password = "admin123";

            if (idNumber != adminID || !adminPassword.equals(password)) {
                System.out.print("Incorrect ID or password.\n");
                return;
            }

            System.out.print("Admin login successful.");
            admin.startOperation(bank);

        } catch (InputMismatchException e) {
            System.out.println("Invalid user input. Please try again");
        }
    }
}