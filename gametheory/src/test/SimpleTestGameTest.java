package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import definition.Game;

public class SimpleTestGameTest {
	@Test
	public void testConstructor_1LeafNode() {
		Game g = new SimpleTestGame(1, 1);
		assertNull(g.expand());
		assertEquals(1, g.utility());
	}

	@Test
	public void testConstructor_ManyLeafNodes() {
		long[] leafNodes = new long[] { 1, 2, 3, 5, 8 };
		Game g = new SimpleTestGame(5, leafNodes);
		checkLeafNodes(g, leafNodes);
	}

	@Test
	public void testConstructor_4LeafNodes_2Levels() {
		long[] leafNodes = new long[] { 1, 2, 3, 5 };
		Game g = new SimpleTestGame(2, leafNodes);
		Game[] expandedStates = g.expand();
		assertEquals(2, expandedStates.length);
		checkLeafNodes(expandedStates[0], new long[] { 1, 2 });
		checkLeafNodes(expandedStates[1], new long[] { 3, 5 });
	}

	@Test
	public void testConstructor_8LeafNodes_3Levels() {
		long[] leafNodes = new long[] { 1, 2, 3, 5, 8, 13, 21, 34 };
		Game g = new SimpleTestGame(2, leafNodes);
		Game[] expandedStates = g.expand();
		assertEquals(2, expandedStates.length);
		checkLeafNodes(expandedStates[0].expand()[0], new long[] { 1, 2 });
		checkLeafNodes(expandedStates[0].expand()[1], new long[] { 3, 5 });
		checkLeafNodes(expandedStates[1].expand()[0], new long[] { 8, 13 });
		checkLeafNodes(expandedStates[1].expand()[1], new long[] { 21, 34 });
	}

	private void checkLeafNodes(Game g, long[] expectedNodes) {
		Game[] expandedStates = g.expand();
		assertEquals(expectedNodes.length, expandedStates.length);
		for (int i = 0; i < expandedStates.length; i++) {
			assertEquals(expectedNodes[i], expandedStates[i].utility());
		}
	}
}
