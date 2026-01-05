package scenario;

public class ParagraphAnalyzer {

    public static void main(String[] args) {

        String paragraph = "Java is a powerful programming language. Java is widely used.";
        String wordToReplace = "java";
        String replacementWord = "Python";

        // Check empty or space-only paragraph
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("Paragraph is empty or contains only spaces.");
            return;
        }

        // Remove extra spaces
        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        // Split paragraph into words
        String[] words = paragraph.split(" ");

        // Count words
        int wordCount = words.length;

        // Find longest word
        String longestWord = words[0];
        for (String word : words) {
            // Remove punctuation while comparing
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        // Replace word (case-insensitive)
        String replacedParagraph =
                paragraph.replaceAll("(?i)\\b" + wordToReplace + "\\b", replacementWord);

        // Output
        System.out.println("Original Paragraph:");
        System.out.println(paragraph);

        System.out.println("\nWord Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);

        System.out.println("\nParagraph after Replacement:");
        System.out.println(replacedParagraph);
    }
}

