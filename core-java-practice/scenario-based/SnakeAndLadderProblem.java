public class SnakeAndLadderProblem {

	public static void main(String[] args) {

		// UC 1: Snake and Ladder game played with single player at start position 0
		int player1Position = 0;
		int player2Position = 0;

		int diceCount = 0;
		// Player 1 starts
		int currentPlayer = 1;

		// UC 4 & UC 5: Repeat till a player reaches exact winning position 100
		while (player1Position < 100 && player2Position < 100) {

			// UC 2: Player rolls the die from 1 to 6)
			int dice = (int) (Math.random() * 6) + 1;
			diceCount++;

			System.out.println("\nPlayer " + currentPlayer + " rolled: " + dice);

			// Check for Player1 and player 2 options
			int option = (int) (Math.random() * 3);
			if (currentPlayer == 1) {
				player1Position = movePlayer(player1Position, dice, option);
				System.out.println("Player 1 Position: " + player1Position);
			} else {
				player2Position = movePlayer(player2Position, dice, option);
				System.out.println("Player 2 Position: " + player2Position);
			}

			// UC 7: If player gets Ladder, they get another chance
			if (option != 1) {
				currentPlayer = (currentPlayer == 1) ? 2 : 1;
			}
		}

		// UC 6 : Report dice count and winner
		System.out.println("\nTotal dice rolls: " + diceCount);

		if (player1Position == 100) {
			System.out.println(" Player 1 WON the game!");
		} else {
			System.out.println(" Player 2 WON the game!");
		}
	}

	// Method to move player based on option
	public static int movePlayer(int position, int dice, int option) {
		// UC 3: Check for Option No Play, Ladder, Snake
		switch (option) {
			case 0:
				System.out.println(" No Play");
				break;

			case 1:
				System.out.println(" Ladder");
				position += dice;
				break;

			case 2:
				System.out.println(" Snake");
				position -= dice;
				break;
		}

		// UC 4: If position goes below 0, reset to 0
		if (position < 0) {
			position = 0;
		}

		// UC 5: Ensure exact winning position 100
		if (position > 100) {
			position -= dice;
		}

		return position;
	}
}
