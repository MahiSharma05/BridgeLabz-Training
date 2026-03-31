package linkedList;
import java.util.Scanner;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName,
               int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketCircularLinkedList {
    private TicketNode head = null;
    private TicketNode tail = null;

    // Add ticket at end
    public void addTicket(int id, String customer, String movie,
                          int seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Ticket booked successfully");
    }

    // Remove ticket by ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode current = head;
        TicketNode prev = tail;

        do {
            if (current.ticketId == ticketId) {

                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }

                System.out.println("Ticket cancelled successfully");
                return;
            }

            prev = current;
            current = current.next;

        } while (current != head);

        System.out.println("Ticket not found");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;
        System.out.println("\nBooked Tickets:");
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by customer name
    public void searchByCustomer(String name) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for this customer");
    }

    // Search by movie name
    public void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for this movie");
    }

    // Count total tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        TicketNode temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets Booked: " + count);
    }

    private void displayTicket(TicketNode t) {
        System.out.println("---------------------------");
        System.out.println("Ticket ID: " + t.ticketId);
        System.out.println("Customer: " + t.customerName);
        System.out.println("Movie: " + t.movieName);
        System.out.println("Seat No: " + t.seatNumber);
        System.out.println("Booking Time: " + t.bookingTime);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicketCircularLinkedList list = new TicketCircularLinkedList();

        while (true) {
            System.out.println("\nOnline Ticket Reservation System");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search by Customer");
            System.out.println("5. Search by Movie");
            System.out.println("6. Count Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Customer Name: ");
                    String customer = input.nextLine();
                    System.out.print("Movie Name: ");
                    String movie = input.nextLine();
                    System.out.print("Seat Number: ");
                    int seat = input.nextInt();
                    input.nextLine();
                    System.out.print("Booking Time: ");
                    String time = input.nextLine();

                    list.addTicket(id, customer, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID: ");
                    list.removeTicket(input.nextInt());
                    break;

                case 3:
                    list.displayTickets();
                    break;

                case 4:
                    System.out.print("Customer Name: ");
                    list.searchByCustomer(input.nextLine());
                    break;

                case 5:
                    System.out.print("Movie Name: ");
                    list.searchByMovie(input.nextLine());
                    break;

                case 6:
                    list.countTickets();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
