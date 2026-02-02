package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Create Custom Annotation
@Retention(RetentionPolicy.RUNTIME)   // Needed for Reflection
@Target(ElementType.METHOD)           // Can be applied to methods
@interface ImportantMethod {
    String level() default "HIGH";    // Optional parameter with default value
}

// Step 2: Apply Annotation to Methods
class Service {

    @ImportantMethod
    void processPayment() {
        System.out.println("Processing payment...");
    }

    @ImportantMethod(level = "MEDIUM")
    void generateReport() {
        System.out.println("Generating report...");
    }

    void helperMethod() {
        System.out.println("Helper method (not important)");
    }
}

// Step 3: Retrieve and Print Annotated Methods
public class ImportantMethodDemo {
    public static void main(String[] args) {

        Class<Service> cls = Service.class;

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod im = method.getAnnotation(ImportantMethod.class);

                System.out.println(
                    "Method Name : " + method.getName() +
                    ", Importance Level : " + im.level()
                );
            }
        }
    }
}

