package auction;

public class Main {

    public static void main(String[] args) {

        AuctionItem item = new AuctionItem("iPhone 15");

        User u1 = new User(101, "Rahul");
        User u2 = new User(102, "Priya");
        User u3 = new User(103, "Aman");

        try {

            item.placeBid(new Bid(u1, 50000));
            item.placeBid(new Bid(u2, 55000));
            item.placeBid(new Bid(u3, 53000));  // Invalid

        } catch (InvalidBidException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println();
        item.showHighestBid();
    }
}
