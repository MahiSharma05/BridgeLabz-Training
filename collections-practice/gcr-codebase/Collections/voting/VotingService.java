package voting;
import java.util.*;

public class VotingService {

    // Candidate -> Votes
    private Map<String, Integer> voteCount = new HashMap<>();

    // Order of votes cast
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    // Cast a vote
    public void castVote(String candidate) {

        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);

        voteOrder.put(candidate,
                voteOrder.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in insertion order
    public void displayVoteOrder() {
        System.out.println("\nVote Order (LinkedHashMap):");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display results sorted by candidate name
    public void displaySortedResults() {
        TreeMap<String, Integer> sortedResults =
                new TreeMap<>(voteCount);

        System.out.println("\nSorted Results (TreeMap):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display winner
    public void displayWinner() {
        String winner = null;
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }
}

