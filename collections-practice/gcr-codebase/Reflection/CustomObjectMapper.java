package reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CustomObjectMapper {

    public static void main(String[] args) {

        // Input data (like JSON → Map)
        Map<String, Object> data = new HashMap<>();
        data.put("id", 101);
        data.put("name", "Mahi");
        data.put("age", 22);

        // Convert Map → Object
        Student student = toObject(Student.class, data);

        // Verify
        System.out.println(student);
    }

    // Generic Object Mapper
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {

        try {
            // Create object using default constructor
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate over fields
            for (Map.Entry<String, Object> entry : properties.entrySet()) {

                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                // Access field by name
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                // Set value
                field.set(obj, fieldValue);
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Object mapping failed", e);
        }
    }
}

// Model class
class Student {

    private int id;
    private String name;
    private int age;

    // Mandatory default constructor
    public Student() {}

    @Override
    public String toString() {
        return "Student { id=" + id + ", name='" + name + "', age=" + age + " }";
    }
}
