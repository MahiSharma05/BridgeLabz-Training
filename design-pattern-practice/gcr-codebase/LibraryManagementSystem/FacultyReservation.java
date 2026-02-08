package LibraryManagementSystem;

public class FacultyReservation implements ReservationStrategy {
    public void reserve(User user, Book book) {
        System.out.println(user.getName() +
                " reserved book for 30 days: " + book.getTitle());
    }
}

