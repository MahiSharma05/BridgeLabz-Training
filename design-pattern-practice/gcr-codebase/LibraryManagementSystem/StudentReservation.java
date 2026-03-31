package LibraryManagementSystem;

public class StudentReservation implements ReservationStrategy {
    public void reserve(User user, Book book) {
        System.out.println(user.getName() +
                " reserved book for 7 days: " + book.getTitle());
    }
}

