package Fundamentals;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Loan amount: ");
            double loanAmount = Double.parseDouble(scanner.nextLine());

            System.out.print("Interest rate: ");
            double interestRate = Double.parseDouble(scanner.nextLine());

            System.out.print("Year: ");
            double year = Double.parseDouble(scanner.nextLine());

            System.out.println("\n===== TRANSACTION =====");
            getMonthlyPayment(loanAmount, interestRate, year);
            scanner.close();

        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            scanner.close();
        }

    }

    public static void getMonthlyPayment(double loanAmount, double interestRate, double year) {
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

}
