package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Define @RoleAllowed Annotation
@Retention(RetentionPolicy.RUNTIME)     // Needed for reflection
@Target(ElementType.METHOD)             // Restrict methods
@interface RoleAllowed {
    String value();                     // Role name (e.g., ADMIN)
}

// Step 2: Simulate Current User Context
class UserContext {
    static String currentRole = "USER"; // Change to "ADMIN" to allow access
}

// Step 3: Apply @RoleAllowed to Methods
class AdminService {

    @RoleAllowed("ADMIN")
    void deleteUser() {
        System.out.println("User deleted successfully.");
    }

    void viewProfile() {
        System.out.println("Viewing profile (allowed for all).");
    }
}

// Step 4: Validate Role Before Method Execution
public class RoleAllowedDemo {

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Class<?> cls = service.getClass();

        for (Method method : cls.getDeclaredMethods()) {

            if (method.isAnnotationPresent(RoleAllowed.class)) {

                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (UserContext.currentRole.equals(roleAllowed.value())) {
                    method.invoke(service); // Access granted
                } else {
                    System.out.println("Access Denied!");
                }

            } else {
                // No role restriction
                method.invoke(service);
            }
        }
    }
}

