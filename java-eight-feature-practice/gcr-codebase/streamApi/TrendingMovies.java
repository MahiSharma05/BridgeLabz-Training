package streamApi;
import java.util.*;
import java.util.stream.*;

class Movie {
    private String name;
    private double rating;
    private int releaseYear;

    public Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return name + " | Rating: " + rating + " | Year: " + releaseYear;
    }
}

public class TrendingMovies {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.9, 2023),
            new Movie("Movie B", 9.1, 2024),
            new Movie("Movie C", 8.7, 2022),
            new Movie("Movie D", 9.3, 2024),
            new Movie("Movie E", 9.0, 2023),
            new Movie("Movie F", 8.5, 2021),
            new Movie("Movie G", 9.2, 2024)
        );

        List<Movie> top5Trending = movies.stream()

            // keep only well-rated movies
            .filter(m -> m.getRating() >= 8.5)

            // sorted first by rating (desc), then by release year (desc)
            .sorted(
                Comparator.comparing(Movie::getRating).reversed()
                          .thenComparing(Movie::getReleaseYear).reversed()
            )

            // top 5 movies
            .limit(5)

            // collect result
            .collect(Collectors.toList());

        top5Trending.forEach(System.out::println);
    }
}
