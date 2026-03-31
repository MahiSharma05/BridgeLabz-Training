package AIDrivenResumeScreeningSystem;

public class DataScientist extends JobRole {

    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void evaluateSkills() {
        System.out.println("Evaluating Python, ML, Statistics");
    }
}

