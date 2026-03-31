class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1000.0;

    // Default constructor
    CarRental() {
        customerName = "Customer";
        carModel = "Standard Car";
        rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    // Method to display rental details
    void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost());
        System.out.println("----------------------------");
    }
}

public class CarRentalDetails {
    public static void main(String[] args) {

        // Using default constructor
        CarRental rental1 = new CarRental();
        rental1.displayRentalDetails();

        // Using parameterized constructor
        CarRental rental2 = new CarRental("Mahi Sharma", "Swift Dzire", 5);
        rental2.displayRentalDetails();
    }
}
