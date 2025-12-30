public class SnakeAndLadderProblem {
	public static void main(String[] args) {
		final int WINNING_POSITION = 100;
		// UC 1: Snake and Ladder game played with single player
		int position = 0;
		System.out.println("Player starts at position: " + position);

		// UC 4:Repeat till the Player reaches the winning position 100
		while (position < WINNING_POSITION) {

			// UC 2: The Player rolls the die to get a number between 1 to 6.
			int dieRoll = (int) (Math.random() * 6) + 1;
			System.out.println("Die rolled: " + dieRoll);

			// UC 3: Player checks for option No Play,Ladder , Snake
			int option = (int) (Math.random() * 3);
			switch (option) {
				case 0:
					// No Play: player stays at same position
					System.out.println(" No Play");
					break;

				case 1:
					System.out.println(" Ladder");
					position = position + dieRoll;
					break;

				case 2:
					System.out.println(" Snake");
					position = position - dieRoll;
					break;
			}

			// If position goes below 0, reset to 0
			if (position < 0) {
				position = 0;
			}
			System.out.println("Player position after move: " + position);
		}

	}
}