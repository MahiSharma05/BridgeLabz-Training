package oopsConcepts;
import java.util.ArrayList;
import java.util.List;

public class HospitalPatientManagement {
	public static void main(String[] args) {
		ArrayList<Patient> patients = new ArrayList<>();

        patients.add(new InPatient(101, "Mahi", 22, 5, 2000));
        patients.add(new OutPatient(202, "Mansi", 24, 500));

        System.out.println("... Hospital Patient Details .....\n");

        for(Patient p : patients){

            p.getPatientDetails();

            // Polymorphism  dynamic bill calculation
            System.out.println("Total Bill: ₹" + p.calculateBill());

            // Medical record handling
            MedicalRecord record = (MedicalRecord) p;
            record.addRecord("General Checkup");
            record.addRecord("Blood Test");
            record.viewRecords();

            System.out.println("................................\n");
        }
    }

	}
	// Interface
	interface MedicalRecord {
	    void addRecord(String record);
	    void viewRecords();
	}

	// Abstract Class
	abstract class Patient {

	    // Encapsulation
	    private int patientId;
	    private String name;
	    private int age;

	    // Sensitive data 
	    private String diagnosis;
	    private List<String> medicalHistory = new ArrayList<>();

	    Patient(int patientId, String name, int age) {
	        this.patientId = patientId;
	        this.name = name;
	        this.age = age;
	    }

	    // Getters 
	    public int getPatientId() {
	        return patientId;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    // Encapsulated methods for sensitive data
	    protected void setDiagnosis(String diagnosis) {
	        this.diagnosis = diagnosis;
	    }

	    protected void addMedicalHistory(String record) {
	        medicalHistory.add(record);
	    }

	    protected List<String> getMedicalHistory() {
	        return medicalHistory;
	    }

	    // Abstract method
	    abstract double calculateBill();

	    // Concrete method
	    void getPatientDetails() {
	        System.out.println("Patient ID: " + patientId);
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	    }
	}

	// In-Patient
	class InPatient extends Patient implements MedicalRecord {

	    private int numberOfDays;
	    private double dailyCharge;

	    InPatient(int id, String name, int age, int days, double charge) {
	        super(id, name, age);
	        this.numberOfDays = days;
	        this.dailyCharge = charge;
	    }

	    @Override
	    double calculateBill() {
	        return numberOfDays * dailyCharge;
	    }

	    @Override
	    public void addRecord(String record) {
	        addMedicalHistory(record);
	        System.out.println("Medical record added for In-Patient");
	    }

	    @Override
	    public void viewRecords() {
	        System.out.println("Medical History:");
	        for (String r : getMedicalHistory()) {
	            System.out.println("- " + r);
	        }
	    }
	}

	// Out-Patient 
	class OutPatient extends Patient implements MedicalRecord {

	    private double consultationFee;

	    OutPatient(int id, String name, int age, double fee) {
	        super(id, name, age);
	        this.consultationFee = fee;
	    }

	    @Override
	    double calculateBill() {
	        return consultationFee;
	    }

	    @Override
	    public void addRecord(String record) {
	        addMedicalHistory(record);
	        System.out.println("Medical record added for Out-Patient");
	    }

	    @Override
	    public void viewRecords() {
	        System.out.println("Medical History:");
	        for (String r : getMedicalHistory()) {
	            System.out.println("- " + r);
	        }
	    }
}
