package trafficmanager;

public class VehicleNode {

    String vehicleNumber;
    VehicleNode next;

    public VehicleNode(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.next = null;
    }
}
