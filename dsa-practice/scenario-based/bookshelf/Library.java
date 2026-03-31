package bookshelf;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashSet;

public class Library {

    // genre -> list of books
    private HashMap<String, LinkedList<Book>> catalog = new HashMap<>();

    // optional: to avoid duplicate books
    private HashSet<Book> bookSet = new HashSet<>();

    // Add book
    public void addBook(String genre, Book book) {

        if (bookSet.contains(book)) {
            System.out.println("Duplicate book not allowed.");
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        bookSet.add(book);

        System.out.println("Book added successfully.");
    }

    // Borrow (remove) book
    public void borrowBook(String genre, String title) {

        if (!catalog.containsKey(genre)) {
            System.out.println("Genre not found.");
            return;
        }

        LinkedList<Book> books = catalog.get(genre);

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                books.remove(b);
                bookSet.remove(b);
                System.out.println("Book borrowed: " + b);
                return;
            }
        }
        System.out.println("Book not available.");
    }

    // Display genre-wise catalog
    public void displayCatalog() {

        if (catalog.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        for (String genre : catalog.keySet()) {
            System.out.println("\nGenre: " + genre);
            for (Book b : catalog.get(genre)) {
                System.out.println("  " + b);
            }
        }
    }
}
