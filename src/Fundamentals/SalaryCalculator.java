package Fundamentals;

import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] agrs) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                double hourlyRate = readDouble(scanner, "\nHourly rate: ");
                double hoursWorked = readDouble(scanner, "Hours worked: ");
                double overtimeHours = readDouble(scanner, "Overtime hours: ");
                double taxPercentage = readDouble(scanner, "Tax percentage: ");

                System.out.println("\n===== SALARY DETAILS =====");
                getSalary(hourlyRate, hoursWorked, overtimeHours, taxPercentage);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getSalary(double hourlyRate, double hoursWorked, double overtimeHours, double taxPercentage) {
        double grossSalary = (hourlyRate*hoursWorked) + (overtimeHours*hourlyRate);
        double tax = grossSalary*taxPercentage;
        double netSalary = grossSalary - tax;

        System.out.println("Gross salary: " + grossSalary);
        System.out.println("Tax: " + tax);
        System.out.println("Net salary: " + netSalary);
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (input.matches("\\d{1,4}")) {
            throw new IllegalArgumentException("An input must only contain a numbers");
        }
        
        return Double.parseDouble(input);
    }
}
