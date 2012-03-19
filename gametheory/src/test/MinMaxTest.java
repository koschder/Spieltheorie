package test;

import static org.junit.Assert.assertEquals;
import impl.MinMax;

import org.junit.Test;

import definition.Game;

public class MinMaxTest {

	@Test
	public void testEval() {
		long[] leafNodes = new long[] { 10, 11, 9, 12, 14, 15, 13, 14, 5, 2, 4,
				1, 3, 22, 20, 21 };
		Game g = new SimpleTestGame(2, leafNodes);
		assertEquals(10, new MinMax().eval(g, 5));
	}
}
