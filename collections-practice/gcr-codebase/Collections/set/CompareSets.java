package set;
import java.util.Set;
import java.util.HashSet;

public class CompareSets {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();

		// add values to set 1
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		Set<Integer> set2 = new HashSet<>();

		// add values to set 2
		set2.add(3);
		set2.add(2);
		set2.add(1);
		System.out.println(" Set 1: " + set1);
		System.out.println(" Set 2: " + set2);
		System.out.println(set1.equals(set2));
	}

}
