package telran.util;

import java.util.Comparator;

public class MyStuck {
	private Array<Integer> myStuck = new Array<Integer>();
	private Array<Integer> maxArray = new Array<Integer>();
	private Comparator<Integer> comp = new NaturalComporator<Integer>();
	
	public void pushNumber(int number) {
		myStuck.add((Integer) number);
		Integer max = maxArray.get(maxArray.size - 1);
		if(maxArray.size == 0 || comp.compare(max, number)<0)
			maxArray.add(number);
		else
			maxArray.add(max);
			
	}
	
	public Integer popNumber() {
		Integer res = null;
		int s = myStuck.size();
		if(myStuck.size() > 0) {
			res = myStuck.get(s-1);
			myStuck.remove(s-1);
			maxArray.remove(s-1);
		}
		return res;
	}
	
	public Integer getMax() {
		return maxArray.size > 0 ? maxArray.get(maxArray.size - 1) : null;
	}
	
	public static void main(String[] args) {
		
	}
	
}
