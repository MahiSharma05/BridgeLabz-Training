class Circle {
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate and display area and circumference
    void displayDetails() {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;

        System.out.printf("Area of circle: %.4f%n", area);
        System.out.printf("Circumference of circle: %.4f%n", circumference);
    }
}

public class CircleArea {
    public static void main(String[] args) {

        // Create Circle object
        Circle c = new Circle(2.5);

        // Display area and circumference
        c.displayDetails();
    }
}

