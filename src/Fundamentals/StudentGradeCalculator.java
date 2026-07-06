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
       //Fixing....
    }
}
