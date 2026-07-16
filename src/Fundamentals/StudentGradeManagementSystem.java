package Fundamentals;

import java.util.Scanner;

public class StudentGradeManagementSystem {

    private static int studentCount = 0;

    private static void displayDashBoard() {
        System.out.print("""
        \n***** STUDENT GRADE MANAGEMENT SYSTEM *****
        1. Add a student
        2. Display all students
        3. Search student by name
        4. Update student grade
        5. Remove a student    
        6. Statistics
        7. Exit    
        """);
    }

    public static void main(String[] args) {
    
        final Scanner scanner = new Scanner(System.in);
        String[] studentNames = new String[10];
        int[] studentAges = new int[10];
        double[] studentGrades = new double[10];

        while (true) {
            try {
                displayDashBoard();
                System.out.print("\nChoice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch(choice) {
                    case 1 -> addStudent(scanner, studentNames, studentAges, studentGrades);
                    case 2 -> displayStudents(studentNames, studentAges, studentGrades);
                    case 3 -> findStudent(scanner, studentNames);
                    case 4 -> updateStudentStatus(scanner, studentNames, studentGrades);
                    case 5 -> removeStudent(scanner, studentNames, studentAges, studentGrades);
                    case 6 -> studentStatistics(studentNames, studentGrades);
                    case 7 -> {
                        System.out.println("Terminating program");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choices");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }    

    private static void addStudent(Scanner scanner, String[] studentNames, int[] studentAges, double[] studentGrades) {
        if (studentCount >= studentNames.length) {
            throw new RuntimeException("The student list is full");
        }

        String studentName = readString(scanner, "Student name: ");
        int studentAge = readInt(scanner, "Student age: ");
        double studentGrade = readDouble(scanner, "Student grade: ");

        studentNames[studentCount] = studentName;
        studentAges[studentCount] = studentAge;
        studentGrades[studentCount] = studentGrade;

        studentCount++;
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine());
    }

    private static void displayStudents(String[] studentNames, int[] studentAges, double[] studentGrades) {
        if (studentCount == 0) {
            throw new RuntimeException("The list is currently unoccupied");
        }

        System.out.println("\n********** STUDENTS STATUS LIST **********");
        for (int i = 0; i < studentCount; i++) { 
            System.out.println((i+1) + "\tName: " + studentNames[i] +
                                        "\n\tAge: " + studentAges[i] +
                                        "\n\tGrade: " + studentGrades[i] + "\n"
            );
        }
    }

    private static void findStudent(Scanner scanner, String[] studentNames) {
        String studentName = readString(scanner, "Find name: ");

        int left = 0;
        int right = studentCount - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = studentNames[mid].compareTo(studentName);

            if (comparison == 0) {
                System.out.println("Student name has been found");
                return;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println("Student name is not found in the list");
    }

    private static void updateStudentStatus(Scanner scanner, String[] studentNames, double[] studentGrades) {
        String studentName = readString(scanner, "Student name: ");

        for (int i = 0; i < studentCount; i++) {
            if (studentName.equalsIgnoreCase(studentNames[i])) {
                double studentGrade = readDouble(scanner, "Update grade: ");
                studentGrades[i] = studentGrade;
                return;
            } 
        }

        System.out.println("A student has not been found");
    }

    private static void removeStudent(Scanner scanner, String[] studentNames, int[] studentAges, double[] studentGrades) {
        if (studentNames.length < studentCount) {
            throw new RuntimeException("The student list is already empty");
        }

        String studentName = readString(scanner, "Find name: ");
        for (int i = 0; i < studentCount; i++) {
            if (!studentName.equalsIgnoreCase(studentNames[i])) {
                throw new RuntimeException("A student has not been found");
            } 
        }

        System.out.println("A student has been found");
        for (int i = 0; i < studentCount - 1; i++) {
            studentNames[i] = studentNames[i+1];
            studentAges[i] = studentAges[i+1];
            studentGrades[i] = studentGrades[i+1];
        }

        studentNames[studentCount-1] = null;
        studentAges[studentCount-1] = 0;
        studentGrades[studentCount-1] = 0.0;

        studentCount--;
        System.out.println("Student has been removed");
    }

    private static void studentStatistics(String[] studentNames, double[] studentGrades) {
        if (studentCount == 0) {
            System.out.println("The student list is currently empty");
            return;
        }

        String highestStudentName = studentNames[0];
        double highestStudentGrade = studentGrades[0];

        String lowestStudentName = studentNames[0];
        double lowestStudentGrade = studentGrades[0];

        double total = 0.0;

        for (int i = 0; i < studentCount; i++) {
            total += studentGrades[i];
            
            if (studentGrades[i] < lowestStudentGrade) {
                lowestStudentGrade = studentGrades[i];
                lowestStudentName = studentNames[i];
            }

            if (studentGrades[i] > highestStudentGrade) {
                highestStudentGrade = studentGrades[i];
                highestStudentName = studentNames[i];
            }
        }

        double average = total / studentCount;

        System.out.println("Highest: " + highestStudentName + " | " + highestStudentGrade);
        System.out.println("Lowest: " + lowestStudentName + " | " + lowestStudentGrade);
        System.out.println("Average: " + average);
    }
}
