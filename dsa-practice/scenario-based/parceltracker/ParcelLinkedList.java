package parceltracker;

public class ParcelLinkedList {

    private ParcelStage head;

    // Add stage at end
    public void addStage(String stageName) {
        ParcelStage newStage = new ParcelStage(stageName);

        if (head == null) {
            head = newStage;
            return;
        }

        ParcelStage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStage;
    }

    // Add intermediate checkpoint after given stage
    public void addCheckpoint(String afterStage, String newStage) {

        ParcelStage temp = head;

        while (temp != null) {
            if (temp.stageName.equalsIgnoreCase(afterStage)) {
                ParcelStage checkpoint = new ParcelStage(newStage);
                checkpoint.next = temp.next;
                temp.next = checkpoint;
                System.out.println("Checkpoint added successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Stage not found.");
    }

    // Forward tracking
    public void trackParcel() {

        if (head == null) {
            System.out.println("Parcel is missing (no tracking data).");
            return;
        }

        ParcelStage temp = head;
        System.out.println("Parcel Tracking:");

        while (temp != null) {
            System.out.print(temp.stageName);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Simulate lost parcel (null pointer handling)
    public void markParcelLost() {
        head = null;
        System.out.println("Parcel marked as LOST.");
    }
}
