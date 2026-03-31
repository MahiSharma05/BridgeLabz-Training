package AIDrivenResumeScreeningSystem;

public class Resume<T extends JobRole> {

    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("\nCandidate: " + candidateName);
        System.out.println("Applied Role: " + jobRole.getRoleName());
        jobRole.evaluateSkills();
    }

    public T getJobRole() {
        return jobRole;
    }
}

