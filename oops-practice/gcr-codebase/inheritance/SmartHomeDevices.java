package inheritance;

// superclass
class Device{
	int deviceId;
	String status;
	
Device(int deviceId , String status){
	this.deviceId = deviceId;
	this.status = status;
}	
}

// Subclass
class Thermostat extends Device{
	String temperatureSetting;
	
Thermostat(int deviceId , String status , String temperatureSetting){
	super(deviceId , status);
	this.temperatureSetting = temperatureSetting;	
}

void displayStatus() {
	System.out.println("Device Id :" + deviceId);
	System.out.println("Status :" + status);
	System.out.println("Temperature Setting :" + temperatureSetting);
}
}

public class SmartHomeDevices {

	public static void main(String[] args) {
		Thermostat t = new Thermostat( 2445 , "on" , "High");
		t.displayStatus();

	}

}
