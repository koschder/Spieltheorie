package definition;

/** interface realized by a specific game */
public interface Game {

	boolean maxToMove();

	/** yields initial state */
	Game start();

	/** returns the move leading to this state */
	int getLastMove();

	/** do a move on current state */
	void doMove(int i);

	/** yields the set of possible moves */
	Game[] getPossibleMoves();

	/** yields the set of successor states */
	Game[] expand();

	/** determines whether there is a terminal state */
	boolean terminal();

	/**
	 * static evaluation function for an arbitrary state related to the
	 * MAX-player
	 */
	long evalValue();

	/**
	 * exact evaluation function for terminal state related to the MAX-player
	 */
	long utility();
}
