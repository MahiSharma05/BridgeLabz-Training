package reflection;

import java.lang.reflect.Field;

public class ConfigurationReflection {

    public static void main(String[] args) {

        try {
            // Correct fully qualified class name
            Class<?> cls = Class.forName("reflection.Configuration");

            // Access private static field
            Field field = cls.getDeclaredField("API_KEY");
            field.setAccessible(true);

            // Modify static field (null because it's static)
            field.set(null, "UPDATED_SECRET_KEY");

            // Print updated value
            System.out.println("Updated API_KEY: " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Same package (reflection), non-public class
class Configuration {

    private static String API_KEY = "ORIGINAL_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}
