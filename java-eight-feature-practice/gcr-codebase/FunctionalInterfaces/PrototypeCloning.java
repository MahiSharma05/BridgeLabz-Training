package FunctionalInterfaces;

// Prototype class
class Product implements Cloneable {

    private int productId;
    private String productName;

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    // Override clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    public void display() {
        System.out.println("Product ID: " + productId + ", Name: " + productName);
    }
}

public class PrototypeCloning {

    public static void main(String[] args) {

        try {
            // Original prototype object
            Product original = new Product(101, "Laptop");
            System.out.println("Original Object:");
            original.display();

            // Cloned object
            Product copy = (Product) original.clone();
            System.out.println("Cloned Object:");
            copy.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported.");
        }
    }
}
