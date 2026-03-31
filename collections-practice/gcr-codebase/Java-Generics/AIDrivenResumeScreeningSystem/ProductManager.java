package AIDrivenResumeScreeningSystem;

public class ProductManager extends JobRole {

    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void evaluateSkills() {
        System.out.println("Evaluating Strategy, Communication, Planning");
    }
}

