package Collectors;
import java.util.*;
import java.util.stream.*;
public class WordFrequencyCounter {

	public static void main(String[] args) {
		String paragraph = "I am Learning Java and Java is Powerful Language.";
		
		Map<String, Integer> wordOccurence = Arrays.stream(paragraph.split("\\s+"))
				.collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
		
		wordOccurence.forEach((word, count) -> System.out.println(word + ": " + count));
		

	}

}
