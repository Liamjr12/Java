package Fundamentals;

import java.util.Scanner;

public class BMICalculator {
    private double weight;
    private double height;
    private double bmi;

    public BMICalculator(double weight, double height, double bmi) {
        this.weight = weight;
        this.height =  height;
        this.bmi = bmi;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBMI() {
        return bmi;
    }

    public static BMICalculator Calculator(Scanner scanner) {
        System.out.print("Weight (kg): ");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.print("Height (cm): ");
        double height = Double.parseDouble(scanner.nextLine());

        double BMI = weight / Math.sqrt(height);
        BMICalculator bmi = new BMICalculator(weight, height, BMI);
        return bmi;
    }

    public static void main(String[] args) {
        
        try {

            Scanner scanner = new Scanner(System.in);
            BMICalculator bmi = BMICalculator.Calculator(scanner);
            System.out.println("BMI: " + bmi.getBMI());
            
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + "\n");
        }

    }

}
