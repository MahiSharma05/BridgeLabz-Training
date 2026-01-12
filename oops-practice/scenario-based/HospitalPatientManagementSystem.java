package scenario;
import java.util.*;

// interface
interface IPayable{
	double calculateBill();
}

// Patient class
abstract class Patient implements IPayable{
	private String name;
	private int patientId;
	private int age;
	private Doctor doctor;
Patient(String name, int patientId, int age, Doctor doctor){
	this.name = name;
	this.patientId = patientId;
	this.age = age;
	this.doctor = doctor;
}

public String getName() {
	return name;
}
public int getPatientId() {
	return patientId;
}
public int getAge() {
	return age;
}
public Doctor getDoctor() {
	return doctor;
}
public void setName(String name) {
	this.name = name;
}
public void setAge(int age) {
	this.age = age;
}
// Polymorphism
public abstract void displayInfo();
}


// In-Patient Subclass
class InPatient extends Patient{
	private int daysAdmitted;
	private double dailyCharge;
public InPatient(String name, int patientId, int age, Doctor doctor,int daysAdmitted, double dailyCharge){
	super(name, patientId, age, doctor);
	this.dailyCharge = dailyCharge;
	this.daysAdmitted = daysAdmitted;
}

@Override
public double calculateBill() {
	return daysAdmitted * dailyCharge;
}

@Override
public void displayInfo() {
	System.out.println("In Patient id " + getPatientId() + " Name: " + getName() + " Doctor: " + getDoctor().getName() + " Bill: " + calculateBill()); 
}
}

// out-patient Subclass
class OutPatient extends Patient{
	double consultationFee;
public OutPatient(String name, int patientId, int age,Doctor doctor, double fee) {
	super(name, patientId, age, doctor);
	this.consultationFee = fee;
}

@Override
public double calculateBill() {
	return consultationFee;
}

@Override
public void displayInfo() {
	System.out.println("Out Patient id " + getPatientId() + " Name: " + getName() + " Doctor: " + getDoctor().getName() + " Bill: " + calculateBill()); 

}
}

// Doctor class
class Doctor{
	private String name;
	private int doctorId;
	private String specilization;
Doctor(String name, int doctorId, String specilization){
	this.name = name;
	this.doctorId = doctorId;
	this.specilization = specilization;
}

public String getName() {
	return name;
}
}

// Bill class
class Bill{
	public static void generateBill(Patient patient) {
		System.out.println("Total Amount: " + patient.calculateBill());
		
	}
}


public class HospitalPatientManagementSystem {
	static List<Patient> patients = new ArrayList<>();

	public static void main(String[] args) {
		Doctor doctor = new Doctor("Dr. Gupta", 101, "Cardiology");
		
		// Create
		patients.add(new InPatient("Rahul", 1, 40, doctor, 5, 2000));
		patients.add(new OutPatient("Mohan", 2, 34, doctor, 500));
		
		// Read
		System.out.println("  Patient List   ");
		for(Patient p : patients) {
			p.displayInfo();
		}
		
		// Update
		patients.get(0).setName("Priya");
		
		// Delete
		patients.removeIf(p -> p.getPatientId() ==2);
		
		System.out.println(" After update and delete");
		for(Patient p : patients) {
			p.displayInfo();
			Bill.generateBill(p);
		}
	}
}
