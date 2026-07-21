package Fundamentals;

import java.util.Scanner;

public class LoanCalculator {
    private static int loanCount = 0;
    private static double balance = 0;
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        double[] loans = new double[10];
        
        while (true) {
            System.out.println("""
            \n******** LOANING SYSTEM ********
            1. Loan
            2. Total loan
            3. Due 
            4. Pay loan
            5. Exit""");

            try {
                System.out.print("\nChoice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> insertLoan(scanner, loans);
                    case 2 -> displayLoan(loans);
                    case 3 -> System.out.println("Due: " + balance);
                    case 4 -> payLoan(scanner, loans);
                    case 5 -> {
                        System.out.println("Terminating program...");
                        scanner.close();
                        System.out.println("Program terminated");
                        System.exit(0);
                    }
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

        if (!input.matches("\\d{1,}")) {
            throw new RuntimeException("The input only accepts numbers");
        }

        try {
            return Double.parseDouble(input); 
        } catch (NumberFormatException e) {
            throw new RuntimeException("The input only accepts numbers");
        }
    }

    private static double insertLoan(Scanner scanner, double[] loans) {
        double loanAmount = readDouble(scanner, "Loan amount: ");
        double interestRate = readDouble(scanner, "Interest rate: ");
        double year = readDouble(scanner, "Year: ");

        double rate = (interestRate/100)/12;
        double months = year*12;

        double numerator = rate*Math.pow((1+rate), months);
        double denumenator = Math.pow((1+rate), months) - 1;

        double MonthlyPayment = loanAmount*(numerator/denumenator);
        double TotalPayment = MonthlyPayment*months;
        double TotalInterest = TotalPayment - loanAmount;

        System.out.println("\n******** LOAN STATUS ********");
        System.out.println("Total interest: " + TotalInterest);
        System.out.println("Total payment: " + TotalPayment);
        System.out.println("Montly payment: " + MonthlyPayment);

        balance += TotalPayment;
        return loans[loanCount++] = TotalPayment;
    }

    private static void displayLoan(double[] loans) {
        int count = 1;
        System.out.println("\n******** TOTAL LOANS ********");
        for (int i = 0; i < loanCount; i++) {
            System.out.println((count++) + ". Loan: " + loans[i]);
        }
        System.out.println("Total: " + totalPayment(loans));
    }

    private static double totalPayment (double[] loans) {
        int sum = 0;
        for (int i = 0; i < loanCount; i++) {
            sum += loans[i];
        }
        return sum;
    }

    private static void payLoan(Scanner scanner, double[] loans) {
        double payment = readDouble(scanner, "Amount: ");

        if (payment > balance) {
            throw new RuntimeException("Payment exceeds remaining balance");
        }

        balance -= payment;
        System.out.println("Remaining balance: " + balance);
    }
}