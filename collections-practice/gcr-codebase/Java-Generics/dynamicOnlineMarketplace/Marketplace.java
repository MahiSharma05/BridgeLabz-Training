package dynamicOnlineMarketplace;

public class Marketplace {

	public static void main(String[] args) {
		Product<BookCategory> book = new Product<>("Java ", 500, new BookCategory());

        Product<ClothingCategory> shirt = new Product<>("Shirt", 900, new ClothingCategory());

        Product<GadgetsCategory> phone = new Product<>("Tablet", 25000, new GadgetsCategory());

        book.display();
        shirt.display();
        phone.display();

        System.out.println("Applying Discounts");

        Discount.applyDiscount(book, 10);
        Discount.applyDiscount(shirt, 20);
        Discount.applyDiscount(phone, 5);

        System.out.println("\nAfter Discount:\n");
        
        book.display();
        shirt.display();
        phone.display();


	}

}
