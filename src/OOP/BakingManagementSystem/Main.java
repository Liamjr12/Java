/*package  OOP.BakingManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        Admin admin = new Admin(bank);
        User user = new User(bank);

        while (true) {
            try {
                System.out.print("""
                \n*******BANK MANAGEMENT SYSTEM*******
                1. User login
                2. Admin login
                3. Exit
                """);
                System.out.print("Choice: ");
                int choice = scanner.nextInt();

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
            } catch (InputMismatchException e) {
                System.out.println("The input only accepts numbers");
            }
        }
    }

    public static void logUser(Scanner scanner, Bank bank, User user) {
        try {
            System.out.print("Enter Account Number: ");
            int accountNumber = scanner.nextInt();
            System.out.print("Enter Account Password: ");
            int accountPassword = scanner.nextInt();

            if (!bank.findAccount(accountNumber, accountPassword)) {
                System.out.print("The account doesn't exist in the bank system\n");
                return;
            }

            user.startOperation(bank);
        } catch (InputMismatchException e) {
            System.out.println("Invalid user input. Please try again");
        }
    }

    public static void logAdmin(Scanner scanner, Bank bank, Admin admin) {
        try {
            System.out.print("Enter ID Number: ");
            int idNumber = scanner.nextInt();
            System.out.print("Enter Admin Password: ");
            int adminPassword = scanner.nextInt();

            if (idNumber != 91226 && adminPassword != 1226) {
                System.out.print("The account doesn't exist in the bank system\n");
                return;
            }

            admin.startOperation(bank);
        } catch (InputMismatchException e) {
            System.out.println("Invalid user input. Please try again");
        }
    }
}*/