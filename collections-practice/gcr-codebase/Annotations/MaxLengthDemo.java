package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Step 1: Define @MaxLength Annotation
@Retention(RetentionPolicy.RUNTIME)     // Available at runtime
@Target(ElementType.FIELD)              // Applied to fields
@interface MaxLength {
    int value();                        // Maximum allowed length
}

// Step 2: Use Annotation in User Class
class User {

    @MaxLength(10)
    private String username;

    // Constructor with validation
    public User(String username) {

        // Validate field length using reflection
        try {
            Field field = this.getClass().getDeclaredField("username");
            MaxLength maxLength = field.getAnnotation(MaxLength.class);

            if (maxLength != null && username.length() > maxLength.value()) {
                throw new IllegalArgumentException(
                    "Username length exceeds maximum limit of " + maxLength.value()
                );
            }

            this.username = username;

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Step 3: Test the Validation
public class MaxLengthDemo {
    public static void main(String[] args) {

        // Valid username
        User user1 = new User("Mahi123");
        System.out.println("User created: " + user1.getUsername());

        // Invalid username (length > 10)
        User user2 = new User("VeryLongUsername"); // Exception here
    }
}
