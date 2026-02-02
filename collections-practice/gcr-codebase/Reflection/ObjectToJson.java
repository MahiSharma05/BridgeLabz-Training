package reflection;

import java.lang.reflect.Field;

public class ObjectToJson {

    public static void main(String[] args) {

        Students student = new Students(101, "Mahi", 22);

        String json = toJson(student);
        System.out.println(json);
    }

    // 🔹 Convert Object → JSON-like String
    public static String toJson(Object obj) {

        StringBuilder json = new StringBuilder();
        Class<?> clazz = obj.getClass();

        json.append("{");

        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                json.append("\"").append(field.getName()).append("\": ");

                Object value = field.get(obj);

                // String values in quotes
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                // Add comma if not last field
                if (i < fields.length - 1) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}

// 👇 Sample class
class Students {

    private int id;
    private String name;
    private int age;

    public Students(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
