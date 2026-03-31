package List;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FrequencyCounter {

    public static Map<String, Integer> findFrequency(List<String> list) {

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            // O(1) average time
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "apple", "orange");

        Map<String, Integer> result = findFrequency(fruits);

        System.out.println(result);
    }
}
