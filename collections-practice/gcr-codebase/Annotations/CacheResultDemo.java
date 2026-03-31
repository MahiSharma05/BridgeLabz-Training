package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define @CacheResult Annotation
@Retention(RetentionPolicy.RUNTIME)     // Needed for reflection
@Target(ElementType.METHOD)             // Applied to methods
@interface CacheResult {
}

// Step 2: Service with Expensive Method
class MathService {

    @CacheResult
    public int square(int n) {
        System.out.println("Computing square for: " + n);
        return n * n;
    }
}

// Step 3: Cache Manager using Reflection
class CacheManager {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invoke(Object obj, String methodName, Object... args) throws Exception {

        Class<?> cls = obj.getClass();

        Method method = cls.getDeclaredMethod(methodName, int.class);

        // Create a unique cache key (method + parameters)
        String cacheKey = methodName + "_" + args[0];

        // Check if method has @CacheResult
        if (method.isAnnotationPresent(CacheResult.class)) {

            // Return cached value if present
            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning cached result for: " + args[0]);
                return cache.get(cacheKey);
            }

            // Compute result and store in cache
            Object result = method.invoke(obj, args);
            cache.put(cacheKey, result);
            return result;
        }

        // If annotation not present, execute normally
        return method.invoke(obj, args);
    }
}

// Step 4: Test the Caching System
public class CacheResultDemo {

    public static void main(String[] args) throws Exception {

        MathService service = new MathService();

        System.out.println("Result: " + CacheManager.invoke(service, "square", 5));
        System.out.println("Result: " + CacheManager.invoke(service, "square", 5));
        System.out.println("Result: " + CacheManager.invoke(service, "square", 10));
        System.out.println("Result: " + CacheManager.invoke(service, "square", 10));
    }
}

