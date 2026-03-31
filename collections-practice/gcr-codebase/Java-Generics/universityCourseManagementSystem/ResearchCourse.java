package universityCourseManagementSystem;

public class ResearchCourse extends CourseType{
	
public ResearchCourse() {
	super("Research based");
}
	
@Override
public void evalution() {
	System.out.println("Evalution throgh Research.");
}

}
