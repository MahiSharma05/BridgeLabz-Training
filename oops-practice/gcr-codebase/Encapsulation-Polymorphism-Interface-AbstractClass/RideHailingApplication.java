package oopsConcepts;

import java.util.ArrayList;

// ================= MAIN CLASS =================
public class RideHailingApplication {

    static void calculateRideFare(Vehicle vehicle, double distance) {

        vehicle.getVehicleDetails();
        double fare = vehicle.calculateFare(distance);

        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: ₹" + fare);

        if (vehicle instanceof GPS) {
            GPS gps = (GPS) vehicle;
            System.out.println("Current Location: " + gps.getCurrentLocation());
        }

        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car(101, "Mahi", 15));
        vehicles.add(new Bike(102, "Mahira", 8));
        vehicles.add(new Auto(103, "Mansi", 12));

        ((GPS) vehicles.get(0)).updateLocation("MG Road");
        ((GPS) vehicles.get(1)).updateLocation("Station");
        ((GPS) vehicles.get(2)).updateLocation("City Mall");

        for (Vehicle v : vehicles) {
            calculateRideFare(v, 10);
        }
    }
}

// ================= INTERFACE =================
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// ================= ABSTRACT CLASS =================
abstract class Vehicle {

    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    abstract double calculateFare(double distance);

    void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate/KM: ₹" + ratePerKm);
    }
}

// ================= CAR =================
class Car extends Vehicle implements GPS {

    private String location = "Unknown";

    Car(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    double calculateFare(double distance) {
        return distance * getRatePerKm() + 50;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// ================= BIKE =================
class Bike extends Vehicle implements GPS {

    private String location = "Unknown";

    Bike(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// ================= AUTO =================
class Auto extends Vehicle implements GPS {

    private String location = "Unknown";

    Auto(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    double calculateFare(double distance) {
        return distance * getRatePerKm() + 20;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}
