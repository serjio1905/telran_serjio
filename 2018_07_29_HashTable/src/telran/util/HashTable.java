package telran.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;

public class HashTable<E> implements Set<E> {

	List<E>[] hashTable;
	private static final float FACTOR = 0.75f; // size/hashTable.length
	int size;
	int length;
	private static final int MULTIPLICATOR = 2;
	private static final int INITIAL_LENGTH = 10;
	
	public static void main(String[] args) {
		HashTable<Integer> hashTable = new HashTable<Integer>();
		Integer[] expOriginal = {100, 80, 40, 30, 20, 50, 82, 90, 85, 95};
		for(int i = 0; i < expOriginal.length; i++) {
			hashTable.add(expOriginal[i]);
		}
		System.out.println(Arrays.toString(hashTable.toArray()));
		Collection<Integer> collection = new HashTable<Integer>();
		collection.add(80);
		collection.add(40);
		hashTable.removeAll(collection);
		System.out.println(Arrays.toString(hashTable.toArray()));
	}
	
	public HashTable() {
		this(INITIAL_LENGTH);
	}
	
	public HashTable(int lenght) {
		this.length = lenght;
		hashTable = new List[lenght];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		int index = getIndex(o);
		if(hashTable[index] == null) return false;
		return hashTable[index].contains(o);
	}
	
	private int getIndex(Object o) {
		int hashCode = o.hashCode();
		int res = Math.abs(hashCode) % this.length;
		return res;
	}

	@Override
	public Iterator<E> iterator() {
		return new HashIterator<E>(this);
	}

	@Override
	public Object[] toArray() {
		Object [] arr = new Object[this.size];
		int i = 0;
		for(E o: this) {
			arr[i++] = o;
		}
		return arr;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		if(contains(e)) return false;
		if((float)(size / hashTable.length) > FACTOR) 
			tableRecreation();
		int index = getIndex(e);
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<E>();
		}
		size++;
		return hashTable[index].add(e);
	}

	private void tableRecreation() {
		this.length *= MULTIPLICATOR;
		List<E>[] hashTableNew = new List[this.hashTable.length * MULTIPLICATOR];
		for(E e: this) {
			int index = getIndex(e);
			if(hashTableNew[index] == null) {
				hashTableNew[index] = new LinkedList<E>();
			}
			hashTableNew[index].add(e);
		}
		hashTable = hashTableNew;
	}
	
	@Override
	public boolean remove(Object o) {
		int index = getIndex(o);
		if (hashTable[index].remove(o)) {
			size--;	
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o: c) {
			if(!this.contains(o)) return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(Object o: c) {
			this.add((E)o);
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		for(Object o: c) {
			this.removeIf(x -> !c.contains(x));
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object o: c) {
			this.removeIf(x -> c.contains(x));
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
