import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Array;
import telran.util.LinkedList;

class ArrayTest {
	
	List<Integer> array;
	List<String> strings;
	Integer[] arExp1 = {3,-10,20,100,80,13,150,98,24,100,3}; 
	Integer[] arExpRemoveIf = {3,-10,20,80,13,150,98,24,3};
	Integer[] arExpRemove = {3,-10,20,80,13,150,98,24,100,3}; 
	Integer[] arExpEvenOdd = {-10,20,24,80,98,100,100,150,13,3,3};
	String[] arExpStr= {"abcdefg","drt","mk","j","123456","dart","j"}; 
	String[] arExpStrLength= {"j","j","mk","drt","dart","123456","abcdefg"}; 
	
	@BeforeEach
	public void setUp() throws Exception {
		array = new LinkedList<Integer>();
		strings = new LinkedList<String>();
		fillArray(arExp1, array);
		fillArray(arExpStr, strings);
	}

	private <T>void fillArray(T[] array, List<T> list) {
		for(int i =0; i < array.length; i++) {
			list.add(array[i]);
		}
	}

	@Test
	void addGet() {
		Object[] actual = getArray(array);
		assertArrayEquals(arExp1, actual);
	}

	@SuppressWarnings("unchecked")
	private <T> Object[] getArray(List<T> list) {
		Object[] res = new Object[list.size()];
		int ind = 0;
		for(Object obj: list) {
			res[ind++] = obj;
		}
		return (T[])res;
	}

//	@Test
//	void shuffle() {
//		array.shuffle();
//	}
	
	@Test
	public void indexOf() {
		assertEquals(2, strings.indexOf("mk"));
		strings.add(2, "mk");
		assertEquals(3, strings.lastIndexOf("mk"));
		assertEquals(-1, strings.lastIndexOf("rgrtkpk"));
		assertEquals(-1, strings.lastIndexOf("rgrtkpk"));
	}
	
	@Test
	public void sort() {
		array.sort((x, y) -> x - y);
		strings.sort((x, y) -> x.compareTo(y));
		Object[] actualI = getArray(array);
		Object[] actualS = getArray(strings);
		Arrays.sort(arExp1);
		Arrays.sort(arExpStr);
		assertArrayEquals(arExp1, actualI);
		assertArrayEquals(arExpStr, actualS);
	}
	
	@Test
	public void sortCoparator() {
		//Anonymous class
//		strings.sort(new Comparator<String>() {
//			
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length()-o2.length();
//			}
//		});
		//Lambda Expression
		strings.sort((o1, o2)->o1.length()-o2.length());
		Object[] actual = getArray(strings);
		assertArrayEquals(arExpStrLength, actual);
		//Function closure
		
//		array.sort((x,y)->{
//			int r1 = x%2;
//			int r2 = y%2;
//			int res = r1 - r2;
//			if(r1 == 0 && r2 == 0)
//				res = x - y;
//			else if(r1 != 0 && r2 != 0)
//				res = y - x;
//			return res;
//		});
		//Method reference
		array.sort(this::compEvenOdd);
		//array.sort((x,y)->compEvenOdd(x, y));
		actual = getArray(array);
		assertArrayEquals(arExpEvenOdd, actual);
	}
	
	int compEvenOdd(Integer x, Integer y) {
		int r1 = x%2;
		int r2 = y%2;
		int res = r1 - r2;
		if(r1 == 0 && r2 == 0)
			res = x - y;
		else if(r1 != 0 && r2 != 0)
			res = y - x;
		return res;
	}

	
	@Test
	public void removeObject() {
		array.remove((Integer)100);
		Object[] actual = getArray(array);
		assertArrayEquals(arExpRemove, actual);
	}
	
	@Test
	public void removeIf() {
		array.removeIf(Predicate.isEqual((Integer)100));
		Object[] actual = getArray(array);
		assertArrayEquals(arExpRemoveIf, actual);
	}
	
	@Test
	public void indexOfPredicate() {
		//assertEquals(3, array.indexOf(o -> o.equals(100)));
//		int i = array.indexOf(Predicate.isEqual((Integer)(-10)));
//		System.out.println(i);
//		assertEquals(1, array.indexOf(Predicate.isEqual((Integer)(-10))));
		//assertEquals(6, array.indexOf(x -> x.equals(150)));
//		assertEquals(8, array.indexOf(Predicate.isEqual((Integer)24)));
//		assertEquals(-1, array.indexOf(Predicate.isEqual((Integer)70)));
//		assertEquals(-1, array.indexOf(Predicate.isEqual((Integer)0)));
		//assertEquals(2, strings.indexOf(o -> o.equals("mk")));
		//assertEquals(-1, strings.indexOf(o -> o.equals("mkerferr")));
	}
	
//	@Test
//	public void indexOfLastPredicate() {
//		assertEquals(10, array.indexOfLast(Predicate.isEqual((Integer)3)));
//		assertEquals(9, array.indexOfLast(Predicate.isEqual((Integer)100)));
//		assertEquals(8, array.indexOfLast(Predicate.isEqual((Integer)24)));
//		assertEquals(-1, array.indexOfLast(Predicate.isEqual((Integer)1000)));
//		assertEquals(6, strings.indexOfLast(o -> o.equals("j")));
//	}
	
}

