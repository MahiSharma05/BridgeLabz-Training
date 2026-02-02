package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Step 1: Define @JsonField Annotation
@Retention(RetentionPolicy.RUNTIME)     // Needed for reflection
@Target(ElementType.FIELD)              // Applied to fields
@interface JsonField {
    String name();                      // Custom JSON key name
}

// Step 2: Apply Annotation to User Class
class Users {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "email_id")
    private String email;

    public Users(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

// Step 3: JSON Serializer using Reflection
class JsonSerializer {

    public static String toJson(Object obj) {

        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField jsonField = field.getAnnotation(JsonField.class);

                try {
                    Object value = field.get(obj);

                    if (!first) {
                        json.append(", ");
                    }

                    json.append("\"")
                        .append(jsonField.name())
                        .append("\": ");

                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }

                    first = false;

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        json.append("}");
        return json.toString();
    }
}

// Step 4: Test the Custom Serialization
public class JsonFieldDemo {
    public static void main(String[] args) {

        Users user = new Users("Mahi", 22, "mahi@gmail.com");

        String jsonOutput = JsonSerializer.toJson(user);

        System.out.println(jsonOutput);
    }
}

