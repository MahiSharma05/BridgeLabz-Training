package Regex;

public class SpaceReplacer {

    // Method to replace multiple spaces with a single space
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {

        String text = "This   is   an   example   with   multiple    spaces.";
        String output = normalizeSpaces(text);
        System.out.println(output);
    }
}