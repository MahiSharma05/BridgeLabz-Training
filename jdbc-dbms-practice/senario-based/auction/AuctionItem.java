package auction;

import java.util.*;

public class AuctionItem {

    private String itemName;
    private TreeMap<User, Double> bids = new TreeMap<>();

    public AuctionItem(String itemName) {
        this.itemName = itemName;
    }

    public void placeBid(Bid bid) throws InvalidBidException {

        double highestBid = getHighestBidAmount();

        if (bid.getAmount() <= highestBid) {
            throw new InvalidBidException(
                    "Bid must be higher than current highest bid: " + highestBid);
        }

        bids.put(bid.getUser(), bid.getAmount());

        System.out.println(bid.getUser() + " placed bid of ₹" + bid.getAmount());
    }

    public double getHighestBidAmount() {

        double max = 0;

        for (double amount : bids.values()) {
            if (amount > max) {
                max = amount;
            }
        }

        return max;
    }

    public void showHighestBid() {

        User highestBidder = null;
        double highest = 0;

        for (Map.Entry<User, Double> entry : bids.entrySet()) {
            if (entry.getValue() > highest) {
                highest = entry.getValue();
                highestBidder = entry.getKey();
            }
        }

        if (highestBidder != null) {
            System.out.println("Highest Bid: ₹" + highest +
                    " by " + highestBidder);
        } else {
            System.out.println("No bids yet.");
        }
    }
}
