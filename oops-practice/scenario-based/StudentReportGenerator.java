import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception 
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

public class StudentReportGenerator {  
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int studentCount = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Enter number of subjects: ");
        int subjectCount = input.nextInt();
        input.nextLine();

        String[] subjects = new String[subjectCount];
        System.out.println("Enter subject names:");
        for (int i = 0; i < subjectCount; i++) {
            subjects[i] = input.nextLine();
        }

        for (int i = 1; i <= studentCount; i++) {
            System.out.println("\nEnter details for Student " + i);
            System.out.print("Name: ");
            String name = input.nextLine();

            int[] marks = new int[subjectCount];
            System.out.println("Enter marks:");

            for (int j = 0; j < subjectCount; j++) {
                System.out.print(subjects[j] + ": ");
                marks[j] = input.nextInt();
            }
            input.nextLine();

            try {
                validateMarks(marks);
                students.add(new Student(name, subjects, marks));
            } catch (InvalidMarkException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Display all report cards 
        for (Student s : students) {
            displayReport(s);
        }

        input.close();
    }
     // Student class 
    static class Student {
        String name;
        String[] subjects;
        int[] marks;

        Student(String name, String[] subjects, int[] marks) {
            this.name = name;
            this.subjects = subjects;
            this.marks = marks;
        }
    }

    // Validate marks 
    static void validateMarks(int[] marks) throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException(
                        "Invalid mark found: " + mark + " (Marks must be 0–100)");
            }
        }
    }

    // Calculate average 
    static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    // Assign grade 
    static String assignGrade(double average) {
        if (average >= 85) return "A";
        else if (average >= 70) return "B";
        else if (average >= 50) return "C";
        else return "Fail";
    }

    // Display report card 
    static void displayReport(Student student) {
        double average = calculateAverage(student.marks);
        String grade = assignGrade(average);

        System.out.println("\n-------------------------------");
        System.out.println("Report Card");
        System.out.println("Student Name : " + student.name);
        System.out.println("-------------------------------");

        for (int i = 0; i < student.subjects.length; i++) {
            System.out.printf("%-10s : %d%n", student.subjects[i], student.marks[i]);
        }

        System.out.println("-------------------------------");
        System.out.printf("Average     : %.2f%n", average);
        System.out.println("Grade       : " + grade);
        System.out.println("-------------------------------");
    }
}
