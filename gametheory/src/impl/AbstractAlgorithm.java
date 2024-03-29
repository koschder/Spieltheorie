package impl;

import definition.Algorithm;
import definition.Game;

public abstract class AbstractAlgorithm implements Algorithm {

	@Override
	public Game bestMove(Game g, int maxDepth) {
		Game[] succ = g.expand();
		long bestValue = -1;
		int bestState = 0;
		long eval;
		for (int i = 0; i < succ.length; i++) {
			eval = eval(succ[i], maxDepth);
			if (eval > bestValue) {
				bestValue = eval;
				bestState = i;
			}
		}
		return succ[bestState];

	}

}
