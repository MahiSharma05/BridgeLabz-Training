package AIDrivenResumeScreeningSystem;

public abstract class JobRole {
	private String roleName;
public JobRole(String roleName) {
	this.roleName = roleName;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}

public abstract void evaluateSkills();

}
