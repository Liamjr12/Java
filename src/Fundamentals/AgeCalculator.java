package Fundamentals;

import java.time.LocalDate;
import java.util.Scanner;

public class AgeCalculator {
    enum ageDescription {Minor, Adult;}

    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        int birthYear = readInt(scanner, "Enter birthyear: ");
        int birthMonth = readInt(scanner, "Enter birthmonth: ");
        int birthDay = readInt(scanner, "Enter birthday: ");

        int age = calculateAge(birthYear, birthMonth, birthDay);
        ageDescription isMinor = (age < 18) ? ageDescription.Minor : ageDescription.Adult;
        System.out.println("===== AGE DESCRIPTION =====");
        System.out.println("Age: " + age + "| " + isMinor);
    }

    private static int calculateAge(int birthYear, int birthMonth, int birthDay) {
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate dayToday = LocalDate.now(); 

        int age = dayToday.getYear() - birthDate.getYear();
        return age; 
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                scanner.close();
                System.exit(0);
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}