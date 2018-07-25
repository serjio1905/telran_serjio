package telran.util;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {

	private int current = 0;
	private Object[] ar;
	private int size;
	Array<E> array;
	
	public ArrayIterator(Array<E> obj) {
		this.ar = obj.ar;
		this.size = obj.size;
		array = obj;
	}

	@Override
	public boolean hasNext() {
		return current < size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		return (E)ar[current++];
	}
	
	@Override
	public void remove() {
		array.remove(--current);
	}

}
