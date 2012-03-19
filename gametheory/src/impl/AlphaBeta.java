package impl;

import definition.Algorithm;
import definition.Game;

public class AlphaBeta implements Algorithm {

	@Override
	public Game bestMove(Game g, int maxDepth) {
		Game[] succ = g.expand();
		long bestValue = -1;
		int bestState = 0;
		long eval;
		for (int i = 0; i < succ.length; i++) {
			eval = eval(succ[i], Long.MIN_VALUE, Long.MAX_VALUE, maxDepth);
			if (eval > bestValue) {
				bestValue = eval;
				bestState = i;
			}
		}
		return succ[bestState];

	}

	public long eval(Game g, long alpha, long beta, int maxDepth) {
		if (maxDepth == 0)
			return g.evalValue();
		if (g.terminal())
			return g.utility();

		Game[] succ = g.expand();
		if (g.maxToMove()) {
			for (int i = 0; i < succ.length; i++) {
				alpha = Math.max(alpha,
						eval(succ[i], alpha, beta, maxDepth - 1));
				if (alpha >= beta)
					return beta; // beta-cutoff
			}
		} else {
			for (int i = 0; i < succ.length; i++) {
				beta = Math.min(beta, eval(succ[i], alpha, beta, maxDepth - 1));
				if (alpha >= beta)
					return alpha; // alpha-cutoff
			}
		}
		return beta;
	}

}
