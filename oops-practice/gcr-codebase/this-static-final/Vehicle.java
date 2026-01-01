public class Vehicle {
  static double registrationFee = 0.0;
  String ownerName;
  String vehicleType;
  final String registrationNumber;

  Vehicle(String ownerName, String vehicleType, String registrationNumber) {
    this.ownerName = ownerName;
    this.vehicleType = vehicleType;
    this.registrationNumber = registrationNumber;
  }

  public void displayDetails() {
    if (this instanceof Vehicle) {
      System.out.println("Owner Name: " + ownerName);
      System.out.println("Vehicle Type: " + vehicleType);
      System.out.println("Registration Number: " + registrationNumber);
      System.out.println("Registration Fee: " + registrationFee);
    } else {
      System.out.println("Invalid Vehicle instance");
    }
  }

  static void updateRegistrationFee(int newFee) {
    registrationFee = newFee;
  }

  public static void main(String[] args) {
    updateRegistrationFee(150);
    Vehicle v1 = new Vehicle("Honest raj", "Sedan", "ABC123");
    v1.displayDetails();

    Vehicle v2 = new Vehicle("Price danish", "SUV", "XYZ789");
    v2.displayDetails();

  }
}
