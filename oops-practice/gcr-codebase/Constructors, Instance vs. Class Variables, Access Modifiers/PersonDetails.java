class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class PersonDetails {
    public static void main(String[] args) {

        // Original person
        Person person1 = new Person("Rohan", 25);

        // Clone using copy constructor
        Person person2 = new Person(person1);

        System.out.println("Original Person Details:");
        person1.displayDetails();

        System.out.println("Cloned Person Details:");
        person2.displayDetails();
    }
}

