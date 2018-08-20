package telran.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Tree;


class SetTest {

	Tree<Integer> set;
	Integer[] expOriginal = {100, 80, 40, 30, 20, 50, 82, 90, 85, 95};
			
	@BeforeEach
	void setUp() throws Exception{
		set = new Tree<Integer>();
		createTree(set, expOriginal);
	}
	
	private void createTree(Set<Integer> tree, Integer[] array) {
		for(int i = 0; i < array.length; i++) {
			tree.add((Integer)array[i]);
		}
	}
	
	@Test
	void testIterator() {
		testSetArray(set, expOriginal);
	}
	
	private void testSetArray(Set<Integer> set, Integer[] expected) {
		Integer[] actual = new Integer[expected.length];
		int ind = 0;
		if(actual.length == 0 && expected.length == 0) return;
		for(int number: set) {
			actual[ind++] = number;
		}
		Arrays.sort(expected);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
	}
	
	void testSizeRecursion() {
		assertEquals(expOriginal.length, set.getSizeRecursion());
	}
	
	@Test
	void width() {
		assertEquals(4, set.width());
	}

	@Test
	void height() {
		assertEquals(4, set.height());
	}
}
