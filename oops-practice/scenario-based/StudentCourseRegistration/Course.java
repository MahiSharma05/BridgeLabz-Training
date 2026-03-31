package StudentCourseRegistration;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;
    private String grade;   // grade stored inside course

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.grade = "Not Assigned";
    }

    public String getCourseName() {
        return courseName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return courseName + " -> Grade: " + grade;
    }
}


