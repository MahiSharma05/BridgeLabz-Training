package scenariio;
import java.util.*;
import java.util.Map;

// Custom Exception
class TableAlreadyReservedException extends Exception{
	public TableAlreadyReservedException(String message) {
		super(message);
	}
}

// Table Class
class Table{
	int tableNumber;
	int capacity;
    Table(int tableNumber, int capacity){
	    this.tableNumber = tableNumber;
	    this.capacity = capacity;
    }
}

// Reservation Class
class Reservation{
	String timeSlot;
	int tableNumber;
    Reservation(String timeSlot, int tableNumber){
	    this.tableNumber = tableNumber;
	    this.timeSlot = timeSlot;
    }
	
}

    class RestaurantReservationSystem {
	private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Add tables
    public void addTable(Table table) {
        tables.put(table.tableNumber, table);
    }

    // Reserve table
    public void reserveTable(int tableNumber, String timeSlot)
            throws TableAlreadyReservedException {

        for (Reservation r : reservations) {
            if (r.tableNumber == tableNumber &&
                r.timeSlot.equalsIgnoreCase(timeSlot)) {
                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(timeSlot, tableNumber));
        System.out.println("Table " + tableNumber + " reserved for " + timeSlot);
    }

    // Cancel reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        Iterator<Reservation> iterator = reservations.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.tableNumber == tableNumber &&
                r.timeSlot.equalsIgnoreCase(timeSlot)) {
                iterator.remove();
                found = true;
                System.out.println("Reservation cancelled for table " + tableNumber);
                break;
            }
        }

        if (!found) {
            System.out.println("No reservation found to cancel.");
        }
    }

    // Show available tables
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for (Table table : tables.values()) {
            boolean reserved = false;

            for (Reservation r : reservations) {
                if (r.tableNumber == table.tableNumber &&
                    r.timeSlot.equalsIgnoreCase(timeSlot)) {
                    reserved = true;
                    break;
                }
            }

            if (!reserved) {
                System.out.println("Table " + table.tableNumber +
                        " (Capacity: " + table.capacity + ")");
            }
        }
    }
}

public class RestaurantTableReservation {
    public static void main(String[] args) {

    	Scanner input = new Scanner(System.in);
        RestaurantReservationSystem system =
                new RestaurantReservationSystem();

        // Predefined tables
        system.addTable(new Table(1, 4));
        system.addTable(new Table(2, 2));
        system.addTable(new Table(3, 6));

        while (true) {
            System.out.println("\n--- Restaurant Table Reservation ---");
            System.out.println("1. Reserve Table");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Available Tables");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter table number: ");
                        int tableNo = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter time slot: ");
                        String timeSlot = input.nextLine();

                        system.reserveTable(tableNo, timeSlot);
                        break;

                    case 2:
                        System.out.print("Enter table number: ");
                        int cancelTable = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter time slot: ");
                        String cancelTime = input.nextLine();

                        system.cancelReservation(cancelTable, cancelTime);
                        break;

                    case 3:
                        System.out.print("Enter time slot: ");
                        String slot = input.nextLine();

                        system.showAvailableTables(slot);
                        break;

                    case 4:
                        System.out.println("Thank you! Exiting system.");
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } 
            catch (TableAlreadyReservedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}