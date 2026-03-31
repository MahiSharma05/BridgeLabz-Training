package LambdaExpressions;
import java.util.*;

public class NameUppercasing {

    public static void main(String[] args) {

        List<String> employeeNames = Arrays.asList(
                "Mahi", "Deepa", "Mansi", "Sneha"
        );

        employeeNames.stream()
                     .map(String::toUpperCase)
                     .forEach(System.out::println);
    }
}
