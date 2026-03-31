package smartparking;

public class ParkingSlot {

    private int slotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    @Override
    public String toString() {
        if (isOccupied) {
            return "Slot " + slotNumber + " -> Occupied by " + vehicle;
        } else {
            return "Slot " + slotNumber + " -> Free";
        }
    }
}
