package lexicalTwist;
import java.util.*;

public class LexicalTwist {

    // check if input is a valid single word
    private static boolean isValidWord(String word) {
        return !word.contains(" ");
    }

    // check vowel
    private static boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) != -1;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter first word");
        String firstWord = input.nextLine();

        if (!isValidWord(firstWord)) {
            System.out.println(firstWord +" is an invalid word");
            return;
        }

        System.out.println("Enter second word");
        String secondWord = input.nextLine();

        if (!isValidWord(secondWord)) {
            System.out.println(secondWord + " is an invalid word");
            return;
        }

        // Check if second word is reverse of first (case-insensitive)
        String reversedWord1 = new StringBuilder(firstWord).reverse().toString();

        if (reversedWord1.equalsIgnoreCase(secondWord)) {

            // Reverse firstWord , convert into lowercase and replace vowels to @
            String transformed = reversedWord1.toLowerCase();
            transformed = transformed.replaceAll("[aeiou]", "@");
            System.out.println(transformed);

        } else {

            // Combine and convert to uppercase
            String combined = (firstWord + secondWord).toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            for (char ch : combined.toCharArray()) {
                if (isVowel(ch)) {
                    vowelCount++;
                } 
                else {
                    consonantCount++;
                }
            }

            if (vowelCount > consonantCount) {

                // Print first 2 unique vowels
                LinkedHashSet<Character> vowels = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (isVowel(ch)) {
                        vowels.add(ch);
                    }
                    if (vowels.size() == 2)
                        break;
                }

                for (char v : vowels)
                    System.out.print(v);

            } 
            else if (consonantCount > vowelCount) {

                // Print first 2 unique consonants
                LinkedHashSet<Character> consonants = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (!isVowel(ch)) {
                        consonants.add(ch);
                    }
                    if (consonants.size() == 2)
                        break;
                }

                for (char c : consonants)
                    System.out.print(c);

            } 
            else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        input.close();
    }
}
