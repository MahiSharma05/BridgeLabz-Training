package DynamicallyCreateObjects;

import java.lang.reflect.Constructor;

public class CreateObjectUsingReflection {

    public static void main(String[] args) {

        try {
            // ✅ Use FULLY QUALIFIED CLASS NAME
            Class<?> cls = Class.forName("DynamicallyCreateObjects.Student");

            // Get constructor (int, String)
            Constructor<?> constructor =
                    cls.getDeclaredConstructor(int.class, String.class);

            // Create object dynamically
            Object obj = constructor.newInstance(101, "Mahi");

            // Cast to Student
            Student student = (Student) obj;

            // Call method
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
