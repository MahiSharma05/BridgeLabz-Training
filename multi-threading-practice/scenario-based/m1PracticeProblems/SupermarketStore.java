package practice;

import java.util.*;

abstract class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract void display();

    double getValue() {
        return price * quantity;
    }
}

class Electronics extends Product {
    int warranty;

    Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    void display() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity +
                ", Warranty: " + warranty + " months");
    }
}

class Clothing extends Product {
    String size;

    Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    void display() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity +
                ", Size: " + size);
    }
}

public class SupermarketStore {

    public static void main(String[] args) {
        System.out.println("input");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Product> inventory = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();
            String[] parts = line.split(",\\s*");

            String type = parts[0];

            if (type.equals("Electronics")) {

                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                int warranty = Integer.parseInt(parts[4]);

                Electronics e = new Electronics(name, price, quantity, warranty);
                inventory.add(e);

                System.out.println("Product added to inventory: " + name);
            }

            else if (type.equals("Clothing")) {

                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                String size = parts[4];

                Clothing c = new Clothing(name, price, quantity, size);
                inventory.add(c);

                System.out.println("Product added to inventory: " + name);
            }
        }

        System.out.println("Inventory:");

        double total = 0;

        for (Product p : inventory) {
            p.display();
            total += p.getValue();
        }

        System.out.printf("Total value of the inventory: %.2f", total);
    }
}
