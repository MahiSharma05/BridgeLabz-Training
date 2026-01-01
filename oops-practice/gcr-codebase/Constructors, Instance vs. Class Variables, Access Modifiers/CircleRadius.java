class Circle {
    double radius;

    // Default constructor
    Circle() {
        this(1.0);   // constructor chaining
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to display radius
    void displayRadius() {
        System.out.println("Radius: " + radius);
    }
}

public class CircleRadius {
    public static void main(String[] args) {

        // Using default constructor
        Circle c1 = new Circle();
        c1.displayRadius();

        // Using parameterized constructor
        Circle c2 = new Circle(2.5);
        c2.displayRadius();
    }
}
