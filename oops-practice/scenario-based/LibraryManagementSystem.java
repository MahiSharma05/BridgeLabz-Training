import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception (Outside main class) 
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Book data stored in an Array 
        Book[] bookArray = {
                new Book("Java Programming", "James Gosling", true),
                new Book("Clean Code", "Robert Martin", true),
                new Book("Data Structures", "Mark Allen", true),
                new Book("Operating Systems", "Andrew Tanenbaum", true)
        };

        // Convert Array to List 
        List<Book> library = new ArrayList<>();
        for (Book b : bookArray) {
            library.add(b);
        }

        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Display Books");
            System.out.println("2. Search Book");
            System.out.println("3. Checkout Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        displayBooks(library);
                        break;
                    case 2:
                        searchBook(library, input);
                        break;
                    case 3:
                        checkoutBook(library, input);
                        break;
                    case 4:
                        System.out.println("Exiting Library System...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } 
            catch (BookNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } 
        while (choice != 4);

        input.close();
    }
    // Book class 
    static class Book {
        String title;
        String author;
        boolean isAvailable;

        Book(String title, String author, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.isAvailable = isAvailable;
        }
    }

    // Display all books 
    static void displayBooks(List<Book> books) {
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            System.out.println(
                    b.title + " | " + b.author + " | " +
                    (b.isAvailable ? "Available" : "Checked Out"));
        }
    }

    // Search book by partial title 
    static void searchBook(List<Book> books, Scanner sc) {
        System.out.print("Enter partial title to search: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword)) {
                System.out.println(
                        b.title + " | " + b.author + " | " +
                        (b.isAvailable ? "Available" : "Checked Out"));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    // Checkout book
    static void checkoutBook(List<Book> books, Scanner sc)
            throws BookNotAvailableException {

        System.out.print("Enter book title to checkout: ");
        String title = sc.nextLine();

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.isAvailable) {
                    throw new BookNotAvailableException(
                            "Book is already checked out.");
                }
                b.isAvailable = false;
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
