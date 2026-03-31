package ECommerceOrderManagementSystem;

public class Order {
	private int orderId;
	private Customer customer;
	private Product product;
	private String status;
public Order(int orderId, Customer customer, Product product){
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.status = "Placed";
	}
public int getOrderId() {
	return orderId;
}
public void cancelOrder() {
	this.status = "Cancelled";
}
public void displayOrder() {
	System.out.println(" Order ID: " + orderId + ", Customer: " + customer.getName() + ", Product: " + product.getName() + ", Status: " + status);
}
}
