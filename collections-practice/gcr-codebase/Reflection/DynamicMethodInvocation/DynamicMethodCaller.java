package DynamicMethodInvocation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodCaller {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            // User input
            System.out.print("Enter method name (add / subtract / multiply): ");
            String methodName = sc.next();

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            // Load class dynamically
            Class<?> cls = Class.forName("DynamicMethodInvocation.MathOperations");

            // Create object
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Get method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);

            // Invoke method
            Object result = method.invoke(obj, a, b);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Invalid method name or error occurred!");
            e.printStackTrace();
        }
    }
}
