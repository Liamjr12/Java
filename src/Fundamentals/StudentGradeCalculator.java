package Fundamentals;

import java.util.Scanner;

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

public class StudentGradeCalculator {
    public static void main(String args[]) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        final double passingGrade = 69.99;

        System.out.print("Quiz score: ");
        double quizScore = Double.parseDouble(scanner.nextLine());

        System.out.print("Midterm grade: ");
        double midtermGrade = Double.parseDouble(scanner.nextLine());

        System.out.print("Final grade: ");
        double finalGrade = Double.parseDouble(scanner.nextLine());

        double averageGrade = (quizScore + midtermGrade + finalGrade) / 3;
        System.out.println("Average: " + averageGrade);

        boolean isPassed = (averageGrade < passingGrade) ? false:true;
        System.out.println("Passed: " + isPassed);

        if (averageGrade < 59.99 ) {
            System.out.println("Grade: " + Grade.grade_F);
        } else if (averageGrade >= 59.99 && averageGrade < 69.99) {
            System.out.println("Grade: " + Grade.grade_D);
        } else if (averageGrade >= 69.99 && averageGrade < 79.99) {
            System.out.println("Grade: " + Grade.grade_C);
        } else if (averageGrade >= 79.99 && averageGrade < 89.99) {
            System.out.println("Grade: " + Grade.grade_B);
        } else if (averageGrade >= 89.99 && averageGrade <= 100) {
            System.out.println("Grade: " + Grade.grade_A);
        } else {
            System.out.println("Invalid avarage grade");
        }

        scanner.close();
    }
    
}
