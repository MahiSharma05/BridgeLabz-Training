package FunctionalInterfaces;

interface VehicleDashboard {

    // Common feature for all vehicles
    void displaySpeed(int speed);

    // New feature added later (only relevant for EVs)
    default void displayBatteryPercentage(int percentage) {
        System.out.println("Battery: " + percentage + "%");
    }
}

// Old implementation
class PetrolCar implements VehicleDashboard {

    @Override
    public void displaySpeed(int speed) {
        System.out.println("Petrol Car Speed: " + speed + " km/h");
    }
}

// Electric vehicle implementation
class ElectricCar implements VehicleDashboard {

    @Override
    public void displaySpeed(int speed) {
        System.out.println("Electric Car Speed: " + speed + " km/h");
    }

    // Optional override for EV-specific behavior
    @Override
    public void displayBatteryPercentage(int percentage) {
        System.out.println("EV Battery Level: " + percentage + "%");
    }
}

public class SmartVehicleDashboard {

    public static void main(String[] args) {

        VehicleDashboard petrolCar = new PetrolCar();
        petrolCar.displaySpeed(80);
        petrolCar.displayBatteryPercentage(0); // default method

        VehicleDashboard electricCar = new ElectricCar();
        electricCar.displaySpeed(100);
        electricCar.displayBatteryPercentage(75); // overridden method
    }
}
