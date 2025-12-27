// Write a program to create a deck of cards, initialize the deck, shuffle the deck, and distribute the deck of n cards to x number of players. Finally, print the cards the players have.

import java.util.Scanner;

public class DeckOfCards {

    // Method to initialize the deck
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        return deck;
    }
	
    // Method to shuffle the deck
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // Swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Method to distribute cards to players
    public static String[][] distributeCards(String[] deck, int nCards, int players) {
        if (nCards % players != 0) {
            System.out.println("Cards cannot be distributed equally!");
            return null;
        }
        int cardsPerPlayer = nCards / players;
        String[][] playerCards = new String[players][cardsPerPlayer];

        int cardIndex = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        return playerCards;
    }

    // Method to print players and their cards
    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Suits and Ranks
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Initialize deck
        String[] deck = initializeDeck(suits, ranks);

        // Shuffle deck
        deck = shuffleDeck(deck);

        // input
        System.out.print("Enter number of cards to distribute: ");
        int nCards = input.nextInt();

        System.out.print("Enter number of players: ");
        int players = input.nextInt();

        // Distribute cards
        String[][] playerCards = distributeCards(deck, nCards, players);

        //result
        if (playerCards != null) {
            printPlayers(playerCards);
        }
        input.close();
    }
}
