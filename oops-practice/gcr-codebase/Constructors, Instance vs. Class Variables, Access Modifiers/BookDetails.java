class Book {
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class BookDetails {
    public static void main(String[] args) {

        // Using default constructor
        Book book1 = new Book();
        book1.displayDetails();

        System.out.println("--------------------");

        // Using parameterized constructor
        Book book2 = new Book("2 States", "Chetan Bhagat", 500.0);
        book2.displayDetails();
    }
}
