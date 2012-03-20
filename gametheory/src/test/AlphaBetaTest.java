package test;

import static org.junit.Assert.assertEquals;
import impl.AlphaBeta;

import org.junit.Test;

import definition.Game;

public class AlphaBetaTest {

	@Test
	public void testEval() {
		long[] leafNodes = new long[] { 10, 11, 9, 12, 14, 15, 13, 14, 5, 2, 4,
				1, 3, 22, 20, 21 };
		Game g = new SimpleTestGame(2, leafNodes);
		assertEquals(10, new AlphaBeta().eval(g, 5));
	}

}
