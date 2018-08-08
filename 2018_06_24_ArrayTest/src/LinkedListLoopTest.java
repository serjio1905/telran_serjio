import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import telran.util.LinkedList;

class LinkedListLoopTest {
	
	@Test
	void test() {
		LinkedList<Integer> array = new LinkedList<Integer>();
		array.add(32);
		array.add(5);
		array.add(352);
		array.add(54);
		array.add(96);
		array.add(532);
		array.add(-58);
		assertTrue(array.isLoopEnded());
		array.getNode(6).next = array.getNode(4);
		assertFalse(array.isLoopEnded());
		array.getNode(5).next = null;
		assertTrue(array.isLoopEnded());
	}
}
