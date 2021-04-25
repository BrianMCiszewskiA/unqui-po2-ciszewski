package unq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Counter {
	private List<Integer> numberList = new ArrayList<Integer>();
	
	public void addNumber(Integer n) {
		numberList.add(n);
	}
	public int getEvenOcurrences() {
		int count = 0;
		for(Integer n: numberList){
			count = count + this.countIfEven(n);
		}
		return count;
	}
	int countIfEven(int n) {
		return this.countIfMultipleOf(n, 2);
	}
	int countIfMultipleOf(int multiple, int of) {
		if(this.isMultipleOf(multiple, of)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	boolean isMultipleOf(int multiple, int of) {
		return multiple%of == 0;
	}
	public int getOddOcurrences() {
		return numberList.size() - this.getEvenOcurrences();
	}
	public int getMultiplesOf(int x) {
		int count = 0;
		for(Integer n: numberList){
			count = count + this.countIfMultipleOf(n, x);
		}
		return count;
	}
}
