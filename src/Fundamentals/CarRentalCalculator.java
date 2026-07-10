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
                System.out.print("\nCar type: ");
                // Fixing bug...

                System.out.print("Days: ");
                // Fixing bug...

                System.out.print("Insurance: ");
                // Fixing bug...

                System.out.print("Include driver: ");
                boolean includeDriver = readBoolean(scanner);

                // Fixing bug...
                // String line = rentCar(type, days, insurance, includeDriver);
                // System.out.println("\n===== TRANSACTION =====");
                // System.out.println(line.concat("\n"));

                System.out.print("Continue(Yes/No)? ");
                String continueProcess = scanner.nextLine().trim();

                if (continueProcess.equalsIgnoreCase("No")) {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                } 

            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    /*  Fixing bug....
    private static String rentCar(String type, int days, double insurance, boolean includeDriver) {
        double price = carPrice(type);
        double rentalFee = price*days;
        double insuranceFee = rentalFee - insurance;
        double driverFee = (includeDriver = true) ? rentalFee + 500 : rentalFee;
        double GrandTotal = rentalFee + insuranceFee + driverFee;

        return
        "Rental fee: " + rentalFee +
        "\nInsurance fee: " + insuranceFee +
        "\nDriver fee: " + driverFee +
        "\nGrand total: " + GrandTotal;
    }

    private static double carPrice(String type) {
        Scanner scanner = new Scanner(System.in);
        String carTypes = scanner.nextLine().trim().toUpperCase();

        if (carTypes.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        try {
            CarType types = CarType.valueOf(carTypes);

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
            throw new NumberFormatException();
        }
        
    }
    */

    private static boolean readBoolean(Scanner scanner) {
        String input = scanner.nextLine().trim();

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
}
