package universityCourseManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class Course<T extends CourseType> {
	private String courseName;
	private T courseType;
public Course(String courseName, T courseType) {
	this.courseName = courseName;
	this.courseType = courseType;
}

public void displayCourse() {
    System.out.println("Course: " + courseName);
    System.out.println(" Type: " + courseType.getEvalutionType());
    courseType.evalution();
}

public T getCourseType() {
    return courseType;
}

//Wildcard method
public static void displayAllCourses(List<? extends CourseType> list) {
    for (CourseType ct : list) {
        System.out.println("Course Type: " + ct.getEvalutionType());
        ct.evalution();
    }
}
}
