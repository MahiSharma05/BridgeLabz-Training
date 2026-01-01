class Course {

    // Instance variables
    String courseName;
    int duration;      // duration in months
    double fee;

    // Class variable (shared among all courses)
    static String instituteName = "ABC Institute";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("----------------------------");
    }

    // Class method to update institute name
    static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
}

public class CourseApp {
    public static void main(String[] args) {

        // Create course objects
        Course c1 = new Course("Java Full Stack", 6, 45000.0);
        Course c2 = new Course("Python", 4, 30000.0);

        // Display course details (before update)
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update institute name for all courses
        Course.updateInstituteName("BridgeLabz Training");

        // Display course details (after update)
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}

