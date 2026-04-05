package practice2;
import java.util.*;

class Booking {
    String passengerId;
    int seatCount;
    double bookingFare;

    Booking(String passengerId, int seatCount, double bookingFare) {
        this.passengerId = passengerId;
        this.seatCount = seatCount;
        this.bookingFare = bookingFare;
    }
}

class Train {
    String trainId;
    String source;
    String destination;
    int totalSeats;
    double baseFare;
    int availableSeats;

    List<Booking> bookings = new ArrayList<>();

    Train(String trainId, String source, String destination, int totalSeats, double baseFare) {
        this.trainId = trainId;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.baseFare = baseFare;
        this.availableSeats = totalSeats;
    }
}

class RailwayManager {
    List<Train> trains = new ArrayList<>();

    public int addTrain(String trainId, String source, String destination, int totalSeats, double baseFare) {
        for (Train t : trains) {
            if (t.trainId.equals(trainId)) {
                return -1;
            }
        }
        trains.add(new Train(trainId, source, destination, totalSeats, baseFare));
        return 1;
    }

    public void bookSeats(String trainId, String passengerId, int seatCount) {
        Train t = findTrain(trainId);

        if (t == null || t.availableSeats < seatCount) {
            System.out.println("Booking failed");
            return;
        }

        double bookingFare = (seatCount * t.baseFare) + (seatCount * 25);

        t.availableSeats -= seatCount;
        t.bookings.add(new Booking(passengerId, seatCount, bookingFare));

        System.out.println("BOOKED " + trainId + " " + passengerId + " " + (int) bookingFare);
    }

    public void cancelBooking(String trainId, String passengerId) {
        Train train = findTrain(trainId);

        if (train == null) {
            System.out.println("Cancellation failed");
            return;
        }

        for (int i = 0; i < train.bookings.size(); i++) {
            Booking b = train.bookings.get(i);

            if (b.passengerId.equals(passengerId)) {

                train.availableSeats += b.seatCount;
                train.bookings.remove(i);

                System.out.println("CANCELLED " + trainId + " " + passengerId);
                return;
            }
        }

        System.out.println("Cancellation failed");
    }

    public void findRoute(String source, String destination) {
        boolean found = false;

        for (Train t : trains) {
            if (t.source.equals(source) && t.destination.equals(destination)) {
                System.out.println(t.trainId + " " + t.availableSeats);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No trains available");
        }
    }

    public void getRevenueSummary() {
        boolean hasRevenue = false;

        for (Train t : trains) {
            double totalRevenue = 0;

            for (Booking b : t.bookings) {
                totalRevenue += b.bookingFare;
            }

            if (totalRevenue > 0) {
                hasRevenue = true;
            }

            System.out.println(t.trainId + " " + (int) totalRevenue);
        }

        if (!hasRevenue) {
            System.out.println("No revenue generated");
        }
    }

    public Train findTrain(String trainId) {
        for (Train t : trains) {
            if (t.trainId.equals(trainId)) {
                return t;
            }
        }
        return null;
    }
}

public class RailwayDynamicAllocationSystem {
    public static void main(String[] args) {
    	System.out.println("input");
        Scanner sc = new Scanner(System.in);
        RailwayManager rm = new RailwayManager();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] part = input.split(" ");
            String command = part[0];

            switch (command) {
                case "ADDTRAIN":
                    rm.addTrain(part[1], part[2], part[3],
                            Integer.parseInt(part[4]),
                            Double.parseDouble(part[5]));
                    break;

                case "BOOK":
                    rm.bookSeats(part[1], part[2], Integer.parseInt(part[3]));
                    break;

                case "CANCEL":
                    rm.cancelBooking(part[1], part[2]);
                    break;

                case "ROUTE":
                    rm.findRoute(part[1], part[2]);
                    break;

                case "SUMMARY":
                    rm.getRevenueSummary();
                    break;
            }
        }
        sc.close();
    }
}