package StudentCourseRegistration;

public class Student extends Person {

    private int studentId;
    private Course[] courses;
    private int courseCount;

    private static final int MAX_COURSES = 3;

    public Student(int studentId, String name, int age) {
        super(name, age);
        this.studentId = studentId;
        courses = new Course[MAX_COURSES];
        courseCount = 0;
    }

    public void enrollCourse(Course course) throws CourseLimitExceededException {
        if (courseCount >= MAX_COURSES) {
            throw new CourseLimitExceededException(
                "Course limit exceeded! Max 3 courses allowed."
            );
        }
        courses[courseCount++] = course;
        System.out.println("Enrolled in: " + course.getCourseName());
    }

    public void dropCourse(String courseName) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equalsIgnoreCase(courseName)) {
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--courseCount] = null;
                System.out.println("Course dropped successfully!");
                return;
            }
        }
        System.out.println("Course not found!");
    }

    public void assignGrade(String courseName, String grade) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equalsIgnoreCase(courseName)) {
                courses[i].setGrade(grade);
                System.out.println("Grade assigned!");
                return;
            }
        }
        System.out.println("Course not found!");
    }

    public void viewGrades() {
        if (courseCount == 0) {
            System.out.println("No courses enrolled.");
            return;
        }

        System.out.println("\nGrades for " + name + ":");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i]);
        }
    }
}
