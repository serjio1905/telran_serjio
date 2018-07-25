package telran.util;

import java.util.Comparator;

public class NaturalComporator<T> implements Comparator<T> {

	@SuppressWarnings("unchecked")
	@Override
	public int compare(T obj1, T obj2) {
		Comparable<T> comp1 = (Comparable<T>)obj1;
		Comparable<T> comp2 = (Comparable<T>)obj2;
		return comp1.compareTo((T) comp2);
	}
	
}
