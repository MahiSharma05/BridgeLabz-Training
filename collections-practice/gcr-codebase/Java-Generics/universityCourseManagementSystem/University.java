package universityCourseManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class University {

    // Wildcard method
    public static void displayAllCourses(List<? extends CourseType> list) {
        for (CourseType ct : list) {
            System.out.println("Course Type: " + ct.getEvalutionType());
            ct.evalution();
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());

        Course<AssignmentCourse> cs = new Course<>("Computer Science", new AssignmentCourse());

        Course<ResearchCourse> phd = new Course<>("PhD Research", new ResearchCourse());

        System.out.println(" Individual Courses ");
        math.displayCourse();
        cs.displayCourse();
        phd.displayCourse();

        // Using wildcard
        List<CourseType> allCourseTypes = new ArrayList<>();
        allCourseTypes.add(new ExamCourse());
        allCourseTypes.add(new AssignmentCourse());
        allCourseTypes.add(new ResearchCourse());

        System.out.println("\n All Course Types");
        displayAllCourses(allCourseTypes);
    }
}
