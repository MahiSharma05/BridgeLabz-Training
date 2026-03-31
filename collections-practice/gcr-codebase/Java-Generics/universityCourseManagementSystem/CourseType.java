package universityCourseManagementSystem;

public abstract class CourseType {
	private String evalutionType;
public CourseType(String evalutiontype){
	this.evalutionType = evalutionType;
}
	
public abstract void evalution();

public String getEvalutionType() {
	return evalutionType;
}

public void setEvalutionType(String evalutionType) {
	this.evalutionType = evalutionType;
}




}
