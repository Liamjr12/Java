package Fundamentals;

import java.util.Scanner;

public class StudentGradeCalculator {
    enum Grade {
        grade_A('A'), grade_B('B'), grade_C('C'), grade_D('D'), grade_F('F');

        private char type;

        Grade (char type) {
            this.type = type;
        }

        public char getGrade() {
            return type;
        }
    }

    public static void main(String args[]) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("\nStudent name: ");
                String studentName = scanner.nextLine().trim();

                if (studentName.isBlank()) {
                    System.out.println("Please add your product first");
                    continue;
                }

                if (studentName.equalsIgnoreCase("Exit")) {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }

                System.out.print("Quiz score: ");
                int quizScore = readInt(scanner);

                System.out.print("Midterm score: ");
                int midtermScore = readInt(scanner);

                System.out.print("Final score: ");
                int finalScore = readInt(scanner);

                System.out.println("\n===== STUDENT GRADE =====");
                getStudentGrade(studentName, quizScore, midtermScore, finalScore);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static void getStudentGrade(String name, int quizScore, int midtermScore, int finalScore) {
        double average = (quizScore + midtermScore + finalScore) / 3;

        System.out.println("Student name: " + name);
        System.out.println("Average: " + average);

        if (average >= 90 && average <= 100) {
            System.out.println("Passed");
            System.out.println("Grade: " + Grade.grade_A.getGrade());
        } else if (average >= 80 && average < 90) {
            System.out.println("Passed");
            System.out.println("Grade: " + Grade.grade_B.getGrade());
        } else if (average >= 70 && average < 80) {
            System.out.println("Passed");
            System.out.println("Grade: " + Grade.grade_C.getGrade());
        } else if (average >= 60 && average < 70) {
            System.out.println("Passed");
            System.out.println("Grade: " + Grade.grade_D.getGrade());
        } else if (average >= 50 && average < 60) {
            System.out.println("Passed");
            System.out.println("Grade: " + Grade.grade_D.getGrade());
        } else {
            System.out.println("Failed");
            System.out.println("Grade: " + Grade.grade_F.getGrade());
        }
    }

    private static int readInt(Scanner scanner) {
        String input = scanner.nextLine();
        
        if(input.equalsIgnoreCase("Exit")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        int parsedInt = Integer.parseInt(input);
        return parsedInt;
    }
}
