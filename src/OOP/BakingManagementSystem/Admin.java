package OOP.BakingManagementSystem;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {
    private final Bank bank = new Bank();
    private final Scanner scanner = new Scanner(System.in);
    private boolean systemMaintenance = false;

    public Admin () {}

    public void startOperation() {
        try {
            System.out.print("""
            \n*******BANK MANAGEMENT SYSTEM*******
            1. Display accounts
            2. Add account
            3. Remove account
            4. Find account
            5. Enable System Maintenance
            6. Exit
            
            Choice:""");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch(choice) {
                case 1 -> displayAccounts();
                case 2 -> addAccount();
                case 3 -> removeAccount();
                case 4 -> findAccount();
                case 5 -> startSystemMaintenance();
                case 6 -> {
                    System.out.print("Returning\n");
                    return;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid user input. Please try again.");
        }
    }

    public void setSystemMaintenance(boolean systemMaintenance) {
        this.systemMaintenance = systemMaintenance;
    }

    public boolean isSystemMaintenance() {
        return systemMaintenance;
    }

    public void startSystemMaintenance() {
        boolean maintenance = readBoolean(scanner);
        setSystemMaintenance(maintenance);
    }

    public void displayAccounts() {
        bank.displayAccounts();
    }

    public void addAccount() {
        int accountNumber = readInt(scanner);
        String accountPassword = readString(scanner);
        double accountInitialBalance = readDouble(scanner);

        Map<Integer, String> accountDetails = new HashMap<>();
        accountDetails.put(accountNumber, accountPassword);

        bank.addAccount(accountDetails, accountInitialBalance);
    }

    public void removeAccount() {
        int accountNumber = readInt(scanner);
        bank.removeAccount(accountNumber);
    }

    public void findAccount() {
        int accountNumber = readInt(scanner);
        bank.findAccount(accountNumber);
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter Account Number: ".trim());
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("The input is only accepting numbers. Please try again");
            }
        }
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter Initial Balance: ".trim());
                return Double.parseDouble(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("The input is only accepting decimal numbers. Please try again");
            }
        }
    }

    private static String readString(Scanner scanner) {
        System.out.print("Enter Account Password: ".trim());
        return scanner.nextLine().trim();
    }

    private static boolean readBoolean(Scanner scanner) {
        System.out.print("1. Enable Maintenance \n2. Disable Maintenance");
        int choice = readInt(scanner);

        if (choice == 1) {
            return true;
        }
        else if (choice == 2) {
            return false;
        }
        else {
            throw new IllegalArgumentException("Invalid choices. Please try again");
        }
    }
}