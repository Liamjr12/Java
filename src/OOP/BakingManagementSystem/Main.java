package OOP.BakingManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final User user = new User();
        final Admin admin = new Admin();

        while (true) {
            try {
                System.out.print("""
                        \n*******BANK MANAGEMENT SYSTEM*******
                        1. Login as user
                        2. Login as Admin
                        3. Exit
                        
                        Choice:""");

                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1 -> user.startOperation();
                    case 2 -> admin.startOperation();
                    case 3 -> {
                        System.out.print("Terminating program\n");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choices. Please select the following available numbers");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}