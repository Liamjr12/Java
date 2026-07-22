package Fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class CarRentalCalculator {
    enum CarType {
        SEDAN, SUV, HATCHBACK, COUPE, CONVERTIBLE, STATION_WAGON, MINIVAN, CROSSOVER, SPORTS_CAR;
    }
    private static int rentalCount = 0;

    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);
        double[] rentalHistory = new double[10];
        String[] rentedCars = new String[10];

        while (true) {
            System.out.println("""
            ******** CAR RENTAL SYSTEM ********
            1. Rent a car
            2. Display rented cars
            3. Display total income
            4. Find most rented car
            5. Exit
            """);

            try {
                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> {
                        if (rentalCount >= rentalHistory.length) {
                            System.out.println("Rental history is full.");
                        } else {
                            rentCar(scanner, rentalHistory, rentedCars);
                        }
                    }
                    case 2 -> displayRentedCars(rentalHistory);
                    case 3 -> displayTotalIncome(rentalHistory);
                    case 4 -> findMostRentedCar(rentedCars);
                    case 5 -> {
                        System.out.println("Thank you for using the Car Rental System.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid menu choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void displayRentedCars(double[] rentalHistory) {
        if (rentalCount == 0) {
            System.out.println("No rentals yet.");
            return;
        }

        for (int i = 0; i < rentalCount; i++) {
            System.out.printf("Rental #%d: %.2f%n", i + 1, rentalHistory[i]);
        }
    }

    private static void displayTotalIncome(double[] rentalHistory) {
        double total = 0;

        for (int i = 0; i < rentalCount; i++) {
            total += rentalHistory[i];
        }

        System.out.printf("Total income: %.2f%n", total);
    }

    private static void rentCar(Scanner scanner, double[] rentalHistory, String[] rentedCars) {
        String selection = readString(scanner, "\nCar types: ");
        int days = readInt(scanner, "Days: ");
        double insurance = readDouble(scanner, "Insurance: ");
        boolean includeDriver = readBoolean(scanner, "Include driver: ");

        double price = getCarType(selection);
        double rentalFee = price * days;
        double insuranceFee = insurance;
        double driverFee = includeDriver ? 500 : 0;
        double grandTotal = rentalFee + insuranceFee + driverFee;

        System.out.println("Rental fee: " + rentalFee);
        System.out.println("Insurance fee: " + insuranceFee);
        System.out.println("Driver fee: " + driverFee);
        System.out.println("Grand total: " + grandTotal);

        rentedCars[rentalCount] = selection.toUpperCase();
        rentalHistory[rentalCount++] = grandTotal;
    }

    private static double getCarType(String selection) {
        try {
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
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid car type");
        }
    }

    private static boolean readBoolean(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.matches(".*[^a-zA-Z].*")) {
            throw new IllegalArgumentException("Input only accepts yes and no");
        }

        if (input.equalsIgnoreCase("Return")) {
            throw new IllegalArgumentException("The input only accepts characters or words");
        }

        if (input.equalsIgnoreCase("Yes")) return true;
        if (input.equalsIgnoreCase("No")) return false;

        throw new IllegalArgumentException("Input only accepts Yes or No.");
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new IllegalArgumentException("The input only accepts characters or words");
        }

        if (!input.matches("\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("Input only accepts any real numbers");
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input only accepts any real numbers");
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new IllegalArgumentException("The input only accepts characters or words");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("Input only accepts any real numbers");
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input only accepts any real numbers");
        }
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new IllegalArgumentException("The input only accepts characters or words");
        }

        if (!input.matches("[a-zA-Z_ ]+")) {
            throw new IllegalArgumentException("Input only accepts letters");
        }

        return input;
    }

    private static void findMostRentedCar(String[] rentedCars) {
        if (rentalCount == 0) {
            System.out.println("No rentals yet.");
            return;
        }

        String[] sortedCars = Arrays.copyOf(rentedCars, rentalCount);
        Arrays.sort(sortedCars);

        String mostRented = sortedCars[0];
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < sortedCars.length; i++) {
            if (sortedCars[i].equals(sortedCars[i - 1])) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostRented = sortedCars[i - 1];
                }
                currentCount = 1;
            }
        }

        // Handle the last group
        if (currentCount > maxCount) {
            maxCount = currentCount;
            mostRented = sortedCars[sortedCars.length - 1];
        }

        System.out.println("Most rented car: " + mostRented);
        System.out.println("Times rented: " + maxCount);
    }
}