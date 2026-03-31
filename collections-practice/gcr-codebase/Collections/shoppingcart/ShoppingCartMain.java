package shoppingcart;

public class ShoppingCartMain {

    public static void main(String[] args) {

        ShoppingCartService service = new ShoppingCartService();

        service.addProduct(new Product("Laptop", 60000));
        service.addProduct(new Product("Mouse", 800));
        service.addProduct(new Product("Keyboard", 1500));
        service.addProduct(new Product("Monitor", 12000));

        service.displayCartOrder();
        service.displaySortedByPrice();
    }
}

