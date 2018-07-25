package telran.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public class Array<T> implements List<T> {
	private static final int INITIAL_CAPACITY = 16;
	private static final int FACTOR = 2;
	protected Object ar[] = new Object[INITIAL_CAPACITY];
	protected int size;
	
	public boolean add(T obj) {
		if(size == ar.length) allocateArray();
		ar[size++] = obj;
		return true;
	}
	
	protected void allocateArray() {
		ar = Arrays.copyOf(ar, ar.length*FACTOR);
		
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public void shuffle() {
		int s = size;
		Object tmp[] = new Object[ar.length];
		int index;
		for(int i = 0; i < s; i++) {
			index = (int) (Math.random() * size);
			tmp[i] = ar[index];
			remove(index);
		}
		ar = tmp;
		size = s;
	}
	
	private void add(T obj, int index) {
		if(size == ar.length) allocateArray();
		if(index < 0 || index > size) return;
		for(int i = size; i > index; i--) {
			ar[i] = ar[i-1];
		}
		ar[index] = obj;
		size++;
	}
	
	public T remove(int index) {
		int j = size - 1;
		if(index < 0 || index > j) return null;
		T res = (T)ar[index];
		for(int i = index; i < j; i++) {
			ar[i] = ar[i+1];
		}
		size--;
		return res;
	}
	
	public T get(int i) {
		Object res = null;
		if(i >= 0 && i < size) res = ar[i];
		return (T)res;
	}
	
	public int indexOf(Object pattern) {
		for (int i = 0; i < size; i++) 
			if(ar[i].equals(pattern)) 
				return i;
		return -1;
	}
	
	public int indexOf(Predicate<T> predicate) {
		for (int i = 0; i < size; i++) 
			if(predicate.test((T) ar[i])) 
				return i;
		return -1;
	}
	
	public int indexOfLast(Predicate<T> predicate) {
		for (int i = size - 1; i >= 0; i--) 
			if(predicate.test((T) ar[i])) 
				return i;
		return -1;
	}
	
	public boolean remove(Object pattern) {
		int s = size;
		boolean res = false;
		for (int i = 0; i < s; i++) {
			if(size < s) {
				ar[i-1] = ar[i];
			} else {
				if(ar[i] == pattern) size--;
				res = true;
			}
		}
		return res;
	}
	
	public boolean removeIf(Predicate<? super T> predicate) {
//		boolean res = false;
//		int count = 0;
//		int s = size;
//		for (int i = 0; i < s; i++) {
//			if(predicate.test((T) ar[i])) {
//				res = true;
//				count++;
//				size--;
//			} else {
//				if(count > 0) ar[i - count] = ar[i];
//			}
//		}
//		return res;
		boolean res = false;
		Iterator<T> it = this.iterator();
		while(it.hasNext()) {
			T obj = it.next();
			if(predicate.test((T) predicate)) {
				res = true;
				it.remove();
				
			}
		}
		return res;
	}
	
	public int indexOfLast(Object pattern) {
		for (int i = size - 1; i >= 0; i--) 
			if(ar[i].equals(pattern)) 
				return i;
		return -1;
	}
	
	public void sort() {
		sort(new NaturalComporator<T>());
	}
	
	private void swap(int i, int j) {
		T tmp = (T)ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}
	
	@Override
	public void sort(Comparator<? super T> comp) {
		int n = size;
		boolean flSort = true;
		do {
			flSort = true;
			n--;
			for(int i = 0; i < n ; i++) {
				if(comp.compare((T)ar[i], (T)ar[i+1])>0) {
					swap(i, i + 1);
					flSort = false;
				}
			}
		} while (!flSort);
	}

	@Override
	public void add(int index, T element) {
		add(element, index);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return false;
	}

	@Override
	public void clear() {
		
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator<T>(this);
	}

	@Override
	public int lastIndexOf(Object o) {
		return indexOfLast(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public T set(int index, T element) {
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public Object[] toArray() {
		return this.ar;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

}
