public class Patient {
  static String hospitalName = "City Hospital";
  String name;
  int age;
  String ailment;
  final String patientID;
  static int totalPatients = 0;

  Patient(String name, int age, String patientID, String ailment) {
    this.name = name;
    this.age = age;
    this.patientID = patientID;
    this.ailment = ailment;
    totalPatients++;
  }

  public void displayDetails() {
    if (this instanceof Patient) {
      System.out.println("Hospital Name: " + hospitalName);
      System.out.println("Patient ID: " + patientID);
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
      System.out.println("Ailment: " + ailment);
    } else {
      System.out.println("Invalid Patient instance");
    }
  }

  static void getTotalPatients() {
    System.out.println("Total Patients Admitted: " + totalPatients);
  }

  public static void main(String[] args) {
    getTotalPatients();
    Patient p1 = new Patient("Lathika", 30, "P001", "Flu");
    Patient p2 = new Patient("Lidiya", 45, "P002","Fracture");
    p1.displayDetails();
    p2.displayDetails();
  }
  
}
