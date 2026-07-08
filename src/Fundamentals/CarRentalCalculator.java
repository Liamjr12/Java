package Fundamentals;

import java.util.Scanner;

public class CarRentalCalculator {
    enum CarType {
        SEDAN, SUV, HATCHBACK, COUPE, CONVERTIBLE, STATION_WAGON, MINIVAN, CROSSOVER, SPORTS_CAR;
    }

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("\nCar type: ");
                String type = scanner.nextLine();

                System.out.print("Days: ");
                int days = Integer.parseInt(scanner.nextLine());

                System.out.print("Insurance: ");
                double insurance = Double.parseDouble(scanner.nextLine());

                System.out.print("Include driver: ");
                boolean includeDriver = Boolean.parseBoolean(scanner.nextLine());

                String line = rentCar(type, days, insurance, includeDriver);
                System.out.println("===== TRANSACTION =====");
                System.out.println(line + "\n");

                System.out.print("Continue(Yes/No)? ");
                String continueProcess = scanner.nextLine();

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

    public static String rentCar(String type, int days, double insurance, boolean includeDriver) {
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
        CarType types = CarType.valueOf(type.toUpperCase().trim());

        switch(types) {
            case CarType.SEDAN -> {
                return 5000;
            }
            case CarType.SUV -> {
                return 6000;
            }
            case CarType.HATCHBACK -> {
                return 7000;
            }
            case CarType.COUPE -> {
                return 8000;
            }
            case CarType.CONVERTIBLE -> {
                return 9000;
            }
            case CarType.STATION_WAGON -> {
                return 10000;
            }
            case CarType.MINIVAN -> {
                return 11000;
            }
            case CarType.CROSSOVER -> {
                return 12000;
            } 
            case CarType.SPORTS_CAR -> {
                return 13000;
            }
            default -> System.out.println("Invalid input");
        }

        return 0;
    }

}
