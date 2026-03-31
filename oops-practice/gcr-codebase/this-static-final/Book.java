public class Book {
  static String libraryName = "Egmore Library";
  String title;
  String author;
  final String ISBN;

  Book(String title, String author, String ISBN) {
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
  }

  public void displayDetails() {
    if (this instanceof Book) {
      System.out.println("Title: " + title);
      System.out.println("Author: " + author);
      System.out.println("ISBN: " + ISBN);
    } else {
      System.out.println("Invalid Book instance");
    }
  }

  static void displayLibraryName() {
    System.out.println("Library Name: " + libraryName);

  }

  public static void main(String[] args) {
    Book b = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
    displayLibraryName();
    b.displayDetails();

  }

}
