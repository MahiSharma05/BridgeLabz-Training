package dynamicOnlineMarketplace;

public class Discount {
	public static <T extends Product<?>> void applyDiscount(T product , double percentage) {
		double oldPrice = product.getPrice();
		
		// product discount
		double discount = oldPrice * (percentage / 100);
		
		System.out.println(" Discount Applied: " + percentage + "%");
	}

}
