package StudentCourseRegistration;

public interface RegistrationService {

    void registerStudent(Student student);

    void enrollCourse(Student student, Course course);

    void dropCourse(Student student, String courseName);
}


