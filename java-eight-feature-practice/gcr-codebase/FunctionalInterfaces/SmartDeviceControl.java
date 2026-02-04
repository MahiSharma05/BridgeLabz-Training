package FunctionalInterfaces;

// Device interface
interface Device{
	public void turnOn();
	public void turnOff();
}

// Light class
class Light implements Device{
	@Override
	public void turnOn() {
		System.out.println("Light Glow.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("Light Off");
	}
	
}

// AC class
class AC implements Device{
	@Override
	public void turnOn() {
		System.out.println("AC start cooling.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("AC stop cooling");
	}
}

// TV class
class TV implements Device{
	@Override
	public void turnOn() {
		System.out.println("TV display on");
		
	}
	@Override
	public void turnOff() {
		System.out.println("TV display off");
	}
	
}
public class SmartDeviceControl {

	public static void main(String[] args) {
		Light light = new Light();
		light.turnOn();
		light.turnOff();
		AC ac = new AC();
		ac.turnOn();
		ac.turnOff();
		TV tv = new TV();
		tv.turnOn();
		tv.turnOff();

	}

}
