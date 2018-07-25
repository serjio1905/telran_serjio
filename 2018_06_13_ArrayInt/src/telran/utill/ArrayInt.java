package telran.utill;

public class ArrayInt {
	private static final int INITIAL_CAPACITY = 16;
	private static final int N_RESERV = 2;
	private int[] arr;
	private boolean flSorted = true;
	private int size = 0;
	
	public ArrayInt(int[] arr) {
		this.arr = new int[(arr.length > INITIAL_CAPACITY) ? arr.length : INITIAL_CAPACITY];
		if(arr.length > 0) {
			this.arr[0] = arr[0];
			this.size = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1]) this.flSorted = false;
			add(arr[i]);
		}
	}
	
	public ArrayInt() {
		flSorted = false;
		this.arr = new int[INITIAL_CAPACITY];
		this.size = 0;
	}
	
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "(" + i + "), ");
		}
		System.out.println();
	}
	
	public void add(int number) {
		if (this.size == this.arr.length) allocateMemory();
		if(this.flSorted) {
			insertSorted(number);
		} else {
			this.arr[this.size++] = number;
		}
	}
	
	public void insertSorted(int number) {
		int position = this.searchSorted(number);
		if(position < 0) 
			position = (-position) - 1;
		else
			position++;
		insertNumberByIndex(number, position);
	}
	
	public void insertNumberByIndex(int number, int index) {
		for(int i = this.size; i > index; i--) {
			this.arr[i] = this.arr[i-1];
		}
		this.arr[index] = number;
		this.size++;
	}
	
	public int search(int elt) {
		return this.flSorted?searchSorted(elt):searchUnsorted(elt);
	}
	
	//	liner search
	private int searchUnsorted(int elt){
		for(int i = 0; i < this.size; i++) {
			if(this.arr[i] == elt) return i;
		}
		return (this.size + 1) * (-1);
	}
	
	//	binary search
	private int searchSorted(int elt){
		if (this.size == 0) return -1;
		int right = this.size;
		int left = 0;
		int middle = 0;
		while(left < right) {
			middle = (right + left)/2;
			if(this.arr[middle] == elt) return middle;
			if(this.arr[middle] < elt)
				left = middle + 1;
			else
				right = middle;
		}
		int r = middle + 2;
		if(elt < this.arr[middle]) r = (middle + 1);
		return (r*(-1));
	}
	
	/**
	 * 
	 * @param sum of two elements in array
	 * @return true if find these two elements
	 */
	public boolean hasTwoIntsSum(short sum) {
		boolean n[] = new boolean[65535];
		for (int i = 0; i < this.arr.length; i++) {
			int diff = sum - this.arr[i] + 32768;
			if(n[this.arr[i] + 32768]) return true;
			n[diff] = true;
		}
		return false; 
	}
	
	public Integer get(int index) {
		return (index < 0 || index >= this.arr.length) ? null : this.arr[index];
	}
		
	private void allocateMemory() {
		int tmp[] = new int[this.arr.length * N_RESERV];
		for(int i = 0; i < size; i++) {
			tmp[i] = this.arr[i];
		}
		this.arr = tmp;
	}
	
	/**
	 * 
	 * @return index of array element nearest to middle of array and
	 * sum of elements left to index lass than sum of elements right to index (include 
	 * element by this index. Or -1 if array has no this index
	 */
	private int medianIndex() {
		int leftI = -1;
		int rightI = this.size;
		int leftS = 0;
		int rightS = 0;
		if(this.size == 0) return -1;
		for (int i = 0; i < this.size; i++) {
			if (rightI > leftI + 1) {
				if(rightI - leftI != 2)leftS+=this.arr[++leftI];
				rightS+=this.arr[--rightI];
			} else {
				if(rightS > leftS) return rightI;
				if(leftI == 0) return -1;
				leftS-=this.arr[leftI--];
				rightS+=this.arr[--rightI];
			}
		}
		return -1;
	}
	
	public boolean remove(Integer number) {
		int index = this.search(number);
		if(index < 0) return false;
		removeAt(index);
		return true;
	}
	
	private void removeAt(int index) {
		for(int i = index + 1; i < this.size; i++) {
			this.arr[i - 1] = this.arr[i];
		}
		this.arr[this.size - 1] = 0;
		this.size--;
	}
	
	/**
	 * removes number at given index
	 * @param index
	 * @return true if index correct (exist)
	 */
	public boolean remove(int index) {
		if(index < 0 || index >= this.size) return false;
		this.removeAt(index);
		return true;
	}
	
	/**
	 * 
	 * @return array size value
	 */
	public int size() {
		return this.size;
	}


	/**
	 * mix order of elements in array in the random order
	 */
	public void shuffle() {
		int[] tmp = new int[this.arr.length];
		int i = 0;
		int s = this.size;
		while(this.size > 0) {
			int index = (int) (Math.random() * (this.size - 1));
			tmp[i] = this.arr[index];
			this.remove(index);
			i++;
		}
		this.arr = tmp;
		this.size = s;
		this.flSorted = false;
	}
	
	public void sort() {
		if(this.flSorted) return;
		int index;
		for (int i = 1; i < this.size; i++) {
			index = i;
			while(index > 0 && this.arr[index] < this.arr[index-1]) {
				this.swap(index-1, index);
				index--;
			}
		}
		this.flSorted = true;
	}
	
	public void swap(int i, int j) {
//		// only interview question
//		this.arr[i] = this.arr[i]^this.arr[j];
//		this.arr[j] = this.arr[i]^this.arr[j];
//		this.arr[i] = this.arr[i]^this.arr[j];
		int tmp = this.arr[i];
		this.arr[i] = this.arr[j];
		this.arr[j] = tmp;
	}
	
	public boolean isSorted() {
		return this.flSorted;
	}
	
	/**
	 * reorder array around chosen number by middle index so that all numbers less
	 * then chosen number would be at left part and ones that are greater - at right 
	 * part relatively that chosen number
	 */
	public int reorderByMiddleIndex() {
		int index = this.size / 2;
		if(this.size < 2 || this.flSorted == true) return index;
		int[] tmp = new int[this.size];
		int index_end = this.size - 1;
		int index_begin = 0;
		for(int i = 0; i < this.size; i++) {
			if(this.arr[i] >= this.arr[index] && i != index) 
				tmp[index_end--] = this.arr[i];
			if(this.arr[i] < this.arr[index]) 
				tmp[index_begin++] = this.arr[i];
		}
		tmp[index_end] = this.arr[index];
		this.arr = tmp;
		return index;
	}
	
	private void fillArrayRamdom(int[] ar, ArrayInt array) {
		for(int i = 0; i < ar.length; i++) {
			int v = (int)( Math.random() * ((double)2147483647 + (double)2147483647) - (double)2147483647);
			array.add(v);
			ar[i] = v;
		}
	}
	
	public boolean isOneSwap() {
		int s = size - 1;
		int firstUnsortedIndex = 0;
		int secondUnsortedIndex = 0;
		boolean unsorted = false;
		for(int i = 0; i < s; i++) {
			if(unsorted && secondUnsortedIndex != 0 && arr[i] > arr[i+1]) return false;
			if(unsorted && secondUnsortedIndex == 0 && arr[i] > arr[i+1]) secondUnsortedIndex = i+1;
			if(!unsorted && arr[i] > arr[i+1]) {
				firstUnsortedIndex = i;
				unsorted = true;
			}
		}
		if(secondUnsortedIndex == 0) secondUnsortedIndex = firstUnsortedIndex + 1;
		if(unsorted && arr[secondUnsortedIndex] <= arr[firstUnsortedIndex + 1] && arr[secondUnsortedIndex-1] <= arr[firstUnsortedIndex]) return true;
		return false;
	}
	
	
	
	public static void main(String[] args) {
		int ar[] = {5,2,3,4,1};
		ArrayInt array = new ArrayInt(ar);
		System.out.println(array.isOneSwap());
	}

}
