package test;

import definition.Game;

public class SimpleTestGame implements Game {

	public SimpleTestGame(int branchingFactor, long... leafNodes) {
		if (branchingFactor <= 0)
			throw new IllegalArgumentException(
					"branchingFactor must be a positive integer");
		if ((leafNodes.length % branchingFactor) != 0)
			throw new IllegalArgumentException(
					"number of leaf nodes must be a multiple of the branching factor");

		if (leafNodes.length == 1) {
			utility = leafNodes[0];

		} else if ((leafNodes.length / branchingFactor) == 1) {
			successors = new Game[leafNodes.length];
			for (int i = 0; i < leafNodes.length; i++) {
				successors[i] = new SimpleTestGame(1, leafNodes[i]);
			}
		} else {
			int nodesPerBranch = leafNodes.length / branchingFactor;
			successors = new Game[branchingFactor];
			for (int i = 0; i < branchingFactor; i++) {
				successors[i] = new SimpleTestGame(branchingFactor, subArray(
						leafNodes, i * nodesPerBranch, i * nodesPerBranch
								+ nodesPerBranch));
			}
		}

	}

	private long[] subArray(long[] array, int startPos, int lastPos) {
		long[] subArray = new long[lastPos - startPos];
		for (int i = 0; i < subArray.length; i++) {
			subArray[i] = array[i + startPos];
		}
		return subArray;
	}

	private Game[] successors;
	private long utility;

	@Override
	public boolean maxToMove() {
		if (terminal())
			return true;
		return !expand()[0].maxToMove();
	}

	@Override
	public Game start() {
		return expand()[0];
	}

	@Override
	public int getLastMove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void doMove(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public Game[] getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game[] expand() {
		return successors;
	}

	@Override
	public boolean terminal() {
		return expand() == null;
	}

	@Override
	public long evalValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long utility() {
		if (terminal())
			return utility;
		return 0;
	}

	@Override
	public String toString() {
		return String.valueOf(utility());
	}
}
