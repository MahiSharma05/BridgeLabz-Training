package InvokePrivateMethod;

import java.lang.reflect.Method;

public class InvokePrivateMethod {

    public static void main(String[] args) {

        try {
            // Create object of Calculator
            Calculator calc = new Calculator();

            // Get Class object
            Class<?> cls = calc.getClass();

            // Get private method multiply(int, int)
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

            //Allow access to private method
            method.setAccessible(true);

            // Invoke method
            int result = (int) method.invoke(calc, 5, 4);

            // Print result
            System.out.println("Result of multiplication: " + result);

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

