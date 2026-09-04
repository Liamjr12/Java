package OOP.BakingManagementSystem;

import java.util.Scanner;

public class Admin {
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt.trim());
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("The input is only accepting numbers. Please try again");
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt.trim());
                return Double.parseDouble(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("The input is only accepting decimal numbers. Please try again");
            }
        }
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt.trim());
        return scanner.nextLine().trim();
    }
}