package Fundamentals;

import java.util.Scanner;

public class ATMSimulator {
    private static double accountBalance = 0;
    private static int depositCount = 0;
    private static int withdrawnCount = 0;

    public static void main(String[] agrs) {
        final Scanner scanner = new Scanner(System.in);
        double[] deposit = new double[10]; 
        double[] withdraw = new double[10];

        while (true) {
            System.out.println("""
            \n********** ATM SIMULATOR **********
            1. Deposit Transaction
            2. Withdraw Transaction
            3. Display Transaction
            4. Minimum Transaction
            5. Maximum Transaction
            6. View Average Transaction
            7. Check Balance
            8. Exit
            """);

            try {

                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> accountBalance = depositTransaction(scanner, deposit);
                    case 2 -> accountBalance = withdrawTransaction(scanner, withdraw);
                    case 3 -> displayTransactionHistory(deposit, withdraw);
                    case 4 -> System.out.println("Minimum Transaction: " + findMinimumTransaction(deposit, withdraw));
                    case 5 -> System.out.println("Maximum Transaction: " + findMaximumTransaction(deposit, withdraw));
                    case 6 -> System.out.println("Average Transaction: " + findAverageTransaction(deposit, withdraw));
                    case 7 -> System.out.println("Current balance: " + accountBalance);
                    case 8 -> {
                        System.out.println("Terminating program...");
                        scanner.close();
                        System.out.println("Program ended");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid input");
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new RuntimeException("Returning...");
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("The input is only accepting a numbers");
        }
    }

    private static double depositTransaction(Scanner scanner, double[] depositHistory) {
        double deposit = readDouble(scanner, "Deposit: ");
        
        if (deposit <= 0) {
            throw new RuntimeException("You cannot deposit a negative amount");
        }

        accountBalance  += deposit;
        depositHistory[depositCount++] = deposit;
        return accountBalance;
    }

    private static double withdrawTransaction(Scanner scanner, double[] withdrawHistory) {
        double withdraw = readDouble(scanner, "Withdraw: ");

        if (accountBalance <= 0) {
            throw new RuntimeException("Insufficient account balance");
        }

        accountBalance -= withdraw;
        withdrawHistory[withdrawnCount++] = withdraw;
        return accountBalance;
    }

    private static void displayTransactionHistory(double[] depositHistory, double[] withdrawHistory) {
        System.out.println("******* TRANSACTION HISTORY ********");

        int max = Math.max(depositCount, withdrawnCount);
        for (int i = 0; i < max; i++) {
            System.out.println((i + 1) + ". TRANSACTION:");

            if (i < depositCount)
                System.out.println("\tDeposit:    " + depositHistory[i]);
            else
                System.out.println("\tDeposit:    -");

            if (i < withdrawnCount)
                System.out.println("\tWithdrawn:  " + withdrawHistory[i]);
            else
                System.out.println("\tWithdrawn:  -");

            System.out.println();
        }
    }

    private static double findMinimumTransaction(double[] depositHistory, double[] withdrawHistory) {
        double minimumDeposit = depositHistory[0];
        double minimumWithdrawn = withdrawHistory[0];

        for (int i = 0; i < depositCount; i++) {
            if (depositHistory[i] < minimumDeposit) {
                minimumDeposit = depositHistory[i];
            }
        }

        for (int i = 0; i < withdrawnCount; i++) {
            if (withdrawHistory[i] < minimumWithdrawn) {
                minimumWithdrawn = withdrawHistory[i];
            }
        }

        return Math.min(minimumDeposit, minimumWithdrawn);
    }

    private static double findMaximumTransaction(double[] depositHistory, double[] withdrawHistory) {
        double maximumDeposit = depositHistory[0];
        double maximumWithdrawn = withdrawHistory[0];

        for (int i = 0; i < depositCount; i++) {
            if (depositHistory[i] > maximumDeposit) {
                maximumDeposit = depositHistory[i];
            }
        }

        for (int i = 0; i < withdrawnCount; i++) {
            if (withdrawHistory[i] > maximumWithdrawn) {
                maximumWithdrawn = withdrawHistory[i];
            }
        }

        return Math.max(maximumDeposit, maximumWithdrawn);
    }

    private static double findAverageTransaction(double[] depositHistory, double[] withdrawHistory) {
        double depositSum = 0;
        double withdrawSum = 0;
        int count = depositCount + withdrawnCount;

        for (int i = 0; i < depositCount; i++) {
            depositSum += depositHistory[i];
        }

        for (int i = 0; i < withdrawnCount; i++) {
            withdrawSum += withdrawHistory[i];
        }

        double sum = depositSum + withdrawSum;
        return sum / count;
    }
}