class Book {
    String title;
    String author;
    double price;
    boolean availability;

    // Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true; 
    }

    // Method to borrow a book
    void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + availability);
        System.out.println("----------------------------");
    }
}

public class LibraryDetails {
    public static void main(String[] args) {

        // Create book object
        Book book1 = new Book("Wings Of Fire", "A. P. J. Abdul Kalam", 500.0);

        // Display details before borrowing
        book1.displayDetails();

        // Borrow the book
        book1.borrowBook();

        // Try borrowing again
        book1.borrowBook();

        // Display details after borrowing
        book1.displayDetails();
    }
}

