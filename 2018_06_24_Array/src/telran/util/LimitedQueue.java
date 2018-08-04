package telran.util;

import java.util.Arrays;

public class LimitedQueue {
	private int ar[];
	private int firstIndex = 0;
	private int size = 0;
	
	public static void main(String[] args) {
		
	}
	
	public LimitedQueue(int len) {
		this.ar = new int[len];
	}

	public Integer offer() {
		Integer res = null;
		if(size > 0) {
			res = ar[firstIndex];
			if(++firstIndex == ar.length) firstIndex = 0;
			size--;
		}
		return res;
	}
	
	public boolean add(int val) {
		int index = firstIndex + size;
		if(index >= ar.length) index = index - ar.length;
		if(size < ar.length) {
			ar[index] = val;
			size++;
			return true;
		}
		return false;
	}
}
