package Fundamentals;

import java.util.Scanner;

public class CarRentalCalculator {
    enum CarType {
        SEDAN, SUV, HATCHBACK, COUPE, CONVERTIBLE, STATION_WAGON, MINIVAN, CROSSOVER, SPORTS_CAR;
    }

    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String selection = readString(scanner, "\nCar types: ");
                int days = readInt(scanner, "Days: ");
                double insurance = readDouble(scanner, "Insurance: ");
                boolean includeDriver = readBoolean(scanner, "Include driver: ");
                
                System.out.println("\n===== TRANSACTION =====");
                rentCar(selection, days, insurance, includeDriver);

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void rentCar(String type, int days, double insurance, boolean includeDriver) {
        double price = getCarType(type);
        double rentalFee = price*days;
        double insuranceFee = rentalFee - insurance;
        double driverFee = (includeDriver = true) ? rentalFee + 500 : rentalFee;
        double GrandTotal = rentalFee + insuranceFee + driverFee;

        System.out.println("Rental fee: " + rentalFee);
        System.out.println("Insurance fee: " + insuranceFee);
        System.out.println("Driver fee: " + driverFee);
        System.out.println("Grand total: " + GrandTotal);
    }

    private static double getCarType(String selection) {
        CarType types = CarType.valueOf(selection.toUpperCase().trim());

        return switch (types) {
            case SEDAN -> 5000;
            case SUV -> 6000;
            case HATCHBACK -> 7000;
            case COUPE -> 8000;
            case CONVERTIBLE -> 9000;
            case STATION_WAGON -> 10000;
            case MINIVAN -> 11000;
            case CROSSOVER -> 12000;
            case SPORTS_CAR -> 13000;
        };
    }

    private static boolean readBoolean(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.matches(".*[^a-zA-Z].*")) {
            throw new IllegalArgumentException("Input only accepts yes and no");
        }

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if(input.equalsIgnoreCase("Yes")) {
            return true;
        } 

        return false;
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (!input.matches("\\d{1,}*")) {
            throw new IllegalArgumentException("Input only accepts any real numbers");
        }

        return Double.parseDouble(input);
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (!input.matches("\\d{1,}*")) {
            throw new IllegalArgumentException("Input only accepts any real numbers");
        }

        return Integer.parseInt(input);
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        if (!input.matches("[a-zA-Z]")) {
            throw new IllegalArgumentException("Input only accepts letters");
        }

        return input;
    }
}