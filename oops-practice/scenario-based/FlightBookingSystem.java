package scenario;
import java.util.ArrayList;
import java.util.List;

// Flight Class
class Flight{
	int flightId;
	String source;
	String destination;
	double price;
	
Flight(int flightId, String source, String destination, double price) {
	this.flightId = flightId;
	this.source = source;
	this.destination = destination;
	this.price = price;
}

public void display() {
	System.out.println(flightId + " | " + source + " -> " + destination + " | " + price);
}
}

// Booking class
class Booking{
	String passengerName;
	Flight flight;
Booking(String passengerName, Flight flight) {
	this.passengerName = passengerName;
	this.flight = flight;
}

// Display Booking Details
void displayBooking() {
	System.out.println(" Passenger " + passengerName + ", Flight: " + flight.source + " -> " + flight.destination + " , Price " + flight.price);
}
}

public class FlightBookingSystem {
	
	// Array to store flights
	static Flight[] flights = {
			new Flight(101, " Delhi ", " Mumbai ", 4500),
			new Flight(102, " Delhi ", " Bangalore ", 5500),
			new Flight(103, " Chennai ", " Mumbai ", 5000),
			new Flight(104, " Pune ", " Delhi ", 4000),
			
	};
	
	// List to store bookings
	static List<Booking> bookings = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// search
		searchFlights("delhi");
		
		// create
		bookFlight("Mahi", 102);
		bookFlight("Mansi", 104);
		
		// read
		System.out.println("    Bookings      ");
		displayBookings();
		
		// delete
		cancelBooking("Mansi");
	}
	
	// Search flights
	static void searchFlights(String keyword) {
		System.out.println("     Available Flights");
		for(Flight f : flights) {
			if(f.source.toLowerCase().contains(keyword.toLowerCase()) || f.destination.toLowerCase().contains(keyword.toLowerCase())) {
				f.display();
			}
			
		}
	}
	
	// Book a flight
	static void bookFlight(String passengerName , int flightId) {
		for(Flight f : flights) {
			if(f.flightId == flightId) {
				bookings.add(new Booking(passengerName, f));
				System.out.println(" Flight booked successfully for " + passengerName);
				return;
			}
		}
		System.out.println("Flight not found");
	}
	
	// display booking
	static void displayBookings() {
		if(bookings.isEmpty()) {
			System.out.println("No booking found");
			return;
		}
		for(Booking b : bookings) {
			b.displayBooking();
		}
	}
	
	// Delete
	static void cancelBooking(String passengerName) {
		bookings.removeIf(b -> b.passengerName.equalsIgnoreCase(passengerName));
		System.out.println(" Booking Cancelled for " + passengerName);
	}
}
