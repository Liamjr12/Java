package Fundamentals;

import java.util.Scanner;

public class ElectricityBillCalculator {
    public static void main(String[] args) throws Exception{
        final Scanner scanner = new Scanner(System.in);

        double previousReading = readDouble(scanner, "\nPrevious reading: ");
        double currentReading = readDouble(scanner, "Current reading: ");
        double ratePerKwh = readDouble(scanner, "Rate per kWh: ");

        System.out.println("\n===== ELECTRICITY BILL DETAILS =====");
        getElectricityBill(previousReading, currentReading, ratePerKwh);
    }

    private static void getElectricityBill(double previousReading, double currentReading, double ratePerKwh) {
        double unitsConsumed = currentReading - previousReading;
        double totalBill = unitsConsumed*ratePerKwh;
        double lateFee = totalBill*0.02;
        double finalBill = totalBill+lateFee;

        System.out.println("Units consumed: " + unitsConsumed);
        System.out.println("Total bill: " + totalBill);
        System.out.println("Late fee: " + lateFee);
        System.out.println("Final bill: " + finalBill); 
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

}
