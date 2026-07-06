package Fundamentals;

import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] agrs) {

        final Scanner scanner = new Scanner(System.in);
        final double m = 1.5;

        while (true) {
            try {
                System.out.print("Hourly rate: ");
                double r = Double.parseDouble(scanner.nextLine());

                System.out.print("Hours worked: ");
                double h = Double.parseDouble(scanner.nextLine());

                System.out.print("Overtime hours: ");
                double oh = Double.parseDouble(scanner.nextLine());

                System.out.print("Tax percentage: ");
                double t = Double.parseDouble(scanner.nextLine());
                double tp = t/100;

                System.out.println();

                double GrossSalary = (h*r) + (oh*r*m);
                System.out.println("Gross Salary: " + GrossSalary);

                double Tax = GrossSalary*tp;
                System.out.println("Tax amount: " + Tax);

                double NetSalary = GrossSalary - Tax;
                System.out.println("Net salary: " + NetSalary);
                scanner.close();

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
