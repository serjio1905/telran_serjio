package telran.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class LinkedList<E> implements List<E> {

	NodeList<E> head;
	NodeList<E> tail;
	public int size;
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(25);
		list.add(25);
		list.add(25);
		list.add(null);
		list.add(5);
		list.add(8);
		list.add(25);
		System.out.println(Arrays.toString(list.toArray()));
		
		list.removeIf(x -> x != null && x == 8);
		
		System.out.println(Arrays.toString(list.toArray()));
		
	}
	
	@Override
	public boolean add(E e) {
		NodeList<E> newNode = new NodeList<>(e);
		if(head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return false;
	}
	
	public boolean isLoopEnded() {
		NodeList<E> current = this.head;
		while(current != null && current.next != null) {
			boolean curentFlag = current.flag;
			current.flag = !current.flag;
			if(curentFlag != current.next.flag) return false;
			current = current.next;
		}
		return true;
	}
	
	public boolean isLoopEnded1() {
		return this.tail.next != null ? false : true;
	}

	@Override
	public void add(int index, E element) {
		if(index < 0 || index > size) return;
		if(index == size) {
			add(element);
		} else {
			if(index == 0) {
				addHead(element);
			} else {
				NodeList<E> newElement = new NodeList<>(element);
				NodeList<E> previous = getPreviousNode(index);
				newElement.next = previous.next;
				previous.next = newElement;
				size++;
			}	
		}
	}
	
	private NodeList<E> getPreviousNode(int index) {
		NodeList<E> res = head;
		for(int i = 0; i < index-1; i++) {
			res = res.next;
		}
		return res;
	}
	
	public NodeList<E> getNode(int index) {
		NodeList<E> res = head;
		for(int i = 0; i < index; i++) {
			res = res.next;
		}
		return res;
	}
	
	private void addHead(E element) {
		NodeList<E> newElement = new NodeList<>(element);
		newElement.next = head;
		head = newElement;
		size++;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean contains(Object o) {
		NodeList<E> current = head;
		if(o == null) {
			for(int i = 0; i < size; i++) {
				if(current.object == o) return true;
				current = current.next;
			}
		} else {
			for(int i = 0; i < size; i++) {
				if(current.object != null && current.object.equals(o)) return true;
				current = current.next;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= size) return null;
		if(index == size - 1) return tail.object;
		if(index == 0) return head.object;
		return getPreviousNode(index+1).object;
	}

	@Override
	public int indexOf(Object o) {
		NodeList<E> res = head;
		for(int i = 0; i < size; i++) {
			if (o != null) {
				if(res.object != null && res.object.equals(o)) return i;
			} else {
				if(res.object == o) return i;
			}
			res = res.next;
		}
		return -1;
	}
	
	public <T> int indexOf(Predicate<T> pred) {
		NodeList<E> res = head;
		for(int i = 0; i < size; i++) {
			if (pred.test((T)res.object))
				return i;
			res = res.next;
		}
		return -1;		
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(this);
	}

	@Override
	public int lastIndexOf(Object o) {
		int s = size;
		int res = -1;
		NodeList<E> cur = head;
		for(int i = 0; i < s; i++) {
			if (o != null) {
				if(cur.object != null && cur.object.equals(o)) res = i;
			} else {
				if(cur.object == o) res = i;
			}
			cur = cur.next;
		}
		return res;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		NodeList<E> cur = head;
		boolean res = false;
		if(o == null) {
			if (head.object == null) {
				removeHead();
				return true;
			}
			for(int i = 0; i < size-1; i++) {
				if(cur.next.object == o) {
					if(i == size - 2) {
						tail = cur;
						cur.next = null;
					} else {
						cur.next = cur.next.next;
					}
					size--;
					return true;
				}
				cur = cur.next;
			}
		} else {
			if (head.object.equals(o)) {
				removeHead();
				return true;
			}
			for(int i = 0; i < size-1; i++) {
				if(cur.next.object != null && cur.next.object.equals(o)) {
					if(i == size - 2) {
						tail = cur;
						cur.next = null;
					} else {
						cur.next = cur.next.next;
					}
					size--;
					return true;
				}
				cur = cur.next;
			}
		}
		return res;
	}

	private void removeHead() {
		if(size > 0) {
			head = head.next;
			size--;
		}
	}
	
	@Override
	public E remove(int index) {
		int s = size();
		if(index < 0 || index >= s) return null;
		E res = null;
		NodeList cur = head;
		if(index == 0) {
			res = head.object;
			removeHead();
		} else {
			for(int i = 0; i < s - 1; i++) {
				if(i == index - 1) {
					if(index == s - 1) {
						tail = cur;
						res = tail.object;
					}
					res = (E)cur.next.object;
					cur.next = cur.next.next;
					size--;
				}
				cur = cur.next;
			}
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override 
	public boolean removeIf(Predicate<? super E> predicate) {
		boolean res = false;
		Iterator<E> it = this.iterator();
		while(it.hasNext()) {
			E obj = it.next();
			if(predicate.test(obj)) {
				res = true;
				it.remove();
			}
		}
		return res;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparator<? super E> comp) {
		E[] arr = (E[]) new Object[size];
		NodeList cur = this.head;
		for(int i = 0; i < size; i++) {
			arr[i] = (E) cur.object;
			cur = cur.next;
		}
		Arrays.sort(arr, comp);
		cur = head;
		for(int i = 0; i < size; i++) {
			cur.object = arr[i];
			cur = cur.next;
		}
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public Object[] toArray() {
		int s = size;
		NodeList<E> current = head;
		Object[] arr = new Object[s]; 
		for(int i = 0; i < s; i++) {
			arr[i] = current.object;
			if(i < s - 1) current = current.next;
		}
		return arr;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}
	
	
}
