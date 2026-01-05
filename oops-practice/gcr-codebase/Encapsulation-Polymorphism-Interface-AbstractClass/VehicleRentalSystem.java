package oopsConcepts;

import java.util.ArrayList;

// ================= MAIN CLASS =================
public class VehicleRentalSystem {

    static void calculateRental(RentalVehicle v, int days) {
        v.displayDetails();
        System.out.println("Days: " + days);
        System.out.println("Rental Cost: ₹" + v.calculateRentalCost(days));
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        ArrayList<RentalVehicle> rentals = new ArrayList<>();

        rentals.add(new RentalCar("DL01", 2000));
        rentals.add(new RentalBike("UP32", 800));
        rentals.add(new RentalTruck("HR26", 3500));

        for (RentalVehicle v : rentals) {
            calculateRental(v, 3);
        }
    }
}

// ================= ABSTRACT CLASS =================
abstract class RentalVehicle {

    private String vehicleNumber;
    private double rentalRate;

    RentalVehicle(String vehicleNumber, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.rentalRate = rentalRate;
    }

    protected double getRentalRate() {
        return rentalRate;
    }

    abstract double calculateRentalCost(int days);

    void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Rate per day: ₹" + rentalRate);
    }
}

// ================= CAR =================
class RentalCar extends RentalVehicle {

    RentalCar(String number, double rate) {
        super(number, rate);
    }

    double calculateRentalCost(int days) {
        return days * getRentalRate();
    }
}

// ================= BIKE =================
class RentalBike extends RentalVehicle {

    RentalBike(String number, double rate) {
        super(number, rate);
    }

    double calculateRentalCost(int days) {
        return days * getRentalRate();
    }
}

// ================= TRUCK =================
class RentalTruck extends RentalVehicle {

    RentalTruck(String number, double rate) {
        super(number, rate);
    }

    double calculateRentalCost(int days) {
        return days * getRentalRate() + 1000;
    }
}
