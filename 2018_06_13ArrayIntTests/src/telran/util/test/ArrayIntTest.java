package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import telran.utill.ArrayInt;

class ArrayIntTest {
	private final int TESTS_COUNT = 1000;
	private final int ARR_SIZE = 1000;
	private int [] arr = new int [ARR_SIZE];
	private ArrayInt array;
	
	@Test
	public void isOneSwap() {
		int sInd, fInd;
		for (int i = 0; i < TESTS_COUNT; i++) {
			array = new ArrayInt();
			fillArray(arr, array);
			
			fInd = (int) (Math.random() * ARR_SIZE);
			do {
				sInd = (int) (Math.random() * ARR_SIZE);
			} while (sInd == fInd || arr[sInd] == arr[fInd]);	
			array.swap(fInd, sInd);
			assertTrue(array.isOneSwap());
		}
		int ar1[] = {5,2,3,4,1};
		int ar2[] = {4,3,-3,8,10};
		int ar3[] = {4,3,-3,11,10};
		int ar4[] = {12,3,5,11,2};
		int ar5[] = {1,12,5,11,2};
		int ar6[] = {15,-2,-3,11,2};
		int ar7[] = {-10,-11,6,11,5};
		int ar8[] = {-10,-11,6,11,12};
		int ar9[] = {-100,-11,6,120,12};
		int ar10[] = {1000,-11,6,120,-1200};
		int ar11[] = {1000,-11,6,120,110,-1200};
		ArrayInt array1 = new ArrayInt(ar1);
		ArrayInt array2 = new ArrayInt(ar2);
		ArrayInt array3 = new ArrayInt(ar3);
		ArrayInt array4 = new ArrayInt(ar4);
		ArrayInt array5 = new ArrayInt(ar5);
		ArrayInt array6 = new ArrayInt(ar6);
		ArrayInt array7 = new ArrayInt(ar7);
		ArrayInt array8 = new ArrayInt(ar8);
		ArrayInt array9 = new ArrayInt(ar9);
		ArrayInt array10 = new ArrayInt(ar10);
		ArrayInt array11 = new ArrayInt(ar11);
		assertTrue(array1.isOneSwap());
		assertTrue(array2.isOneSwap());
		assertTrue(!array3.isOneSwap());
		assertTrue(array4.isOneSwap());
		assertTrue(array5.isOneSwap());
		assertTrue(!array6.isOneSwap());
		assertTrue(!array7.isOneSwap());
		assertTrue(array8.isOneSwap());
		assertTrue(array9.isOneSwap());
		assertTrue(array10.isOneSwap());
		assertTrue(!array11.isOneSwap());
	}
	
	private void fillArray(int[] arr, ArrayInt array) {
		int elem = 2;
		for(int i = 0; i < arr.length; i++) {
			array.add(elem);
			arr[i] = elem;
			elem = (int)(elem + 10 * (Math.random()));
		}
	}

//	@Test
//	void searchUnsorted() {
//		int[] arr2 = {25,100,20,40};
//		ArrayInt array2 = new ArrayInt(arr2);
//		assertEquals(-5, array2.search(10));
//		//assertEquals(1, array2.search(26));
//	}
//	
//	@Test
//	void searchSorted() {
//		int arr1[] = {-50,1,25,31,99,100,124,170};
//		ArrayInt array1 = new ArrayInt(arr1);
//		assertEquals(-5, array1.search(32));
//		assertEquals(5, array1.search(100));
//	}
//	
//	@Test
//	void hasTwoIntsSum() {
//		int arr1[] = {-50,1,25,31,99,100,124,170};
//		ArrayInt array1 = new ArrayInt(arr1);
//		assertTrue(array1.hasTwoIntsSum((short)-25));
//		assertTrue(!array1.hasTwoIntsSum((short)6000));
//	}

//	@Test
//	void get() {
//		int arr[] = {-50,1,25,31,99,100,124,170};
//		ArrayInt array = new ArrayInt(arr);
//		assertEquals(1, (int)array.get(1));
//		assertNull(array.get(-1));
//		assertNull(array.get(8));
//	}
	
//	@Test
//	void add() {
//		int arr[] = new int[10000];
//		ArrayInt array = new ArrayInt(new int[0]);
//		fillArray(arr, array);
//		testArray(arr, array);
//		System.out.println();
//	}
//
	private void testArray(int[] arr, ArrayInt array) {
		for(int i = 0; i < arr.length; i++) {
			assertEquals(arr[i], (int)array.get(i));
		}
	}
	
	
//	@Test
//	public void removeNumber() {
//		int ar[] = {10,20,15,100};
//		int expected[] = {10,15,100};
//		ArrayInt array = new ArrayInt(ar);
//		assertTrue(array.remove((int)1));
//		testArray(expected, array);
//	}
	
//	@Test
//	public void shuffle() {
//		int ar[] = new int[10000];
//		ArrayInt array = new ArrayInt(new int[0]);
//		fillArray(ar, array);
//		ArrayInt arraySh = new ArrayInt(ar);
//		arraySh.shuffle();
//		testAfterShuffle(array, arraySh);
//		ArrayInt arraySh1 = new ArrayInt(ar);
//		arraySh1.shuffle();
//		testAfterShuffle(arraySh, arraySh1);
//	}

	private void testAfterShuffle(ArrayInt array, ArrayInt arraySh) {
		int[] ar1 = getArray(array);
		int[] ar2 = getArray(arraySh);
		testSameNubers(ar1, ar2);
		assertFalse(Arrays.equals(ar1, ar2));
		
	};
	
//	private boolean testDifferentOrder(int[] ar1, int[] ar2) {
//		for (int i = 0; i < ar1.length; i++) {
//			if(ar1[i] != ar2[i]) return true;
//		}
//		return false;
//	}

	private void testSameNubers(int[] ar1, int[] ar2) {
		int[] ar1Sorted = Arrays.copyOf(ar1, ar1.length);
		Arrays.sort(ar1Sorted);
		int[] ar2Sorted = Arrays.copyOf(ar2, ar2.length);
		Arrays.sort(ar2Sorted);
		assertArrayEquals(ar1Sorted, ar2Sorted);
	}

	private int[] getArray(ArrayInt array) {
		int size = array.size();
		int [] res = new int[size];
		for(int i = 0; i < size; i++) 
			res[i] = array.get(i);
		return res;
	}
	
	@Test
	public void sort() {
		int ar[] = new int[10000];
		ArrayInt array = new ArrayInt();
		fillArray(ar, array);
		array.shuffle();
		array.sort();
		testSort(array);
	}

	private void testSort(ArrayInt array) {
		//assertTrue(array.isSorted());
		int size = array.size();
		for(int i = 1; i < size; i++) {
			assertTrue(array.get(i-1) <= array.get(i));
		}
	}
	
//	@Test
//	public void byMiddleIndex() {
//		int ar[] = new int[10000];
//		ArrayInt array = new ArrayInt();
//		fillArrayRamdom(ar, array);
//		int index = array.reorderByMiddleIndex();
//		System.out.println(index);
//	}
	
	
	
	private void fillArrayRamdom(int[] ar, ArrayInt array) {
		for(int i = 0; i < ar.length; i++) {
			int v = (int)( Math.random() * ((double)2147483647 + (double)2147483647) - (double)2147483647);
			array.add(v);
			ar[i] = v;
		}
	}
}
