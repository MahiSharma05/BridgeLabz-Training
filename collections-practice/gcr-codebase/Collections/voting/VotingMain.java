package voting;

public class VotingMain {

    public static void main(String[] args) {

        VotingService votingService = new VotingService();

        // Cast votes
        votingService.castVote("Alice");
        votingService.castVote("Bob");
        votingService.castVote("Alice");
        votingService.castVote("Charlie");
        votingService.castVote("Bob");
        votingService.castVote("Alice");

        // Display vote order
        votingService.displayVoteOrder();

        // Display sorted results
        votingService.displaySortedResults();

        // Display winner
        votingService.displayWinner();
    }
}

