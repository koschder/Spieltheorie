package impl;

import definition.Algorithm;
import definition.Game;

public class MinMax implements Algorithm {

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

	public long eval(Game g, int maxDepth) {
		if (maxDepth == 0)
			return g.evalValue();
		if (g.terminal())
			return g.utility();

		Game[] succ = g.expand();
		long eval = Long.MIN_VALUE;
		if (g.maxToMove()) {
			for (int i = 0; i < succ.length; i++)
				eval = Math.max(eval, eval(succ[i], maxDepth - 1));
		} else {
			eval = Long.MAX_VALUE;
			for (int i = 0; i < succ.length; i++)
				eval = Math.min(eval, eval(succ[i], maxDepth - 1));
		}
		return eval;
	}

}
