package telran.util;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {

	NodeList<E> current;
	LinkedList<E> linkedList;
	NodeList<E> prev;
	int i = 0;
	int size;
	
	public LinkedListIterator(LinkedList<E> linkedList) {
		//current = linkedList.head;
		this.linkedList = linkedList;
		this.size = linkedList.size;
	}

	@Override
	public boolean hasNext() {
		return i < this.size;
	}

	@Override
	public E next() {
		prev = current;
		if(current == null) {
			current = linkedList.head;
		} else 
			current = current.next;
		E res = current.object;
		i++;
		return res;
	}
	
	@Override
	public void remove() {
		if(current == linkedList.head) {
			if(current.next != null)
				linkedList.head = current.next;
		} else {
			prev.next = current.next;
		}
		linkedList.size--;
	}

}
