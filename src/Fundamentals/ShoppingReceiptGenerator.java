package Fundamentals;

import java.util.Scanner;

public class ShoppingReceiptGenerator {
    public static void main(String[] args) {
        
        final Scanner scanner = new Scanner(System.in);
        String[] shoppingHistory = new String[10];
        int size = 0;

        while (true) {
            System.out.println("""
            \n******** Shopping Receipt Generator ********
            1. Go shopping
            2. Shopping history
            3. Search receipt
            4. Remove receipt
            5. Exit
            """);

            try {
                System.out.print("Choice: ");
                int choice =  Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> {
                        String value = buyItem(scanner);
                        size = addElementAtLast(shoppingHistory, size, value);
                    }
                    case 2 -> {
                        for (int i = 0; i < size; i++) {
                            System.out.println((i+1) + ".\tRECEIPT:");
                            System.out.println(shoppingHistory[i]);
                        }
                    }
                    case 3 -> {
                        String value = readString(scanner, "Find receipt: ");
                        isFound(shoppingHistory, size, value);
                    }
                    case 4 -> {
                        int index = readInt(scanner, "Index: ");
                        size = removeByIndex(shoppingHistory, size, index);
                    }
                    case 5 -> {
                        scanner.close();
                        System.exit(0);
                    }
                    default -> throw new IllegalArgumentException("The input choices must only contains numbers");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new IllegalArgumentException("Returning...");
        }

        return input;
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new IllegalArgumentException("Returning...");
        }

        if (!input.matches("\\d{1,4}")) {
            throw new IllegalArgumentException("An input must only contain a numbers");
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input must only contains a number");
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Return")) {
            throw new IllegalArgumentException("Returning...");
        }

        if (!input.matches("\\d{1,4}")) {
            throw new IllegalArgumentException("An input must only contain a numbers");
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input must only contains a number");
        }
    }

    private static String buyItem(Scanner scanner) {
        // User input
        String productName = readString(scanner, "Product name: ");
        double productPrice = readDouble(scanner, "Product price: ");
        int productQuantity = readInt(scanner, "Product quantity: ");
        double productDiscount = readDouble(scanner, "Product discount: ");
        double vat = readDouble(scanner, "VAT: ");

        // Calculation
        double discountPercentage = productDiscount/100;
        double VATpercentage = vat/100;

        double subtotal = productPrice*productQuantity;
        double discount = subtotal*discountPercentage;
        double VAT = (subtotal - discount)*VATpercentage;
        double GrandTotal = subtotal - discount + vat;

        // Return values
        return
        "\tProduct name: " + productName +
        "\n\tSubtotal: " + subtotal +
        "\n\tDicount: " + discount +
        "\n\tVAT: " + VAT +
        "\n\tGrandTotal: " + GrandTotal + "\n";
    }

    private static int addElementAtLast(String[] shoppingHistory, int size, String value) {
        shoppingHistory[size] = value;
        return size + 1;
    }

    private static int removeByIndex(String[] shoppingHistory, int size, int index) {
        index -= 1;
        for (int i = index; i < size-1; i++) {
            shoppingHistory[i] = shoppingHistory[i+1];
        }
        return size-1;
    }

    private static boolean isFound(String[] shoppingHistory, int size, String value) {
        for (int i = 0; i < size; i++) {
            if (shoppingHistory != null && shoppingHistory[i].toLowerCase().contains(value.toLowerCase())) {
                System.out.println("The receipt has been found");
                return true;
            }
        }
        System.out.println("Receipt has not been found");
        return false;
    }

}