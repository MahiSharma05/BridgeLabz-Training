package playlistmanager;

public class Main {

    public static void main(String[] args) {

        PlaylistManager manager = new PlaylistManager();

        try {

            Song s1 = new Song(1, "Shape of You", "Ed Sheeran");
            Song s2 = new Song(2, "Believer", "Imagine Dragons");
            Song s3 = new Song(3, "Perfect", "Ed Sheeran");

            manager.addSong(s1);
            manager.addSong(s2);
            manager.addSong(s3);

            // Duplicate test
            manager.addSong(s1);

        } catch (SongAlreadyExistsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        manager.showPlaylist();

        manager.playSong(2);
        manager.playSong(1);

        manager.showRecentlyPlayed();

        manager.removeSong(2);

        manager.showPlaylist();
    }
}
