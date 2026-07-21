package Fundamentals;

import java.util.Scanner;

public class ElectricityBillCalculator {
    private static int billCount = 0;
    private static double balance = 0;
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        double[] electricityBill = new double[10];

        while (true) {
            System.out.println("""
            \n******** ELECTRICITY BILL STATUS ********
            1. Calculate bill
            2. Total amount to pay
            3. Pay electricity bill
            4. View highest and lowest bill
            5. Exit""");

            try {
                System.out.print("\nChoice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> insertBill(scanner, electricityBill);
                    case 2 -> System.out.println("Due: " + balance);
                    case 3 -> payBill(scanner, electricityBill);
                    case 4 -> findHighestBill(electricityBill);
                    case 5 -> {
                        System.out.println("Terminating program...");
                        scanner.close();
                        System.out.println("Program terminated");
                        System.exit(0);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new IllegalArgumentException("Returning...");
        }

        if (!input.matches("\\d{1,}")) {
            throw new IllegalArgumentException("Input requires number only");
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The input only accepts numbers");
        }
    }

    private static double insertBill(Scanner scanner, double[] electricityBill) {
        double previousReading = readDouble(scanner, "Previous reading: ");
        double currentReading = readDouble(scanner, "Current reading: ");
        double ratePerKwh = readDouble(scanner, "Rate per kWh: ");

        if (currentReading <= previousReading) {
            throw new IllegalArgumentException("Current reading must be greater than the previous reading.");
        }

        double unitsConsumed = currentReading - previousReading;
        double totalBill = unitsConsumed*ratePerKwh;
        double lateFee = totalBill*0.02;
        double finalBill = totalBill+lateFee;

        System.out.println("\n********* STATUS ********");
        System.out.println("Units consumed: " + unitsConsumed);
        System.out.println("Total bill: " + totalBill);
        System.out.println("Late fee: " + lateFee);
        System.out.println("Final bill: " + finalBill); 

        balance += finalBill;
        return electricityBill[billCount++] = finalBill;
    }

    private static void payBill(Scanner scanner, double[] electricityBill) {
        double payment = readDouble(scanner, "Amount: ");

        if (payment > balance) {
            throw new IllegalArgumentException("Payment exceeds remaining balance");
        }

        balance -= payment;
        System.out.println("Remaining balance: " + balance);
    }

    private static void findHighestBill(double[] electricityBill) {
        double max = electricityBill[0];
        double min = electricityBill[0];

        for (int i = 0; i < billCount; i++) {
            if (electricityBill[i] > max) {
                max = electricityBill[i];
            }
            
            if (electricityBill[i] < min) {
                min = electricityBill[i];
            }
        }
        
        System.out.println("Highest bill: " + max);
        System.out.println("Lowest bill: " + min);
    }

}