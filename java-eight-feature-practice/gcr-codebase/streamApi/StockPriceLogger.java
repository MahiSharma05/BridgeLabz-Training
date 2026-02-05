package streamApi;
import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(
            2450.50,
            2475.75,
            2460.00,
            2488.20,
            2501.10
        );

        // Using Stream + forEach
        stockPrices.stream()
                   .forEach(price -> System.out.println("Stock Price: " + price));
    }
}

