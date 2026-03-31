package RuntimeAnnotation;

public class AnnotationReader {

    public static void main(String[] args) {

        try {
            // Load class dynamically
            Class<?> cls = Class.forName("RuntimeAnnotation.Book");

            // Check if annotation is present
            if (cls.isAnnotationPresent(Author.class)) {

                // Get annotation
                Author author = cls.getAnnotation(Author.class);

                // Display annotation value
                System.out.println("Author Name: " + author.name());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
