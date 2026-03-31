package AIDrivenResumeScreeningSystem;
import java.util.List;

public class ResumeScreening {

    // Wildcard method
    public static void screenAllRoles(List<? extends JobRole> roles) {
        System.out.println("\n--- Screening Job Roles ---");
        for (JobRole role : roles) {
            System.out.println("Screening for: " + role.getRoleName());
            role.evaluateSkills();
        }
    }

    // Generic method
    public static <T extends JobRole> void autoScreen(T role) {
        System.out.println("\nAuto Screening for: " + role.getRoleName());
        role.evaluateSkills();
    }
}

