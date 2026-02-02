package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Define @Todo Annotation
@Retention(RetentionPolicy.RUNTIME)   // Required for reflection
@Target(ElementType.METHOD)           // Can be applied to methods
@interface Todo {
    String task();                    // Task description
    String assignedTo();              // Developer name
    String priority() default "MEDIUM"; // Default priority
}

// Step 2: Apply @Todo to Multiple Methods
class ProjectTasks {

    @Todo(
        task = "Implement login feature",
        assignedTo = "Mahi",
        priority = "HIGH"
    )
    void loginFeature() { }

    @Todo(
        task = "Add payment gateway",
        assignedTo = "Aman"
    )
    void paymentFeature() { }

    @Todo(
        task = "Improve UI design",
        assignedTo = "Riya",
        priority = "LOW"
    )
    void uiEnhancement() { }
}

// Step 3: Retrieve and Print All Pending Tasks
public class TodoDemo {
    public static void main(String[] args) {

        Class<ProjectTasks> cls = ProjectTasks.class;

        Method[] methods = cls.getDeclaredMethods();

        System.out.println("📌 Pending Tasks:\n");

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {

                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method     : " + method.getName());
                System.out.println("Task       : " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority   : " + todo.priority());
                System.out.println("-----------------------------");
            }
        }
    }
}

