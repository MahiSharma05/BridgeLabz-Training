package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Create Custom Annotation
@Retention(RetentionPolicy.RUNTIME)   // Needed for reflection
@Target(ElementType.METHOD)           // Can be used on methods
@interface TaskInfo {
    int priority();
    String assignedTo();
}

//  Use Annotation in a Class
class TaskManager {

    @TaskInfo(priority = 1, assignedTo = "Mahi")
    void completeProject() {
        System.out.println("Project completed");
    }
}

//  Retrieve Annotation using Reflection
public class TaskInfoDemo {
    public static void main(String[] args) throws Exception {

        TaskManager manager = new TaskManager();

        // Get Class object
        Class<?> cls = manager.getClass();

        // Get Method object
        Method method = cls.getDeclaredMethod("completeProject");

        // Get Annotation
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        // Display Annotation Details
        System.out.println("Task Priority : " + taskInfo.priority());
        System.out.println("Assigned To   : " + taskInfo.assignedTo());
    }
}
