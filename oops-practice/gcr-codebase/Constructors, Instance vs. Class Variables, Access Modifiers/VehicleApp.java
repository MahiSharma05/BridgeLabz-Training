class Vehicle {

    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable (shared for all vehicles)
    static double registrationFee = 1500.0;

    // Constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("----------------------------");
    }

    // Class method to update registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleApp {
    public static void main(String[] args) {

        // Create vehicle objects
        Vehicle v1 = new Vehicle("Mahi", "Car");
        Vehicle v2 = new Vehicle("Mansi", "Bike");

        // Display details before fee update
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(2000.0);

        // Display details after fee update
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}

