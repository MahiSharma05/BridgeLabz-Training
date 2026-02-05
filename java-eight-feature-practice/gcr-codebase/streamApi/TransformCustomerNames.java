package streamApi;

import java.util.*;
import java.util.stream.*;

public class TransformCustomerNames {
    public static void main(String[] args) {

        List<String> customers = Arrays.asList("Mahi","Rahul","Mansi","Deepa","Sumit");

        List<String> displayNames = customers.stream()

            // map transform each name to uppercase
            .map(String::toUpperCase)

            // sorted alphabetical order
            .sorted()

            // collect result
            .collect(Collectors.toList());

        displayNames.forEach(System.out::println);
    }
}

