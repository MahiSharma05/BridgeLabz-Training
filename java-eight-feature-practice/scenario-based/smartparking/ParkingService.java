package smartparking;

import java.util.*;

public class ParkingService {

    private Map<Integer, ParkingSlot> slots = new TreeMap<>();
    private Queue<Vehicle> waitingQueue = new LinkedList<>();

    // Add parking slot
    public void addSlot(int slotNumber) {
        slots.put(slotNumber, new ParkingSlot(slotNumber));
    }

    // Park vehicle
    public void parkVehicle(Vehicle vehicle) throws NoParkingSlotAvailableException {

        for (ParkingSlot slot : slots.values()) {
            if (!slot.isOccupied()) {
                slot.assignVehicle(vehicle);
                System.out.println(vehicle + " parked at slot " + slot.getSlotNumber());
                return;
            }
        }

        // If no slot free
        waitingQueue.add(vehicle);
        throw new NoParkingSlotAvailableException(
                "No free slot available. Vehicle added to waiting queue: " + vehicle);
    }

    // remove vehicle from slot
    public void removeVehicle(int slotNumber) {

        ParkingSlot slot = slots.get(slotNumber);

        if (slot != null && slot.isOccupied()) {
            System.out.println("Removing " + slot.getVehicle() + " from slot " + slotNumber);
            slot.removeVehicle();

            // Allocate to next waiting vehicle
            if (!waitingQueue.isEmpty()) {
                Vehicle nextVehicle = waitingQueue.poll();
                slot.assignVehicle(nextVehicle);
                System.out.println("Allocated slot " + slotNumber + " to waiting vehicle: " + nextVehicle);
            }
        } else {
            System.out.println("Slot is already free or does not exist.");
        }
    }

    // Display Status
    public void displayStatus() {
        for (ParkingSlot slot : slots.values()) {
            System.out.println(slot);
        }

        System.out.println("Waiting Queue: " + waitingQueue);
    }
}
