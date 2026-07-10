package Fundamentals;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class AgeCalculator {
    enum ageDescription {Minor, Adult;}

    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int birthYear = readInt(scanner, "\nEnter birthyear: ");
                int birthMonth = readInt(scanner, "Enter birthmonth: ");
                int birthDay = readInt(scanner, "Enter birthday: ");

                int age = calculateAge(birthYear, birthMonth, birthDay);
                ageDescription isMinor = (age < 18) ? ageDescription.Minor : ageDescription.Adult;

                System.out.println("\n===== AGE DESCRIPTION =====");
                System.out.println("Age: " + age + "| " + isMinor);
            } catch (DateTimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int calculateAge(int birthYear, int birthMonth, int birthDay) {
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate dayToday = LocalDate.now(); 

        int age = dayToday.getYear() - birthDate.getYear();
        if (age > LocalDate.now().getYear()) {
            throw new DateTimeException("Invalid input");
        }

        return age;
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.length() > 4) {
            throw new DateTimeException("Invalid input");
        }

        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Program terminated.");
            scanner.close();
            System.exit(0);
        }

        return Integer.parseInt(input);
    }
}