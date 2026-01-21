package universityCourseManagementSystem;

public class ExamCourse extends CourseType{
	
public ExamCourse() {
	super("Exam based");
}
	
@Override
public void evalution() {
	System.out.println("Evalution throgh writing exam.");
}

}
