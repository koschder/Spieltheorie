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
		Game[] expandedStates = g.expand();
		assertEquals(leafNodes.length, expandedStates.length);
		for (int i = 0; i < expandedStates.length; i++) {
			assertEquals(leafNodes[i], expandedStates[i].utility());
		}
	}

	@Test
	public void testConstructor_ManyLeafNodes_ManyLevels() {
		long[] leafNodes = new long[] { 1, 2, 3, 5 };
		Game g = new SimpleTestGame(2, leafNodes);
		Game[] expandedStates = g.expand();
		assertEquals(2, expandedStates.length);
		for (int i = 0; i < expandedStates.length; i++) {
			assertEquals(2, expandedStates[i].expand());
		}
	}
}
