package Fundamentals;

import java.util.Scanner;

public class BMICalculator {
    enum healthDescription {Underweight, Normal, Overweight, Obese}

    public static void main(String[] args) throws Exception {
    
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                double weight = readDouble(scanner, "\nWeight(kg): ");
                double height = readDouble(scanner, "Height(cm): ");
                double BMI = getBMI(weight, height);

                System.out.println("\n===== BMI Status =====");
                BMIvalidity(BMI);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static double getBMI(double weight, double height) {
        double BMI = (weight*10000) / Math.pow(height, 2);
        return BMI;
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
            throw new IllegalArgumentException("An input must only contains numbers");
        }

        return Double.parseDouble(input);
    }

    private static void BMIvalidity(double BMI) {
        if (BMI >= 0.0 && BMI < 18.50) {
            System.out.println("BMI: " + BMI + "; " + healthDescription.Underweight);
        } else if (BMI >= 18.50 && BMI < 24.90) {
            System.out.println("BMI: " + BMI + "; " + healthDescription.Normal);
        } else if (BMI >= 24.90 && BMI < 29.90) {
            System.out.println("BMI: " + BMI + "; " + healthDescription.Overweight);
        } else if (BMI >= 29.90) {
            System.out.println("BMI: " + BMI + "; " + healthDescription.Obese);
        } else {
            System.out.println("Invalid health description");
        }
    } 

}