class CartItem {
    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add item quantity
    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method to remove item quantity
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity = quantity - qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than present in the cart.");
        }
    }

    // Method to display total cost
    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.printf("Total cost: $%.2f%n", totalCost);
    }

    // Method to display item details
    void displayItem() {
        System.out.printf("Item: %s, Price: $%.2f, Quantity: %d%n",
                itemName, price, quantity);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {

        // Create cart item
        CartItem cart = new CartItem("Laptop", 999.99, 1);

        // Display initial item
        cart.displayItem();

        // Add items
        cart.addItem(2);

        // Remove item
        cart.removeItem(1);

        // Display total cost
        cart.displayTotalCost();
    }
}

