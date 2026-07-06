package Fundamentals;

import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);
        double balance = 5000;

        while (true) {
            try {
                System.out.println("""
                ***** ATM Simulator *****
                1. Deposit
                2. Withdraw
                3. Check balance    
                4. Exit
                """);

                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Deposit: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        balance += depositAmount;
                        System.out.println(depositAmount + " amount has been deposited\n");
                    }
                    case 2 -> {
                        System.out.print("Withdraw: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        balance -= withdrawAmount;
                        System.out.println(withdrawAmount + " amount has beed withdrawn\n");
                    } 
                    case 3 -> System.out.println("Current balance: " + balance + "\n");
                    case 4 -> {
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choices\n");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }

    }
}
