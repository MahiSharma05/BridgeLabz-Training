package inheritance;

// Superclass
class Course {
	String courseName ;
	int duration;
Course(String courseName , int duration){
	this.courseName = courseName;
	this.duration = duration;
}

void displayCourse() {
    System.out.println("Course Name: " + courseName);
    System.out.println("Duration: " + duration + " hours");
}
}

// subclass extends Course class
class OnlineCourse extends Course{
	String platform ;
	boolean isRecorded;
OnlineCourse(String courseName , int duration , String platform , boolean isRecorded){
	super(courseName , duration);
	this.platform = platform;
	this.isRecorded = isRecorded;
}

void displayOnlineCourse() {
    displayCourse();
    System.out.println("Platform: " + platform);
    System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
}
}

// subclass extends onlineCourse
class PaidOnlineCourse extends OnlineCourse{
	int fee ;
	double discount;

PaidOnlineCourse(String courseName , int duration , String platform , boolean isRecorded , int fee , double discount){
	super(courseName , duration , platform , isRecorded);
	this.fee = fee;
	this.discount = discount;
}
void displayPaidCourse() {
    displayOnlineCourse();
    System.out.println("Course Fee: ₹" + fee);
    System.out.println("Discount: " + discount + "%");
    System.out.println("Final Price: ₹" + (fee - (fee * discount / 100)));
}
}

public class EducationalCourseHierarchy {

	public static void main(String[] args) {
		PaidOnlineCourse course = new PaidOnlineCourse("Java" , 120 , "Coursera" , true , 15000 , 20);
        course.displayPaidCourse();
   }
}
