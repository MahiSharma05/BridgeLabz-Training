package parceltracker;

import java.util.Scanner;

public class ParcelTrackerMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ParcelLinkedList tracker = new ParcelLinkedList();

        int choice;

        do {
            System.out.println("\n--- Parcel Tracker Menu ---");
            System.out.println("1. Add Delivery Stage");
            System.out.println("2. Add Intermediate Checkpoint");
            System.out.println("3. Track Parcel");
            System.out.println("4. Mark Parcel as Lost");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Stage Name: ");
                    String stage = input.nextLine();
                    tracker.addStage(stage);
                    break;

                case 2:
                    System.out.print("Enter Existing Stage: ");
                    String afterStage = input.nextLine();
                    System.out.print("Enter New Checkpoint: ");
                    String newStage = input.nextLine();
                    tracker.addCheckpoint(afterStage, newStage);
                    break;

                case 3:
                    tracker.trackParcel();
                    break;

                case 4:
                    tracker.markParcelLost();
                    break;

                case 5:
                    System.out.println("Exiting Parcel Tracker...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        input.close();
    }
}
