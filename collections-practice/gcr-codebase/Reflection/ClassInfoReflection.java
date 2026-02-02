package reflection;
import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfoReflection {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = input.nextLine();

        try {
            // Load class dynamically
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass Name: " + cls.getName());

            // Get Constructors
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }

            // Get Fields
            System.out.println("\n--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }

            // Get Methods
            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

        } 
        catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }
    }
}
