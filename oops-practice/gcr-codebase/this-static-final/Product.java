public class Product {
  static double discount = 0.0;
  String productName;
  int price;
  int quantity;
  final String productID;

  Product(String productName, int price, int quantity, String productID) {
    this.productName = productName;
    this.price = price;
    this.quantity = quantity;
    this.productID = productID;
  }

  public void displayDetails() {
    if (this instanceof Product) {
      System.out.println("Product ID: " + productID);
      System.out.println("Product Name: " + productName);
      System.out.println("Price: " + price);
      System.out.println("Quantity: " + quantity);
      System.out.println("Discount: " + discount + "%");
      System.out.println("Price after discount: " + getPriceAfterDiscount());

    } else {
      System.out.println("Invalid Product instance");
    }
  }

  double getPriceAfterDiscount() {
    return price - (price * discount / 100);
  }

  static void updateDiscount(double newDiscount) {
    discount = newDiscount;

  }

  public static void main(String[] args) {
    updateDiscount(10.0);

    Product p1 = new Product("Laptop", 1200, 5, "P001");
    p1.displayDetails();

    Product p2 = new Product("Smartphone", 800, 10, "P002");
    p2.displayDetails();
  }
}
