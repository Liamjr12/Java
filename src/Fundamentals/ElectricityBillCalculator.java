package Fundamentals;

import java.util.Scanner;

public class ElectricityBillCalculator {

    private double previousReading;
    private double currentReading;
    private double rate;

    public ElectricityBillCalculator(double previousReading, double currentReading, double rate) {
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.rate = rate;
    }

    public double getPreviousReading() {
        return previousReading;
    }

    public double getCurrentReading() {
        return currentReading;
    }

    public double getRate() {
        return rate;
    }
    
    public static String displayBill(Scanner scanner) {
        System.out.print("Previous reading: ");
        double pr = Double.parseDouble(scanner.nextLine());
        System.out.print("Current reading: ");
        double cr = Double.parseDouble(scanner.nextLine());
        System.out.print("Rate per kWh: ");
        double r = Double.parseDouble(scanner.nextLine());

        if (scanner.nextLine().equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
        }

        double unitsConsumed = cr - pr;
        double totalBill = unitsConsumed*r;
        double lateFee = totalBill*1.5;
        double finalBill = totalBill + lateFee;

        return
        "\n===== Electricity Bill =====" + 
        "Units Consumed: " + unitsConsumed +
        "\nTotal Bill: " + totalBill +
        "\nLate Fee: " + lateFee +
        "\nFinal Bill: " + finalBill + "\n";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String bill = ElectricityBillCalculator.displayBill(scanner);
                System.out.println(bill);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                scanner.nextLine();
            }
        }

    }
}