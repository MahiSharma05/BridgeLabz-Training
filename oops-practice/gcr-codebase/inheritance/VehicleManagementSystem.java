package inheritance;
public class VehicleManagementSystem {

    // Superclass
    static class Vehicle {
        String model;
        int maxSpeed;

        Vehicle(String model, int maxSpeed) {
            this.model = model;
            this.maxSpeed = maxSpeed;
        }

        void displayVehicle() {
            System.out.println("Model: " + model);
            System.out.println("Max Speed: " + maxSpeed + " km/h");
        }
    }

    // Interface
    interface Refuelable {
        void refuel();
    }

    // ElectricVehicle subclass
    static class ElectricVehicle extends Vehicle {

        ElectricVehicle(String model, int maxSpeed) {
            super(model, maxSpeed);
        }

        void charge() {
            System.out.println("Charging the electric vehicle.");
        }
    }

    // PetrolVehicle subclass 
    static class PetrolVehicle extends Vehicle implements Refuelable {

        PetrolVehicle(String model, int maxSpeed) {
            super(model, maxSpeed);
        }

        @Override
        public void refuel() {
            System.out.println("Refueling the petrol vehicle.");
        }
    }

    // Main method
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180);

        System.out.println("Electric Vehicle Details:");
        ev.displayVehicle();
        ev.charge();

        System.out.println();

        System.out.println("Petrol Vehicle Details:");
        pv.displayVehicle();
        pv.refuel();
    }
}

