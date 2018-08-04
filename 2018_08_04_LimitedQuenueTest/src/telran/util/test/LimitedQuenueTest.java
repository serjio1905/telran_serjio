package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import telran.util.LimitedQueue;

class LimitedQuenueTest {
	LimitedQueue lQ = new LimitedQueue(5);
	
	@Test
	void testAdd() {
		assertTrue(lQ.add(1));
		assertTrue(lQ.add(2));
		assertTrue(lQ.add(3));
		assertTrue(lQ.add(4));
		assertTrue(lQ.add(5));
		assertFalse(lQ.add(1592));
		assertFalse(lQ.add(43534));
		assertEquals(1, (int)lQ.offer());
		assertEquals(2, (int)lQ.offer());
		assertEquals(3, (int)lQ.offer());
		assertEquals(4, (int)lQ.offer());
		assertEquals(5, (int)lQ.offer());
		assertEquals(null, lQ.offer());
		assertTrue(lQ.add(6));
		assertTrue(lQ.add(7));
		assertTrue(lQ.add(8));
		assertTrue(lQ.add(9));
		assertTrue(lQ.add(10));
		assertEquals(6, (int)lQ.offer());
		assertEquals(7, (int)lQ.offer());
		assertEquals(8, (int)lQ.offer());
		assertTrue(lQ.add(11));
		assertTrue(lQ.add(12));
		assertEquals(9, (int)lQ.offer());
	}
	
}
