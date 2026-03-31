package jsonPractice;
import org.json.JSONArray;
import org.json.JSONObject;

public class Student {
    public static void main(String[] args) {

        // Create JSONObject
        JSONObject student = new JSONObject();

        // Add simple fields
        student.put("name", "Mahi Sharma");
        student.put("age", 22);

        // Create subjects array
        JSONArray subjects = new JSONArray();
        subjects.put("Java");
        subjects.put("Python");
        subjects.put("AI");

        // Add array to JSON object
        student.put("subjects", subjects);

        // Print JSON in formatted form
        System.out.println(student.toString(2));
    }
}
