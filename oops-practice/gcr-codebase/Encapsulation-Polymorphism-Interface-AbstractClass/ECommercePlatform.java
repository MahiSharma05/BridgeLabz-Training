package oopsConcepts;
//Interface
interface Taxable {
 double calculateTax();
 String getTaxDetails();
}

//Abstract class
abstract class Product {

 private int productId;
 private String name;
 private double price;

 // Constructor
 Product(int productId, String name, double price) {
     this.productId = productId;
     this.name = name;
     this.price = price;
 }

 // Encapsulation: getters & setter
 public int getProductId() {
     return productId;
 }

 public String getName() {
     return name;
 }

 public double getPrice() {
     return price;
 }

 public void setPrice(double price) {
     if (price > 0)
         this.price = price;
 }

 // Abstract method
 abstract double calculateDiscount();

 // Common display method
 void displayProduct() {
     System.out.println("Product ID: " + productId);
     System.out.println("Name: " + name);
     System.out.println("Base Price: " + price);
 }
}

//Electronics class
class Electronics extends Product implements Taxable {

 Electronics(int id, String name, double price) {
     super(id, name, price);
 }

 @Override
 double calculateDiscount() {
     return getPrice() * 0.10; // 10% discount
 }

 @Override
 public double calculateTax() {
     return getPrice() * 0.18; // 18% GST
 }

 @Override
 public String getTaxDetails() {
     return "Electronics Tax: 18%";
 }
}

//Clothing class
class Clothing extends Product implements Taxable {

 Clothing(int id, String name, double price) {
     super(id, name, price);
 }

 @Override
 double calculateDiscount() {
     return getPrice() * 0.20; // 20% discount
 }

 @Override
 public double calculateTax() {
     return getPrice() * 0.12; // 12% tax
 }

 @Override
 public String getTaxDetails() {
     return "Clothing Tax: 12%";
 }
}

//Groceries class
class Groceries extends Product {

 Groceries(int id, String name, double price) {
     super(id, name, price);
 }

 @Override
 double calculateDiscount() {
     return getPrice() * 0.05; // 5% discount
 }
}

public class ECommercePlatform {

 // Polymorphic method
 static void calculateFinalPrice(Product product) {

     double price = product.getPrice();
     double discount = product.calculateDiscount();
     double tax = 0;

     if (product instanceof Taxable) {
         tax = ((Taxable) product).calculateTax();
         System.out.println(((Taxable) product).getTaxDetails());
     } else {
         System.out.println("No Tax Applicable");
     }

     double finalPrice = price + tax - discount;

     product.displayProduct();
     System.out.println("Discount: " + discount);
     System.out.println("Tax: " + tax);
     System.out.println("Final Price: " + finalPrice);
     System.out.println("...............................");
 }

 public static void main(String[] args) {

     Product[] products = new Product[3];

     products[0] = new Electronics(101, "Laptop", 60000);
     products[1] = new Clothing(102, "Jacket", 4000);
     products[2] = new Groceries(103, "Rice Bag", 1200);

     for (Product p : products) {
         calculateFinalPrice(p); 
     }
 }
}
