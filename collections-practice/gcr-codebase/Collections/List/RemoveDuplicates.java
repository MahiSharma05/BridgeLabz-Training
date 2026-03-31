package List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    public static List<Integer> removeDuplicates(List<Integer> list) {

        // LinkedHashSet preserves insertion order
        Set<Integer> set = new LinkedHashSet<>(list);

        // Convert back to List
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

        List<Integer> input = List.of(3, 1, 2, 2, 3, 4);

        List<Integer> result = removeDuplicates(input);

        System.out.println(result);
    }
}
