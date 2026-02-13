package playlistmanager;

public class SongAlreadyExistsException extends Exception {

    public SongAlreadyExistsException(String message) {
        super(message);
    }
}
