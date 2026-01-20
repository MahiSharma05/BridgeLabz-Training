package MovieScheduleManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieScheduleManagerMain {

    static List<MovieTitles> titles = new ArrayList<>();
    static List<ShowTime> times = new ArrayList<>();
    
    // Add movie
    static void addMovie(String title, String time) throws InvalidTimeFormatException {
        validateTime(time);
        titles.add(new MovieTitles(title));
        times.add(new ShowTime(time));
        System.out.println("Movie added successfully!");
    }

    // Validate time HH:MM
    static void validateTime(String time) throws InvalidTimeFormatException {
        try {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new InvalidTimeFormatException("Invalid time: " + time);
            }
        } catch (Exception e) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
    }

    // Search movie using contains()
    static void searchMovie(String keyword) {
        boolean found = false;

        for (int i = 0; i < titles.size(); i++) {
            try {
                if (titles.get(i).title.toLowerCase()
                        .contains(keyword.toLowerCase())) {

                    System.out.println(
                        String.format("Found: %s at %s",
                                titles.get(i).title,
                                times.get(i).time)
                    );
                    found = true;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException handled.");
            }
        }

        if (!found) {
            System.out.println("Movie not found.");
        }
    }

    // Display all movies
    static void displayAllMovies() {
        if (titles.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        for (int i = 0; i < titles.size(); i++) {
            System.out.println(
                    titles.get(i).title + " - Time: " + times.get(i).time
            );
        }
    }

    // Convert list to array
    static void generateReport() {
        MovieTitles[] titleArray = titles.toArray(new MovieTitles[0]);
        ShowTime[] timeArray = times.toArray(new ShowTime[0]);

        System.out.println("\n--- Movie Report ---");
        for (int i = 0; i < titleArray.length; i++) {
            System.out.println(
                    titleArray[i].title + " | " + timeArray[i].time
            );
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n CinemaTime – Movie Schedule Manager");
            System.out.println("1. Add Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. Search Movie");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter movie title: ");
                        String title = input.nextLine();

                        System.out.print("Enter show time (HH:MM): ");
                        String time = input.nextLine();

                        addMovie(title, time);
                    } catch (InvalidTimeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    displayAllMovies();
                    break;

                case 3:
                    System.out.print("Enter search keyword: ");
                    String keyword = input.nextLine();
                    searchMovie(keyword);
                    break;

                case 4:
                    generateReport();
                    break;

                case 5:
                    System.out.println("Exiting!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } 
        while (choice != 5);
    }
}
