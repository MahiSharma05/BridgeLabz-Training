package SmartUniversityLibraryManagementSystem;
public class LibraryApp {
    public static void main(String[] args) {

        // Singleton Catalog
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        // Builder Pattern
        Book book = new Book.BookBuilder("Java Programming by Thomas")
                .setAuthor("Thomas")
                .setGenre("Computer Science")
                .setEdition("3rd Edition")
                .setPublisher("IT Press")
                .build();

        catalog.addBook(book);

        // Factory Pattern
        User student = UserFactory.createUser("student", "Mahi");
        User faculty = UserFactory.createUser("faculty", "Dr. Mansi Sharma");

        student.getRole();
        faculty.getRole();

        // Observer Pattern
        NotificationService notificationService = new NotificationService();

        Observer o1 = new LibraryUserObserver("Mahi");
        Observer o2 = new LibraryUserObserver("Dr. Mansi Sharma");

        notificationService.subscribe(o1);
        notificationService.subscribe(o2);

        notificationService.notifyObservers(
            "Book 'Java Programming by Thomas' is now available!"
        );
    }
}

