package inheritance;

// Superclass
class Order{
	String orderId ;
	String orderDate;
	
Order(String orderId , String orderDate){
	this.orderId = orderId;
	this.orderDate = orderDate;
}

String getOrderStatus() {
	return "Order Placed";
}
}

// Subclass
class ShippedOrder extends Order{
	String trackingNumber;
	
ShippedOrder(String orderId , String orderDate , String trackingNumber){
	super(orderId , orderDate);
	this.trackingNumber = trackingNumber;
}

@Override
String getOrderStatus() {
	return "Order Shipped";
}
}

// Subclass extends ShippedOrder
class DeliveredOrder extends ShippedOrder{
	String deliveryDate; 
	
DeliveredOrder(String orderId , String orderDate , String trackingNumber ,  String deliveryDate){
	super(orderId , orderDate , trackingNumber);
	this.deliveryDate = deliveryDate;
}
	
@Override
String getOrderStatus() {
	return "Order Delivered";
}
}

public class OnlineRetailOrderManagement {

	public static void main(String[] args) {
		Order order1 = new Order("ORD201" , "3-1-26");
		ShippedOrder order2 = new ShippedOrder("ORD202" , "4-1-26" , "TRK12345");
		DeliveredOrder order3 = new DeliveredOrder("ORD203", "05-01-26", "TRK67890", "6-01-26");
		
		System.out.println("Order ID: " + order1.orderId);
        System.out.println("Status: " + order1.getOrderStatus());
        System.out.println();

        System.out.println("Order ID: " + order2.orderId);
        System.out.println("Tracking Number: " + order2.trackingNumber);
        System.out.println("Status: " + order2.getOrderStatus());
        System.out.println();

        System.out.println("Order ID: " + order3.orderId);
        System.out.println("Tracking Number: " + order3.trackingNumber);
        System.out.println("Delivery Date: " + order3.deliveryDate);
        System.out.println("Status: " + order3.getOrderStatus());

	}

}
