package auction;

public class User implements Comparable<User> {

    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    // TreeMap requires sorting → implement Comparable
    @Override
    public int compareTo(User other) {
        return Integer.compare(this.userId, other.userId);
    }

    @Override
    public String toString() {
        return userId + " - " + name;
    }
}
