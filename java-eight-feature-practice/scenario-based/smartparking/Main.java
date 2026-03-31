package smartparking;

public class Main {

    public static void main(String[] args) {

        ParkingService service = new ParkingService();

        // add slots
        service.addSlot(1);
        service.addSlot(2);
        service.addSlot(3);

        Vehicle v1 = new Car("UP32-1234");
        Vehicle v2 = new Bike("UP32-5678");
        Vehicle v3 = new Car("UP32-9999");
        Vehicle v4 = new Bike("UP32-8888");

        try {
            service.parkVehicle(v1);
            service.parkVehicle(v2);
            service.parkVehicle(v3);
            service.parkVehicle(v4);  
        } catch (NoParkingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Parking Status ---");
        service.displayStatus();

        System.out.println("\n--- Removing Vehicle from Slot 2 ---");
        service.removeVehicle(2);

        System.out.println("\n--- Final Parking Status ---");
        service.displayStatus();
    }
}
