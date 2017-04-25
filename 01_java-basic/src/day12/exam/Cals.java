package day12.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cals {
	private List<String[][]> cals;
	
	public Cals() {
		cals = Collections.synchronizedList(new ArrayList<String[][]>());
	}
	
	public void addMonth(String[][] month) {
		cals.add(month);
	}
	
	public String[][] getMonth(int i) {
		return cals.get(i);
	}
	
	public int size() {
		return cals.size();
	}
}
