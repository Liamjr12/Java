package Fundamentals;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        double loanAmount = readDouble(scanner, "Loan amount: ");
        double interestRate = readDouble(scanner, "Interest rate: ");
        double year = readDouble(scanner, "Year: ");

        System.out.println("\n===== TRANSACTION =====");
        getMonthlyPayment(loanAmount, interestRate, year);
    }

    private static void getMonthlyPayment(double loanAmount, double interestRate, double year) {
        double rate = (interestRate/100)/12;
        double months = year*12;

        double numerator = rate*Math.pow((1+rate), months);
        double denumenator = Math.pow((1+rate), months) - 1;

        double MonthlyPayment = loanAmount*(numerator/denumenator);
        double TotalPayment = MonthlyPayment*months;
        double TotalInterest = TotalPayment - loanAmount;

        System.out.println("Total interest: " + TotalInterest);
        System.out.println("Total payment: " + TotalPayment);
        System.out.println("Montly payment:" + MonthlyPayment);
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