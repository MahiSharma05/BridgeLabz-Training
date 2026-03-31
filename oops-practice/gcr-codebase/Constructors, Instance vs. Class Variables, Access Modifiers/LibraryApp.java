class Book {

    // Access modifiers
    public String ISBN;
    protected String title;
    private String author;

    // Constructor
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public getter for author
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass demonstrating access modifiers
class EBook extends Book {

    String fileFormat;

    // Constructor
    EBook(String ISBN, String title, String author, String fileFormat) {
        super(ISBN, title, author);
        this.fileFormat = fileFormat;
    }

    // Method accessing public and protected members
    void displayEBookDetails() {
        System.out.println("EBook ISBN: " + ISBN);
        System.out.println("EBook Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("File Format: " + fileFormat);
    }
}

public class LibraryApp {
    public static void main(String[] args) {

        // Book object
        Book book = new Book("ISBN001", "Java Programming", "James Gosling");
        book.displayBookDetails();

        System.out.println("----------------------------");

        // Modify author using setter
        book.setAuthor("Herbert Schildt");
        System.out.println("Updated Author: " + book.getAuthor());

        System.out.println("----------------------------");

        // EBook object
        EBook ebook = new EBook("ISBN002", "Advanced Java", "Oracle", "PDF");

        ebook.displayEBookDetails();
    }
}
