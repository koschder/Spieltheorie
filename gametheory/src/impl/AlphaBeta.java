package impl;

import definition.Game;

public class AlphaBeta extends AbstractAlgorithm {

	long alpha = Long.MIN_VALUE;
	long beta = Long.MAX_VALUE;

	public long eval(Game g, int maxDepth) {
		if (maxDepth == 0)
			return g.evalValue();
		if (g.terminal())
			return g.utility();

		Game[] succ = g.expand();
		if (g.maxToMove()) {
			for (int i = 0; i < succ.length; i++) {
				alpha = Math.max(alpha, eval(succ[i], maxDepth - 1));
				if (alpha >= beta)
					return beta; // beta-cutoff
			}
		} else {
			for (int i = 0; i < succ.length; i++) {
				beta = Math.min(beta, eval(succ[i], maxDepth - 1));
				if (alpha >= beta)
					return alpha; // alpha-cutoff
			}
		}
		return beta;
	}

}
