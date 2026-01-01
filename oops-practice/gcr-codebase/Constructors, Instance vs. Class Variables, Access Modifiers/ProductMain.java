class Product {

    // Instance variables (unique for each object)
    String productName;
    double price;

    // Class variable (shared among all objects)
    static int totalProducts = 0;

    // Constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;   // increment when a new product is created
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("----------------------------");
    }

    // Class method (static method)
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

public class ProductMain {
    public static void main(String[] args) {

        // Create product objects
        Product p1 = new Product("Laptop", 55000.0);
        Product p2 = new Product("Mobile", 25000.0);
        Product p3 = new Product("Headphones", 3000.0);

        // Display individual product details
        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        // Display total number of products
        Product.displayTotalProducts();
    }
}

