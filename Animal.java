package review;

interface Animal{
	void sound();

public class Dog implements Animal{
	
	@Override
	public void sound() {
		System.out.println("Animal");
	}

	// overloading
	public void type(String pet) {
		System.out.println("Pet Animal");
	}
	
	public void type(String pet , String sound) {
		System.out.println("wild animal");
	}
}

public static void main(String[] args) {
	Dog a = new Dog();
	Dog d = new Dog();
	a.sound();
	d.type("petAnimal");
	d.type("wild Animal" , " barking");
}
}

