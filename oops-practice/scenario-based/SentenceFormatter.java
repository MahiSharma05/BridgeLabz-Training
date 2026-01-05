package scenario;

public class SentenceFormatter {

    // Method to format the paragraph
    public static String formatSentence(String paragraph) {

        // Remove extra spaces from start and end
        paragraph = paragraph.trim();

        // Replace multiple spaces with a single space
        paragraph = paragraph.replaceAll("\\s+", " ");

        // Ensure one space after punctuation
        paragraph = paragraph.replaceAll("\\s*([.!?])\\s*", "$1 ");

        // Capitalize first letter of each sentence
        char[] ch = paragraph.toCharArray();
        boolean capitalize = true;

        for (int i = 0; i < ch.length; i++) {

            if (capitalize && Character.isLetter(ch[i])) {
                ch[i] = Character.toUpperCase(ch[i]);
                capitalize = false;
            }

            if (ch[i] == '.' || ch[i] == '!' || ch[i] == '?') {
                capitalize = true;
            }
        }

        return new String(ch).trim();
    }

    // Main method
    public static void main(String[] args) {

        String input = "  hello   world.this is  java!how are you?i am fine.  ";

        String result = formatSentence(input);

        System.out.println("Formatted Paragraph:");
        System.out.println(result);
    }
}
