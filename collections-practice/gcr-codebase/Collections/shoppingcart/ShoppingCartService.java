package shoppingcart;
import java.util.*;

public class ShoppingCartService {

    // HashMap for quick price lookup
    private Map<String, Integer> priceMap = new HashMap<>();

    // LinkedHashMap to maintain insertion order
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    // Add product to cart
    public void addProduct(Product product) {
        priceMap.put(product.getName(), product.getPrice());
        cart.put(product.getName(), product.getPrice());
    }

    // Display items in insertion order
    public void displayCartOrder() {
        System.out.println("\nCart Items (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    // Display items sorted by price
    public void displaySortedByPrice() {

        TreeMap<Integer, List<String>> sortedMap = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            sortedMap
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }

        System.out.println("\nCart Items (Sorted by Price):");
        for (Map.Entry<Integer, List<String>> entry : sortedMap.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " -> ₹" + entry.getKey());
            }
        }
    }
}

