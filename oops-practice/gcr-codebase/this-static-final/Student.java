public class Student {

  static String universityName = "Global University";
  String Name;
  final int rollNumber;
  String grade;
  static int totalStudent;

  Student(String Name, int rollNumber, String grade) {
    this.Name = Name;
    this.rollNumber = rollNumber;
    this.grade = grade;
    totalStudent++;
  }

  public void displayDetails() {
    if (this instanceof Student) {
      System.out.println("University Name: " + universityName);
      System.out.println("Roll Number: " + rollNumber);
      System.out.println("Name: " + Name);

      System.out.println("Grade: " + grade);
    } else {
      System.out.println("Invalid Student instance");
    }
  }

  static void displayTotalStudents() {
    System.out.println("Total Students Enrolled: " + totalStudent);
  }

  public static void main(String[] args) {
    Student s1 = new Student("Hemashree", 101, "A");
    Student s2 = new Student("Sharmila", 101, "B");
    displayTotalStudents();
    s1.displayDetails();
    s2.displayDetails();
  }
}
