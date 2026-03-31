package FunctionalInterfaces;

// Vehicle interface
interface Vehicle{
	public void rent();
	public void returnVehicle();
}

// Car class
class Car implements Vehicle{
	@Override
	public void rent() {
		System.out.println("Car rent per day 2000");	
	}
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle is Car");
	}
	
}

// Bike class
class Bike implements Vehicle{
	@Override
	public void rent() {
		System.out.println("Bike rent per day 1000");
		
	}
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle is Bike");
	}
}

// Bus class
class Bus implements Vehicle{
	@Override
	public void rent() {
		System.out.println("Bus rent per day 20000");
		
	}
	@Override
	public void returnVehicle() {
		System.out.println("Vehicle is Bus");
	}
	
}

public class MultiVehicleRental {

	public static void main(String[] args) {
		Car car = new Car();
		Bike bike = new Bike();
		Bus bus = new Bus();
		car.rent();
		car.returnVehicle();
		bike.rent();
		bike.returnVehicle();
		bus.rent();
		bus.returnVehicle();

	}

}
