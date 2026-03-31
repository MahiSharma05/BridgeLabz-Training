class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;

    // Method to book ticket
    void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // Method to display ticket details
    void displayTicket() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
}

public class MovieTicketDetails {
    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket();

        // Ticket not booked yet
        ticket.displayTicket();

        // First booking attempt
        ticket.bookTicket("Dragon", "A10", 120.0);

        // Multiple booking attempts (should fail)
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);

        // Display price separately (as shown in output)
        System.out.println("Price: $" + ticket.price);
        System.out.println();

        // Display final ticket details
        ticket.displayTicket();
    }
}
