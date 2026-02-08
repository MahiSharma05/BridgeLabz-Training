package SmartUniversityLibraryManagementSystem;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String edition;
    private String publisher;

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.genre = builder.genre;
        this.edition = builder.edition;
        this.publisher = builder.publisher;
    }

    public String getTitle() {
        return title;
    }

    public static class BookBuilder {
        private String title;
        private String author;
        private String genre;
        private String edition;
        private String publisher;

        public BookBuilder(String title) {
            this.title = title;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookBuilder setEdition(String edition) {
            this.edition = edition;
            return this;
        }

        public BookBuilder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

