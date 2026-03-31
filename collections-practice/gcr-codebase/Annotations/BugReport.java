package Annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Container Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Repeatable Annotation (PUBLIC → file name matches this)
@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BugReport {
    String description();
}

// Class using the annotation
class Software {

    @BugReport(description = "NullPointerException on login")
    @BugReport(description = "Application freezes after submit")
    void process() {
        System.out.println("Processing software task...");
    }
}

class BugReportDemo {
    public static void main(String[] args) throws Exception {

        Method method = Software.class.getDeclaredMethod("process");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}

