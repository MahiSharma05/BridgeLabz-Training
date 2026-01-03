package inheritance;

// Superclass
class Book{
	String title;
	int publicationYear;	

//constructor
Book(String title , int publicationYear){
	this.title= title;
	this.publicationYear = publicationYear;
}
}

// Subclass
class Author extends Book{
	String name;
	String bio;	

//Constructor
Author(String title , int publicYear , String name , String bio){
	//Call to super class constructor
	super(title,publicYear);
	this.name = name;
	this.bio = bio;
}


void displayInfo() {
	System.out.println("Title :" + title);
	System.out.println("Publication Year :" + publicationYear);
	System.out.println("Name :" + name);
	System.out.println("Bio :" + bio);
	
}
}

public class LibraryManagement {

	public static void main(String[] args) {

		Author a = new Author("java" , 2026 ,"joshua Bloch" ,"Expert in Java programming and API design");
		a.displayInfo();
	}

}
