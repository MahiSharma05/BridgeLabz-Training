package trafficmanager;

public class Roundabout {

    private VehicleNode tail; // tail pointer for circular list

    // Add vehicle to roundabout
    public void addVehicle(String number) {

        VehicleNode newNode = new VehicleNode(number);

        if (tail == null) {
            tail = newNode;
            tail.next = tail; // circular link
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }

        System.out.println("Vehicle entered roundabout: " + number);
    }

    // Remove vehicle from roundabout
    public void removeVehicle() {

        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        VehicleNode head = tail.next;

        if (head == tail) { // only one vehicle
            System.out.println("Vehicle exited: " + head.vehicleNumber);
            tail = null;
        } else {
            System.out.println("Vehicle exited: " + head.vehicleNumber);
            tail.next = head.next;
        }
    }

    // Print roundabout state
    public void display() {

        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        System.out.print("Roundabout State: ");
        VehicleNode temp = tail.next;

        do {
            System.out.print(temp.vehicleNumber + " -> ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("(back to start)");
    }

    // Check if empty
    public boolean isEmpty() {
        return tail == null;
    }
}
