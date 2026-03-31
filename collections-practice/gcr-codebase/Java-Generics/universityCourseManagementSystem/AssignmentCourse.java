package universityCourseManagementSystem;

public class AssignmentCourse extends CourseType{
	
public AssignmentCourse() {
	super("Assignment based");
}
	
@Override
public void evalution() {
	System.out.println("Evalution throgh Assignment.");
}

}
