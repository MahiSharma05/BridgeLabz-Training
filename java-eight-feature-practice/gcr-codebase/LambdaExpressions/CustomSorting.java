package LambdaExpressions;
import java.util.*;

class Product{
	String name;
	int price;
	int rating;
	double discount;
Product(String name, int price, int rating, double discount){
	this.name = name;
	this.price = price;
	this.rating = rating;
	this.discount = discount;
}
public String toString() {
    return name + " | Price: " + price +
           " | Rating: " + rating +
           " | Discount: " + discount + "%";
}
}

public class CustomSorting {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 60000,10, 4.5));
        products.add(new Product("Phone", 30000,15, 4.7));
        products.add(new Product("Headphones", 2000,25, 4.2));
        
     // Sort by price 
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);
        
     // Sort by rating 
        products.sort((p1, p2) -> Double.compare(p1.rating, p2.rating));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);
        
     // Sort by discount 
        products.sort((p1, p2) -> Double.compare(p1.discount, p2.discount));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);
		

	}

}
