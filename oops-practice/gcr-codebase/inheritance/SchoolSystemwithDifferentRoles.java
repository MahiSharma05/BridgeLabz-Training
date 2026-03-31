package inheritance;

//Superclass
class Person {

 String name;
 int age;

 Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 void displayPersonDetails() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }
}

//Subclass 1
class Teacher extends Person {

 String subject;

 Teacher(String name, int age, String subject) {
     super(name, age);
     this.subject = subject;
 }

 void displayRole() {
     displayPersonDetails();
     System.out.println("Role: Teacher");
     System.out.println("Subject: " + subject);
 }
}

//Subclass 2
class Student extends Person {

 String grade;

 Student(String name, int age, String grade) {
     super(name, age);
     this.grade = grade;
 }

 void displayRole() {
     displayPersonDetails();
     System.out.println("Role: Student");
     System.out.println("Grade: " + grade);
 }
}

//Subclass 3
class Staff extends Person {

 String department;

 Staff(String name, int age, String department) {
     super(name, age);
     this.department = department;
 }

 void displayRole() {
     displayPersonDetails();
     System.out.println("Role: Staff");
     System.out.println("Department: " + department);
 }
}

//Main class
public class SchoolSystemwithDifferentRoles {

 public static void main(String[] args) {

     Teacher teacher = new Teacher("Anita Sharma", 35, "Mathematics");
     Student student = new Student("Rahul Verma", 16, "10th Grade");
     Staff staff = new Staff("Suresh Kumar", 45, "Administration");

     teacher.displayRole();
     System.out.println();

     student.displayRole();
     System.out.println();

     staff.displayRole();
 }
}

