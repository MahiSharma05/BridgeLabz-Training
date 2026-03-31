package jobportal;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> jobSkills = new HashSet<>();
        jobSkills.add("Java");
        jobSkills.add("Spring");
        jobSkills.add("SQL");
        jobSkills.add("Microservices");

        ResumeShortlistingService service =
                new ResumeShortlistingService(jobSkills);

        try {

            Resume r1 = new Resume(1, "Rahul",
                    Set.of("Java", "SQL", "HTML"));

            Resume r2 = new Resume(2, "Priya",
                    Set.of("Java", "Spring", "Microservices", "SQL"));

            Resume r3 = new Resume(3, "Aman",
                    Set.of("C++", "Python"));

            service.addResume(r1);
            service.addResume(r2);
            service.addResume(r3);

        } catch (InvalidResumeException e) {
            System.out.println(e.getMessage());
        }

        List<Resume> result = service.shortlistResumes();

        System.out.println("\n--- Shortlisted Resumes (Ranked) ---");

        for (Resume r : result) {
            System.out.println(r);
        }
    }
}
