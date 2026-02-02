package CSVDataHandling;

public class Student {

    int id;
    String name;
    int age;
    int marks;

    // Constructor
    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Display method
    public void display() {
        System.out.println(id + "\t" + name + "\t" + age + "\t" + marks);
    }
}
