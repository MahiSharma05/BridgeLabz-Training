class Student {
    String name;
    String rollNumber;
    double mark1;
    double mark2;
    double mark3;

    // Constructor
    Student(String name, String rollNumber, double mark1, double mark2, double mark3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    // Method to calculate grade
    char calculateGrade() {
        double average = (mark1 + mark2 + mark3) / 3;

        if (average >= 80) {
            return 'A';
        } else if (average >= 70) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else {
            return 'D';
        }
    }

    // Method to display student details and grade
    void displayReport() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
    }
}

public class StudentReport {
    public static void main(String[] args) {

        // First student
        Student s1 = new Student("Thamarai", "ECE001", 80.0, 70.0, 75.0);
        s1.displayReport();

        // Second student
        Student s2 = new Student("Kannan", "CSC002", 60.0, 65.0, 50.0);
        s2.displayReport();
    }
}

