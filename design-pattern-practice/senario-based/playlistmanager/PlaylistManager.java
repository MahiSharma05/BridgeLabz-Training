package playlistmanager;

import java.util.*;

public class PlaylistManager {

    private LinkedList<Song> playlist = new LinkedList<>();
    private Stack<Song> recentlyPlayed = new Stack<>();
    private Set<Song> songSet = new HashSet<>();

    // Add song
    public void addSong(Song song)
            throws SongAlreadyExistsException {

        if (songSet.contains(song)) {
            throw new SongAlreadyExistsException(
                    "Song already exists in playlist.");
        }

        playlist.add(song);
        songSet.add(song);

        System.out.println(song.getTitle() + " added to playlist.");
    }

    // Play song
    public void playSong(int songId) {

        for (Song s : playlist) {
            if (s.getId() == songId) {
                recentlyPlayed.push(s);
                System.out.println("Now playing: " + s);
                return;
            }
        }

        System.out.println("Song not found.");
    }

    // Show playlist
    public void showPlaylist() {

        System.out.println("\n--- Playlist ---");
        for (Song s : playlist) {
            System.out.println(s);
        }
    }

    // Show recently played
    public void showRecentlyPlayed() {

        System.out.println("\n--- Recently Played ---");

        if (recentlyPlayed.isEmpty()) {
            System.out.println("No songs played yet.");
            return;
        }

        for (Song s : recentlyPlayed) {
            System.out.println(s);
        }
    }

    // Remove song
    public void removeSong(int songId) {

        Iterator<Song> iterator = playlist.iterator();

        while (iterator.hasNext()) {
            Song s = iterator.next();

            if (s.getId() == songId) {
                iterator.remove();
                songSet.remove(s);
                System.out.println("Removed: " + s);
                return;
            }
        }

        System.out.println("Song not found.");
    }
}
