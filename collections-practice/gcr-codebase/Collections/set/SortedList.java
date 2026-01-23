package set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SortedList {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();

		// add values to set 
		set.add(5);
		set.add(3);
		set.add(9);
		set.add(1);
		
		// Convert set to list
		List<Integer> list = new ArrayList<>(set);
		
		// Sort the list
		
		Collections.sort(list);
		
		System.out.println(list);
		

	
		
	}	

}
