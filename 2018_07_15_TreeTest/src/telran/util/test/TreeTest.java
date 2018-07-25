package telran.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.Tree;

public class TreeTest {
	Tree<Integer> tree;
	Set<Integer> set;
	Integer[] expAdd = {100, 800, 40, 82, 30, 50, 90, 20, 82, 95, 1000};
	Integer[] expOriginal = {100, 800, 40, 82, 30, 50, 90, 20, 82, 95, 85};
	
	@BeforeEach
	void setUp() throws Exception{
		set = new Tree<>();
		createTree(tree, expOriginal);
	}
	
	private void createTree(Tree<Integer> tree, Integer[] array) {
		for(Integer number: array) {
			tree.add(number);
		}
	}
	
	@Test
	void contains() {
		assertTrue(set.contains(100));
		assertTrue(set.contains(20));
		assertTrue(set.contains(95));
		assertTrue(set.contains(1000));
	}
	
	@Test
	void testIterator() {
		testSetArray(set, expOriginal);
	}
	
	private void testSetArray(Set<Integer> set, Integer[] expected) {
		Integer[] actual = new Integer[expected.length];
		int ind = 0;
		for(int number:set) {
			actual[ind++] = number;
		}
		Arrays.sort(expected);
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
		
	}
	
	@Test
	void testAdd() {
		assertFalse(set.add(40));
		assertTrue(set.add(100));
		testSetArray(set, expAdd);
	}
}
