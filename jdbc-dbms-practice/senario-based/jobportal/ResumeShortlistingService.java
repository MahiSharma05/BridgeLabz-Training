package jobportal;

import java.util.*;

public class ResumeShortlistingService {

    private List<Resume> resumes = new ArrayList<>();
    private Set<String> requiredSkills = new HashSet<>();

    public ResumeShortlistingService(Set<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public void addResume(Resume resume) throws InvalidResumeException {

        if (resume.getSkills() == null || resume.getSkills().isEmpty()) {
            throw new InvalidResumeException(
                    "Resume must contain at least one skill.");
        }

        resumes.add(resume);
    }

    // ranking logic
    public List<Resume> shortlistResumes() {

        List<Resume> shortlisted = new ArrayList<>(resumes);

        Comparator<Resume> comparator = (r1, r2) -> {
            int match1 = countMatchingSkills(r1);
            int match2 = countMatchingSkills(r2);
            return Integer.compare(match2, match1); 
        };

        shortlisted.sort(comparator);

        return shortlisted;
    }

    private int countMatchingSkills(Resume resume) {
        int count = 0;

        for (String skill : resume.getSkills()) {
            if (requiredSkills.contains(skill)) {
                count++;
            }
        }

        return count;
    }
}
