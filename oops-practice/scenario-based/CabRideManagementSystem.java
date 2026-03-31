package scenario;

import java.util.ArrayList;
import java.util.List;

// User
class User {
    String userName;
    String userId;

    User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }
}

//Driver
class Driver {
    String driverName;
    String driverId;
    boolean available;

    Driver(String driverName, String driverId) {
        this.driverName = driverName;
        this.driverId = driverId;
        this.available = true;
    }
}

// ride 
class Ride {
    User user;
    Driver driver;
    double distance;
    double fare;

    Ride(User user, double distance) {
        this.user = user;
        this.distance = distance;
    }
}

//Interface
interface FareCalculator {
    double calculateFare(double distance);
}

// Normal fare
class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

// Peak fare
class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 20;
    }
}

// Custom exception
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String msg) {
        super(msg);
    }
}

public class CabRideManagementSystem {

    // Driver assignment logic
    static Driver assignDriver(List<Driver> drivers)
            throws NoDriverAvailableException {

        for (Driver d : drivers) {
            if (d.available) {
                d.available = false;
                return d;
            }
        }
        throw new NoDriverAvailableException("No driver is available right now!");
    }

    public static void main(String[] args) {

        // User
        User user1 = new User("Mahi Sharma", "U101");
        User user2 = new User("Mansi Sharma", "U102");
        User user3 = new User("Manvi Sharma", "U102");

        // Drivers
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Ravi", "D101"));
        drivers.add(new Driver("Aavi", "D102"));

        // Ride history
        List<Ride> rideHistory = new ArrayList<>();

        try {
            // Book ride
            Ride ride = new Ride(user1, 12);
            Ride ride2 = new Ride(user2, 12);
            Ride ride3 = new Ride(user3, 12);
   
            // Assign driver
            ride.driver = assignDriver(drivers);
            ride2.driver = assignDriver(drivers);

            // Fare calculation 
            FareCalculator fareCalculator = new PeakFare();
            ride.fare = fareCalculator.calculateFare(ride.distance);

            // Save history
            rideHistory.add(ride);
            rideHistory.add(ride2);

            // Output
            System.out.println("Ride Booked Successfully!");
            System.out.println("User: " + ride.user.userName);
            System.out.println("Driver: " + ride.driver.driverName);
            System.out.println("Distance: " + ride.distance + " km");
            System.out.println("Total Fare: ₹" + ride.fare);

            //if driver is not available then it throw an exception
            ride3.driver = assignDriver(drivers);
            rideHistory.add(ride3);


        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Display history
        System.out.println("\n Ride History:");
        for (Ride r : rideHistory) {
            System.out.println( r.user.userName + " | Driver: " + r.driver.driverName + " | Distance: " + r.distance + " km | Fare: ₹" + r.fare);
        }
        
    }
}
