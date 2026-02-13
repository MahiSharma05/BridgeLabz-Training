package playlistmanager;

import java.util.Objects;

public class Song {

    private int id;
    private String title;
    private String artist;

    public Song(int id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return id + " - " + title + " by " + artist;
    }

    // Prevent duplicates based on song id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Song)) return false;
        Song s = (Song) obj;
        return this.id == s.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
