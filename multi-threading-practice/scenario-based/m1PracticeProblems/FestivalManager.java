package practice;

import java.util.*;

/* Base Class */
class Festival {

    String name;
    String location;
    String date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
    }
}

/* Music Festival */
class MusicFestival extends Festival {

    String headliner;
    String musicGenre;
    int ticketPrice;

    MusicFestival(String name, String location, String date,
                  String headliner, String musicGenre, int ticketPrice) {

        super(name, location, date);
        this.headliner = headliner;
        this.musicGenre = musicGenre;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + musicGenre);
        System.out.println("Ticket Price: " + ticketPrice);
    }
}

/* Food Festival */
class FoodFestival extends Festival {

    String cuisine;
    int numStalls;
    int entryFee;

    FoodFestival(String name, String location, String date,
                 String cuisine, int numStalls, int entryFee) {

        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + numStalls);
        System.out.println("Entry Fee: " + entryFee);
    }
}

/* Art Festival */
class ArtFestival extends Festival {

    String artType;
    int numArtists;
    int exhibitionFee;

    ArtFestival(String name, String location, String date,
                String artType, int numArtists, int exhibitionFee) {

        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + numArtists);
        System.out.println("Exhibition Fee: " + exhibitionFee);
    }
}

/* Main Class */
public class FestivalManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Festival> festivalMap = new HashMap<>();

        while (true) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("EXIT")) {
                break;
            }

            if (parts[0].equals("ADD_FESTIVAL")) {

                String type = parts[1];

                if (type.equals("MUSIC")) {

                    Festival f = new MusicFestival(
                            parts[2], parts[3], parts[4],
                            parts[5], parts[6], Integer.parseInt(parts[7])
                    );

                    festivalMap.put(parts[2], f);
                }

                else if (type.equals("FOOD")) {

                    Festival f = new FoodFestival(
                            parts[2], parts[3], parts[4],
                            parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7])
                    );

                    festivalMap.put(parts[2], f);
                }

                else if (type.equals("ART")) {

                    Festival f = new ArtFestival(
                            parts[2], parts[3], parts[4],
                            parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7])
                    );

                    festivalMap.put(parts[2], f);
                }
            }

            else if (parts[0].equals("DISPLAY_DETAILS")) {

                String name = parts[1];

                if (festivalMap.containsKey(name)) {
                    festivalMap.get(name).displayDetails();
                }
            }
        }

        sc.close();
    }
}
