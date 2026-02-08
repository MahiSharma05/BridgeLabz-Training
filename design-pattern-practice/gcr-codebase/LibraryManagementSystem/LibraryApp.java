package LibraryManagementSystem;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User student = UserFactory.createUser("student", "Alice");
        User faculty = UserFactory.createUser("faculty", "Dr. Bob");
        User guest = UserFactory.createUser("guest", "Charlie");

        student.showRole();
        faculty.showRole();
        guest.showRole();

        catalog.addObserver(student);
        catalog.addObserver(faculty);
        catalog.addObserver(guest);

        Book book = new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .edition("2nd")
                .genre("Software Engineering")
                .build();

        catalog.addBook(book);

        ReservationStrategy studentRes = new StudentReservation();
        ReservationStrategy facultyRes = new FacultyReservation();

        studentRes.reserve(student, book);
        facultyRes.reserve(faculty, book);
    }
}

