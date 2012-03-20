package impl;

import definition.Game;

public class MinMax extends AbstractAlgorithm {

	@Override
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
