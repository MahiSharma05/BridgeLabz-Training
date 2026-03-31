package oopsConcepts;
import java.util.ArrayList;

public class OnlineFoodDelivery {
	static void processOrder(FoodItem item){
        item.getItemDetails();
        double total = item.calculateTotalPrice();
        double discount = 0;
        if(item instanceof Discountable){
            Discountable d = (Discountable) item;
            discount = d.applyDiscount();
            System.out.println(d.getDiscountDetails());
        }

        double finalAmount = total - discount;

        System.out.println("Total Price: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount Payable: " + finalAmount);
        System.out.println(".....................................");
    }

	    public static void main(String[] args) {
	        ArrayList<FoodItem> order = new ArrayList<>();

	        order.add(new VegItem(" Burger", 120, 2));
	        order.add(new NonVegItem(" Pizza", 300, 1));

	        System.out.println("----- Order Details -----\n");

	        // Polymorphism
	        for(FoodItem item : order){
	            processOrder(item);
	        }
	    }

	}
	// Interface
	interface Discountable {
	    double applyDiscount();
	    String getDiscountDetails();
	}

	// Abstract Class 
	abstract class FoodItem {

	    // Encapsulation
	    private String itemName;
	    private double price;
	    private int quantity;

	    FoodItem(String itemName, double price, int quantity) {
	        this.itemName = itemName;
	        this.price = price;
	        this.quantity = quantity;
	    }

	    // Getters 
	    public String getItemName() {
	        return itemName;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    // Abstract method
	    abstract double calculateTotalPrice();

	    // Concrete method
	    void getItemDetails(){
	        System.out.println("Item Name: " + itemName);
	        System.out.println("Price per unit: " + price);
	        System.out.println("Quantity: " + quantity);
	    }
	}

	//Veg Item 
	class VegItem extends FoodItem implements Discountable {

	    VegItem(String name, double price, int qty) {
	        super(name, price, qty);
	    }

	    @Override
	    double calculateTotalPrice() {
	        return getPrice() * getQuantity();
	    }

	    @Override
	    public double applyDiscount() {
	        return calculateTotalPrice() * 0.10; // 10% discount
	    }

	    @Override
	    public String getDiscountDetails() {
	        return "Veg Item Discount: 10%";
	    }
	}

	// Non-Veg Item 
	class NonVegItem extends FoodItem implements Discountable {

	    private static final double NON_VEG_CHARGE = 50; 

	    NonVegItem(String name, double price, int qty) {
	        super(name, price, qty);
	    }

	    @Override
	    double calculateTotalPrice() {
	        return (getPrice() * getQuantity()) + NON_VEG_CHARGE;
	    }

	    @Override
	    public double applyDiscount() {
	        return calculateTotalPrice() * 0.05; 
	    }

	    @Override
	    public String getDiscountDetails() {
	        return "Non-Veg Item Discount: 5% + Extra Charge ₹50";
	    }
	}

