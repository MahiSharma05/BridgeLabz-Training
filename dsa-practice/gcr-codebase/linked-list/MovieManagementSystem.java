package linkedList;
import java.util.Scanner;

class MovieNode {
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head;
    private MovieNode tail;

    // add at beginning
    public void addAtBeginning(String movieTitle, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at beginning");
    }

    // add at end
    public void addAtEnd(String movieTitle, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at end");
    }

    // add at specific position
    public void addAtPosition(int position, String movieTitle, String director, int yearOfRelease, double rating) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addAtBeginning(movieTitle, director, yearOfRelease, rating);
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;
        System.out.println("Movie added at position " + position);
    }

    // Delete by Movie Title
    public void deleteByMovieTitle(String movieTitle) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        MovieNode temp = head;

        while (temp != null && !temp.movieTitle.equalsIgnoreCase(movieTitle)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie deleted successfully");
    }

    // search by Director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for this director");
    }

    // search by Rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating");
    }

    // update rating
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.movieTitle.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    // display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movie records available");
            return;
        }

        MovieNode temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movie records available");
            return;
        }

        MovieNode temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    private void displayMovie(MovieNode m) {
        System.out.println("----------------------------");
        System.out.println("Title: " + m.movieTitle);
        System.out.println("Director: " + m.director);
        System.out.println("Year: " + m.yearOfRelease);
        System.out.println("Rating: " + m.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        while (true) {
            System.out.println("\nMovie Management System");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Update Rating");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Director: ");
                    String director = input.nextLine();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    System.out.print("Rating: ");
                    double rating = input.nextDouble();
                    input.nextLine();

                    if (choice == 1)
                        list.addAtBeginning(title, director, year, rating);
                    else if (choice == 2)
                        list.addAtEnd(title, director, year, rating);
                    else {
                        System.out.print("Position: ");
                        int pos = input.nextInt();
                        input.nextLine();
                        list.addAtPosition(pos, title, director, year, rating);
                    }
                    break;

                case 4:
                    System.out.print("Enter movie title: ");
                    list.deleteByMovieTitle(input.nextLine());
                    break;

                case 5:
                    System.out.print("Enter director name: ");
                    list.searchByDirector(input.nextLine());
                    break;

                case 6:
                    System.out.print("Enter rating: ");
                    list.searchByRating(input.nextDouble());
                    input.nextLine();
                    break;

                case 7:
                    list.displayForward();
                    break;

                case 8:
                    list.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter movie title: ");
                    String t = input.nextLine();
                    System.out.print("New rating: ");
                    double r = input.nextDouble();
                    input.nextLine();
                    list.updateRating(t, r);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
