package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingProxy {

    public static void main(String[] args) {

        // Real object
        Greeting realGreeting = new GreetingImpl();

        // Create proxy
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(realGreeting)
        );

        // Method call (intercepted)
        proxyGreeting.sayHello("Mahi");
    }
}

// INTERFACE

interface Greeting {
    void sayHello(String name);
}

/* ================= IMPLEMENTATION ================= */

class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// INVOCATION HANDLER 

class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // Logging before method execution
        System.out.println("[LOG] Method called: " + method.getName());

        // Call actual method
        return method.invoke(target, args);
    }
}
