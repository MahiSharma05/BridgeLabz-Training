package AIDrivenResumeScreeningSystem;

import java.util.ArrayList;
import java.util.List;

public class ResumeApp {

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 = new Resume<>("Amit", new SoftwareEngineer());

        Resume<DataScientist> r2 = new Resume<>("Neha", new DataScientist());

        Resume<ProductManager> r3 = new Resume<>("Rahul", new ProductManager());

        // Processing resumes
        r1.processResume();
        r2.processResume();
        r3.processResume();

        // Wildcard usage
        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        ResumeScreening.screenAllRoles(roles);

        // Generic method
        ResumeScreening.autoScreen(new SoftwareEngineer());
    }
}

