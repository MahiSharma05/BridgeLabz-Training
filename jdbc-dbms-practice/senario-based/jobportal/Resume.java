package jobportal;

import java.util.Set;

public class Resume {

    private int id;
    private String candidateName;
    private Set<String> skills;

    public Resume(int id, String candidateName, Set<String> skills) {
        this.id = id;
        this.candidateName = candidateName;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public Set<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return id + " - " + candidateName + " Skills: " + skills;
    }
}
