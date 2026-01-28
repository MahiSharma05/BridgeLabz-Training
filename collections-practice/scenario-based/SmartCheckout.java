package scenariio;
import java.util.*;

// Item class
class Item {
 String name;
 double price;
 int stock;

 public Item(String name, double price, int stock) {
     this.name = name;
     this.price = price;
     this.stock = stock;
 }
}

// Customer class
class Customer {
 String name;
 List<String> items;

 public Customer(String name, List<String> items) {
     this.name = name;
     this.items = items;
 }
}

// Checkout system
class SmartCheckoutSystem {

 private Queue<Customer> queue = new LinkedList<>();
 private HashMap<String, Item> inventory = new HashMap<>();

 // Add items to inventory
 public void addItem(Item item) {
     inventory.put(item.name, item);
 }

 // Add customer to queue
 public void addCustomer(Customer customer) {
     queue.add(customer);
     System.out.println("Customer added to queue.");
 }

 // Process next customer
 public void processCustomer() {

     if (queue.isEmpty()) {
         System.out.println("No customers in queue.");
         return;
     }

     Customer customer = queue.poll();
     double totalBill = 0;

     System.out.println("\nBilling Customer: " + customer.name);

     for (String itemName : customer.items) {
         Item item = inventory.get(itemName);

         if (item == null) {
             System.out.println(itemName + " not found.");
             continue;
         }

         if (item.stock > 0) {
             item.stock--;
             totalBill += item.price;
             System.out.println(itemName + " - ₹" + item.price);
         } 
         else {
             System.out.println(itemName + " is out of stock!");
         }
     }
     System.out.println("Total Bill: ₹" + totalBill);
 }

 public void showQueueSize() {
     System.out.println("Customers in queue: " + queue.size());
 }
}

public class SmartCheckout {
 public static void main(String[] args) {

     Scanner input = new Scanner(System.in);
     SmartCheckoutSystem system = new SmartCheckoutSystem();

     // preloaded inventory
     system.addItem(new Item("Milk", 50, 10));
     system.addItem(new Item("Bread", 40, 5));
     system.addItem(new Item("Rice", 60, 8));

     while (true) {
         System.out.println("\n--- Smart Checkout System ---");
         System.out.println("1. Add Customer");
         System.out.println("2. Process Customer");
         System.out.println("3. Show Queue Size");
         System.out.println("4. Exit");
         System.out.print("Enter choice: ");

         int choice = input.nextInt();
         input.nextLine(); 

         switch (choice) {

             case 1:
                 System.out.print("Enter customer name: ");
                 String name = input.nextLine();

                 System.out.print("Enter number of items: ");
                 int count = input.nextInt();
                 input.nextLine();

                 List<String> items = new ArrayList<>();
                 for (int i = 0; i < count; i++) {
                     System.out.print("Enter item name: ");
                     items.add(input.nextLine());
                 }

                 system.addCustomer(new Customer(name, items));
                 break;

             case 2:
                 system.processCustomer();
                 break;

             case 3:
                 system.showQueueSize();
                 break;

             case 4:
                 System.out.println("Thankyou for shopping!");
                 input.close();
                 return;

             default:
                 System.out.println("Invalid choice!");
         }
     }
 }
}

