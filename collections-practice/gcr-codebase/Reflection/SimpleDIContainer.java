package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

public class SimpleDIContainer {

    public static void main(String[] args) {

        // Create DI container
        SimpleDIContainerDemo container = new SimpleDIContainerDemo();

        // Get object with dependencies injected
        UserService userService = container.getBean(UserService.class);

        // Test
        userService.process();
    }
}

// CUSTOM ANNOTATION
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

// DI CONTAINER 
class SimpleDIContainerDemo {

    public <T> T getBean(Class<T> clazz) {
        try {
            // Create object of requested class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Scan fields
            for (Field field : clazz.getDeclaredFields()) {

                // Check @Inject annotation
                if (field.isAnnotationPresent(Inject.class)) {

                    // Create dependency object
                    Class<?> fieldType = field.getType();
                    Object dependency = fieldType.getDeclaredConstructor().newInstance();

                    // Inject dependency
                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException("DI failed", e);
        }
    }
}

// SERVICE CLASSES
class UserService {

    @Inject
    private UserRepository userRepository;

    public void process() {
        userRepository.save();
    }
}

class UserRepository {

    public void save() {
        System.out.println("User saved successfully!");
    }
}
