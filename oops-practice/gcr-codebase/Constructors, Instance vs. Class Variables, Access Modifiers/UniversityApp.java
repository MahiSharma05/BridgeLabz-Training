class Student {

    // Access modifiers
    public String rollNumber;     
    protected String name;       
    private double CGPA;          

    // Constructor
    Student(String rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass demonstrating protected access
class PostgraduateStudent extends Student {

    String specialization;

    // Constructor
    PostgraduateStudent(String rollNumber, String name,
                        double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Method accessing protected member 'name'
    void displayPGStudentDetails() {
        System.out.println("Postgraduate Student Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA: " + getCGPA());
    }
}

// Main class
public class UniversityApp {
    public static void main(String[] args) {

        // Student object
        Student s1 = new Student("1", "Mahi", 8.5);
        s1.displayStudentDetails();

        // Modify CGPA using public methods
        s1.setCGPA(8.9);
        System.out.println("Updated CGPA: " + s1.getCGPA());

        System.out.println("----------------------------");

        // PostgraduateStudent object
        PostgraduateStudent pg =
                new PostgraduateStudent("32", "Mansi", 9.1, "Data Science");

        pg.displayPGStudentDetails();
    }
}
