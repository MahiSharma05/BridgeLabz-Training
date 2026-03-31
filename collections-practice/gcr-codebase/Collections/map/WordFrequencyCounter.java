package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\sony\\eclipse-workspace\\Collection\\src\\map\\input.txt"; 

        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                // Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-z ]", "");

                // Split into words
                String[] words = line.split("\\s+");

                // Count frequency
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } 
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println(wordCount);
    }
}

