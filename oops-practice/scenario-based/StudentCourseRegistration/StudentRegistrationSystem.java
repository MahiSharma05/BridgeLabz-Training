package StudentCourseRegistration;
import java.util.Scanner;

public class StudentRegistrationSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        RegistrationService service = new RegistrationServiceImpl();
        Student student = null;

        Course java = new Course("C101", "Java", 4);
        Course dsa = new Course("C102", "DSA", 3);
        Course dbms = new Course("C103", "DBMS", 3);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n---- STUDENT COURSE REGISTRATION SYSTEM ----");
            System.out.println("1. Student Registration");
            System.out.println("2. Course Enrollment");
            System.out.println("3. Grade Management");
            System.out.println("4. Drop Course");
            System.out.println("5. View Grades");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Age: ");
                    int age = input.nextInt();

                    student = new Student(id, name, age);
                    service.registerStudent(student);
                    break;

                case 2:
                    if (student == null) {
                        System.out.println("Register student first!");
                        break;
                    }

                    System.out.println("1. Java  2. DSA  3. DBMS");
                    int c = input.nextInt();

                    switch (c) {
                        case 1: service.enrollCourse(student, java); break;
                        case 2: service.enrollCourse(student, dsa); break;
                        case 3: service.enrollCourse(student, dbms); break;
                        default: System.out.println("Invalid course!");
                    }
                    break;

                case 3:
                    if (student == null) {
                        System.out.println("Register student first!");
                        break;
                    }

                    input.nextLine();
                    System.out.print("Enter Course Name: ");
                    String cname = input.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = input.nextLine();

                    student.assignGrade(cname, grade);
                    break;

                case 4:
                    if (student == null) {
                        System.out.println("Register student first!");
                        break;
                    }

                    input.nextLine();
                    System.out.print("Enter Course Name to Drop: ");
                    String drop = input.nextLine();

                    service.dropCourse(student, drop);
                    break;

                case 5:
                    if (student != null)
                        student.viewGrades();
                    else
                        System.out.println("Register student first!");
                    break;

                case 6:
                    exit = true;
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}
