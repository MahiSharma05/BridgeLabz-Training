//Write a Program to compute the volume of Earth in km^3 and miles^3

class EarthVolume{
    public static void main(String[] args){
        double radiusInKm = 6378;
        double pi = 3.14;
        double volumeInKm = (4/3)* pi* radiusInKm *radiusInKm* radiusInKm;
                 // Convert km³ to miles³
        double radiusInMiles = radiusInKm * 0.621;
        double volumeInMiles = (4/3)* pi *radiusInMiles* radiusInMiles* radiusInMiles;
        System.out.println("The volume of earth in cubic kilometers is " + volumeInKm +" and cubic miles is " + volumeInMiles);
    }
}
