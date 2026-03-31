package StudentCourseRegistration;

public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public void registerStudent(Student student) {
        System.out.println("Student Registered Successfully!");
    }

    @Override
    public void enrollCourse(Student student, Course course) {
        try {
            student.enrollCourse(course);
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropCourse(Student student, String courseName) {
        student.dropCourse(courseName);
    }
}
