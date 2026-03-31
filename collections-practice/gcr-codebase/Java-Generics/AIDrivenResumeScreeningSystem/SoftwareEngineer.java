package AIDrivenResumeScreeningSystem;

public class SoftwareEngineer extends JobRole {

    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void evaluateSkills() {
        System.out.println("Evaluating Coding, DSA, System Design");
    }
}

