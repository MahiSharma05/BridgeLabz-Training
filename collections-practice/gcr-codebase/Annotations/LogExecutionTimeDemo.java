package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Define the Annotation
@Retention(RetentionPolicy.RUNTIME)     // Needed for reflection
@Target(ElementType.METHOD)             // Can be applied to methods
@interface LogExecutionTime {
}

// Step 2: Apply Annotation to Methods
class TaskExecutor {

    @LogExecutionTime
    void fastTask() {
        for (int i = 0; i < 1_000_000; i++); // small loop
    }

    @LogExecutionTime
    void slowTask() {
        for (int i = 0; i < 100_000_000; i++); // larger loop
    }
}

// Step 3: Measure Execution Time using Reflection
public class LogExecutionTimeDemo {

    public static void main(String[] args) throws Exception {

        TaskExecutor executor = new TaskExecutor();
        Class<?> cls = executor.getClass();

        for (Method method : cls.getDeclaredMethods()) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();

                method.invoke(executor);   // execute method

                long endTime = System.nanoTime();

                long executionTime = endTime - startTime;

                System.out.println(
                    "Method: " + method.getName() +
                    " | Execution Time: " + executionTime + " ns"
                );
            }
        }
    }
}

