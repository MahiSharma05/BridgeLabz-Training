package SmartUniversityLibraryManagementSystem;

public class LibraryUserObserver implements Observer {
    private String userName;

    public LibraryUserObserver(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + userName + ": " + message);
    }
}

