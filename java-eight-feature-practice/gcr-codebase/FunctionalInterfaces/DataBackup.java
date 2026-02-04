package FunctionalInterfaces;

// Marker interface
interface BackupSerializable {
    // Empty on purpose
}

// Class marked for backup
class UserData implements BackupSerializable {
    private String username;
    private int userId;

    public UserData(String username, int userId) {
        this.username = username;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }
}

// Class NOT marked for backup
class TemporaryCache {
    private String cacheData;

    public TemporaryCache(String cacheData) {
        this.cacheData = cacheData;
    }
}

// Backup processor
class BackupManager {

    static void processBackup(Object obj) {

        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up object: " + obj.getClass().getSimpleName());
            // serialization / backup logic here
        } else {
            System.out.println("Backup skipped for: " + obj.getClass().getSimpleName());
        }
    }
}

public class DataBackup {

    public static void main(String[] args) {

        UserData user = new UserData("Mahi", 101);
        TemporaryCache cache = new TemporaryCache("SessionData");

        BackupManager.processBackup(user);
        BackupManager.processBackup(cache);
    }
}
