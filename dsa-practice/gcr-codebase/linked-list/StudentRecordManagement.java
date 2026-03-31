package linkedList;
import java.util.Scanner;

class StudentNode{
	int rollNo;
	String name;
	int age;
	char grade;
	StudentNode next;
	
	StudentNode(int rollNo, String name, int age , char grade){
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}

class StudentLinkedList{
	private StudentNode head;
	
	// Add at the beginning
	public void addAtBeginning(int rollNo, String name, int age, char grade) {
		StudentNode newNode = new StudentNode(rollNo, name, age, grade);
		newNode.next = head;
		head = newNode;
		System.out.println("Student add at beginning");
	}
	
	// Add at end
	public void addAtEnd(int rollNo, String name, int age, char grade) {
		StudentNode newNode = new StudentNode(rollNo, name, age, grade);
		
		if(head == null) {
			head = newNode;
			return;
		}
		StudentNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		System.out.println("Student add at end");
	}
	
	// add at specific position
	public void addAtPosition(int position, int rollNo, String name, int age,char grade) {
		if(position <= 0) {
			System.out.println("Invalid position");
			return;
		}
		if(position == 1) {
			addAtBeginning(rollNo,name,age,grade);
			return;
		}
		StudentNode newNode = new StudentNode(rollNo,name,age,grade);
		StudentNode temp = head;
		for(int i = 1; i < position - 1 && temp != null; i++) {
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("Position out of range");
			return;
		}
		newNode.next = temp.next;
		temp.next = newNode.next;
		System.out.println("Student add at specific position" + position);
	}
	
	// Delete by roll number
	public void deleteByRollNo(int rollNo) {
		if(head == null) {
			System.out.println("List is empty");
		}
		if(head.rollNo == rollNo) {
			head = head.next;
			System.out.println("Student deleted");
			return;
		}
		StudentNode temp = head;
		while(temp.next != null && temp.next.rollNo != rollNo) {
			temp = temp.next;
		}
		if(temp.next == null) {
			System.out.println("Student not fount");
		}
		else {
			temp.next = temp.next.next;
			System.out.println("Student deleted");
		}
	}
	// search by rollno
	public void searchStudent(int rollNo) {
		StudentNode temp = head;
		while(temp != null) {
			if(temp.rollNo == rollNo) {
				System.out.println("Student found");
				System.out.println("Roll No: " + temp.rollNo);
				System.out.println("Name: " + temp.name);
				System.out.println("Age: " + temp.age);
				System.out.println("Grade: " + temp.grade);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found!");
	}
	
	// updateGrade
	public void updateGrade(int rollNo, char newGrade) {
		StudentNode temp = head;
		
		while(temp != null) {
			if(temp.rollNo == rollNo) {
				temp.grade = newGrade;
				System.out.println("Grade updated");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found");
	}
	
	// Display Studends
	
	public void displayStudents() {
		if(head == null) {
			System.out.println("No Record Found");
			return;
		}
		StudentNode temp = head;
		while(temp != null) {
			System.out.println("Roll No: " + temp.rollNo);
			System.out.println("Name: " + temp.name);
			System.out.println("Age: " + temp.age);
			System.out.println("Grade: " + temp.grade);
			temp = temp.next;
		}
		System.out.println(".......................");
	}
}

public class StudentRecordManagement {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        while (true) {
            System.out.println("\n Student Record Management");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            
            int choice = input.nextInt();

            switch(choice) {
            case 1:
            case 2:
            case 3:
            	System.out.print("Roll No: ");
                int roll = input.nextInt();
                input.nextLine();
                System.out.print("Name: ");
                String name = input.nextLine();
                System.out.print("Age: ");
                int age = input.nextInt();
                System.out.print("Grade: ");
                char grade = input.next().charAt(0);

                if (choice == 1)
                    list.addAtBeginning(roll, name, age, grade);
                else if (choice == 2)
                    list.addAtEnd(roll, name, age, grade);
                else {
                    System.out.print("Position: ");
                    int pos = input.nextInt();
                    list.addAtPosition(pos, roll, name, age, grade);
                }
                break;
            case 4:
            	System.out.print("Enter Roll No to delete: ");
                list.deleteByRollNo(input.nextInt());
                break;

            case 5:
                System.out.print("Enter Roll No to search: ");
                list.searchStudent(input.nextInt());
                break;

            case 6:
                System.out.print("Enter Roll No: ");
                int r = input.nextInt();
                System.out.print("Enter new Grade: ");
                char g = input.next().charAt(0);
                list.updateGrade(r, g);
                break;

            case 7:
                list.displayStudents();
                break;
            case 8:
                System.out.println("Exiting...");
                input.close();
                return;
            default:
                System.out.println("Invalid choice!");
            }	
	}
    
    
    }
}
