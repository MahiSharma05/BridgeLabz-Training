package trafficmanager;
import java.util.Scanner;

public class TrafficManagerApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(5);

        int choice;

        do {
            System.out.println("\n=== Traffic Manager Menu ===");
            System.out.println("1. Add vehicle to waiting queue");
            System.out.println("2. Move vehicle to roundabout");
            System.out.println("3. Remove vehicle from roundabout");
            System.out.println("4. Display roundabout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter vehicle number: ");
                    String v = input.nextLine();
                    waitingQueue.add(v);
                    break;

                case 2:
                    String vehicle = waitingQueue.remove();
                    if (vehicle != null) {
                        roundabout.addVehicle(vehicle);
                    }
                    break;

                case 3:
                    roundabout.removeVehicle();
                    break;

                case 4:
                    roundabout.display();
                    break;

                case 5:
                    System.out.println("Traffic system shutting down...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        input.close();
    }
}
