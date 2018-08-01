package telran.util;

import java.util.Iterator;
import java.util.List;

public class HashIterator<E> implements Iterator<E> {
	E previous;
	E current;
	boolean stopNext = false;
	int index;
	List<E>[] hashTable;
	HashTable<E> hT;
	
	public HashIterator(HashTable<E> hashTable) {
		this.hT = hashTable;
		this.hashTable = hashTable.hashTable;
		current = getFirstElement();
	}
	
	public E getFirstElement() {
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != null) {
				index = i;
				for(E o: hashTable[i]) {
					if(o != null) return o;
				}
			}
		}
		return null;
	}
	
	@Override
	public E next() {
		return previous;
	}
	
	@Override
	public boolean hasNext() {
		if (stopNext) return false;
		boolean flag = false;
		for(int i = index; i < hashTable.length; i++) {
			if(hashTable[i] != null) {
				index = i;
				for(E o: hashTable[i]) {
					if (flag == true) {
						previous = current;
						current = o;
						return true;
					}
					if(o.equals(current)) flag = true;
				}
			}
		}
		if (flag == true) {
			previous = current;
			stopNext = true;
			return true;
		}
		return false;
	}
	
	@Override
	public void remove() {
		hT.remove(previous);
	}
}
