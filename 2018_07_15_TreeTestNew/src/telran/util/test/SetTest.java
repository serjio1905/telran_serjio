package telran.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Tree;
import telran.util.HashTable;

class SetTest {

	Tree<Integer> tree;
	Set<Integer> set;
	Collection<Integer> collection;
	Integer[] expAdd = {100, 80, 40, 30, 20, 50, 82, 90, 85, 95, 1000};
	Integer[] expOriginal = {100, 80, 40, 30, 20, 50, 82, 90, 85, 95};
	Integer[] expNo100 = {80, 40, 30, 20, 50, 82, 90, 85, 95};
	Integer[] expNo80 = {100, 40, 30, 20, 50, 82, 90, 85, 95};
	Integer[] expNo30 = {100, 80, 40, 20, 50, 82, 90, 85, 95};
	Integer[] expNo82 = {100, 80, 40, 30, 20, 50, 90, 85, 95};
	Integer[] expNo20 = {100, 80, 40, 30, 50, 82, 90, 85, 95};
	Integer[] expNo95 = {100, 80, 40, 30, 20, 50, 82, 90, 85};
	Integer[] addToCollection = {400, 700, 5, 90};
	Integer[] expAddAllCollection = {100, 80, 40, 30, 20, 50, 82, 90, 85, 95, 5, 400, 700};
	Integer[] expRetainAll = {50, 20, 85, 100};
	Integer[] expRemoveAll = {80, 40, 30, 82, 90, 95};
			
	@BeforeEach
	void setUp() throws Exception{
		set = new HashTable<Integer>();
		collection = new Tree<Integer>();
		createTree(set, expOriginal);
	}
	
	private void createTree(Set<Integer> tree, Integer[] array) {
		for(int i = 0; i < array.length; i++) {
			tree.add((Integer)array[i]);
		}
	}
	
	@Test
	void contains() {
		assertTrue(set.contains(100));
		assertTrue(set.contains(20));
		assertTrue(set.contains(95));
		assertFalse(set.contains(1000));
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
	
	@Test
	void testAdd() {
		assertFalse(set.add(40));
		assertTrue(set.add(1000));
		testSetArray(set, expAdd);
	}
	
	@Test
	void remove100() {
		set.remove(100);
		testSetArray(set, expNo100);
	}
	
	@Test
	void remove80() {
		set.remove(80);
		testSetArray(set, expNo80);
	}
	
	@Test
	void remove30() {
		set.remove(30);
		testSetArray(set, expNo30);
	}
	
	@Test
	void remove82() {
		System.out.println(Arrays.toString(set.toArray()));
		set.remove(82);
		System.out.println(Arrays.toString(set.toArray()));
		testSetArray(set, expNo82);
	}
	
	@Test
	void remove20() {
		set.remove(20);
		testSetArray(set, expNo20);
	}
	
	@Test
	void remove95() {
		set.remove(95);
		testSetArray(set, expNo95);
	}
	
	@Test
	void containsAll() {
		collection.add(20);
		collection.add(80);
		collection.add(85);
		assertTrue(set.containsAll(collection));
		collection.add(333);
		assertFalse(set.containsAll(collection));
	}
	
	@Test 
	void addAll() {
		for (Integer x: addToCollection) {
			collection.add(x);
		}
		set.addAll(collection);
		testSetArray(set, expAddAllCollection);
	}

	@Test
	void retainAll() {
		for (Integer x: expRetainAll) {
			collection.add(x);
		}
		set.retainAll(collection);
		testSetArray(set, expRetainAll);
	}
	
	@Test
	void removeAll() {
		for (Integer x: expRetainAll) {
			collection.add(x);
		}
		set.removeAll(collection);
		testSetArray(set, expRemoveAll);
	}
	
	@Test
	void claer() {
		set.clear();
		testSetArray(set, new Integer[0]);
	}
}
