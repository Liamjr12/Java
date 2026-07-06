package Fundamentals;

import java.time.LocalDate;
import java.util.Scanner;

public class AgeCalculator {
    enum ageDescription {Minor, Senior;}

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter birthyear: ");
                int birthYear = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter birthmonth: ");
                int birthMonth = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter birthday: ");
                int birthDay = Integer.parseInt(scanner.nextLine()); 
                
                int age = calculateAge(birthYear, birthMonth, birthDay);
                String isValid = (age > 18) ? "Age: " + age + "; " + ageDescription.Senior : "Age: " + age + "; " + ageDescription.Minor;

                System.out.println("\n===== AGE DESCRIPTION =====");
                System.out.println(isValid);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                scanner.close();
            }
        }
    }

    public static int calculateAge(int birthYear, int birthMonth, int birthDay) {
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate dayToday = LocalDate.now(); 

        int age = dayToday.getYear() - birthDate.getYear();
        return age; 
    }
}
