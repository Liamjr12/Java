package Fundamentals;

import java.util.Scanner;

public class SalaryCalculator {
    private static int salaryCount = 0;
    public static void main(String[] agrs) throws Exception {

        final Scanner scanner = new Scanner(System.in);
        double[] netSalaryHistory = new double[10];
        double[] taxHistory = new double[10];
        double[] grossSalaryHistory = new double[10];

        while (true) {
            System.out.println("""
            \n******** SALARY TRACKER ********
            1. Calculate salary
            2. Display salary history
            3. Display minimum salary
            4. Display maximum salary
            5. Display average salary
            6. Exit
            """);

            try {
                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> salaryCount = insertSalary(scanner, netSalaryHistory, taxHistory, grossSalaryHistory);
                    case 2 -> displaySalaryHistory(netSalaryHistory, taxHistory, grossSalaryHistory);
                    case 3 -> System.out.println("Minimum salary: " + findMinimumNetSalary(netSalaryHistory));
                    case 4 -> System.out.println("Maximum salary: " + findMaximumSalary(netSalaryHistory));
                    case 5 -> displayAverageSalary(netSalaryHistory);
                    case 6 -> {
                        System.out.println("Terminating program...");
                        scanner.close();
                        System.out.println("Program terminated");
                        System.exit(0);
                    }
                    default -> throw new IllegalArgumentException("The input is invalid");
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
            throw new IllegalArgumentException("Returning...");
        }

        if (!input.matches("\\d{1,}")) {
            throw new IllegalArgumentException("An input must only contain a numbers");
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input only accepts numbers");
        }
    }

    private static int insertSalary(Scanner scanner, double[] netSalaryHistroy, double[] taxHistory, double[] grossSalaryHistory) {
        double hourlyRate = readDouble(scanner, "Hourly rate: ");
        double hoursWorked = readDouble(scanner, "Hours worked: ");
        double overtimedHours = readDouble(scanner, "Overtimed hours: ");
        double taxPercentage = readDouble(scanner, "Tax percentage: ");

        double grossSalary = (hourlyRate*hoursWorked) + (overtimedHours*hourlyRate);
        double tax = grossSalary*(taxPercentage/100);
        double netSalary = grossSalary - tax;

        grossSalaryHistory[salaryCount] = grossSalary;
        taxHistory[salaryCount] = tax;
        netSalaryHistroy[salaryCount] = netSalary;

        return salaryCount + 1;
    }

    private static void displaySalaryHistory(double[] netSalaryHistroy, double[] taxHistory, double[] grossSalaryHistory) {
        for (int i = 0; i < salaryCount; i++) {
            System.out.println((i+1) + ". " + "\tHISTORY:");
            System.out.println(
            "\tGross salary: " + grossSalaryHistory[i] +
            "\n\tTax: " + taxHistory[i] +
            "\n\tNet salary: " + netSalaryHistroy[i] + '\n'
            );
        }
    }

    private static double findMinimumNetSalary(double[] netSalary) {
        double min = netSalary[0];

        for (int i = 0; i < salaryCount; i++) {
            if (netSalary[i] < min) {
                min = netSalary[i];
            }
        }

        return min;
    }

    private static double findMaximumSalary(double[] netSalary) {
        double max = netSalary[0];

        for (int i = 0; i < salaryCount; i++) {
            if (netSalary[i] > max) {
                max = netSalary[i];
            }
        }

        return max;
    }

    private static double displayAverageSalary(double[] netSalary) {
        double sum = 0;
        
        for (int i = 0; i < salaryCount; i++) {
            sum += netSalary[i];
        }

        return sum / netSalary.length;
    }

}
