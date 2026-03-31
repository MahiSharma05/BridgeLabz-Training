//Create a program to convert the distance of 10.8 kilometers to miles.

public class KmToMilesConverter {
	public static void main(String[] args) {
		double distanceInkm = 10.8;
		double distanceInMiles = distanceInkm / 1.6;
		System.out.println("The distance " + distanceInkm + "km in miles is " + distanceInMiles);
	}
}