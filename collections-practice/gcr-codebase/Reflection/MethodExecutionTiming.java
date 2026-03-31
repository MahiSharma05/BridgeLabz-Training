package reflection;

import java.lang.reflect.Method;

public class MethodExecutionTiming {

    public static void main(String[] args) {

        try {
            // Class to analyze
            Class<?> clazz = SampleService.class;

            // Create object dynamically
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // Get all declared methods
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {

                // Only invoke methods with no parameters
                if (method.getParameterCount() == 0) {

                    method.setAccessible(true);

                    long startTime = System.nanoTime();

                    // Invoke method dynamically
                    method.invoke(obj);

                    long endTime = System.nanoTime();

                    long duration = endTime - startTime;

                    System.out.println(
                        "Method: " + method.getName() +
                        " | Execution Time: " + duration + " ns"
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//  SAMPLE CLASS
class SampleService {

    public void fastMethod() {
        System.out.println("Fast method executed");
    }

    public void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow method executed");
    }
}
