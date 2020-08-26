package how2do.injava;

import java.util.ArrayList;

public class Q10Generic {

	public static void main(String[] args) {
		ArrayList<Double> dlist = new ArrayList<>();
		ArrayList<Number> numList = new ArrayList<>();
		
		addPi(dlist);
		addPi(numList);
		System.out.println(dlist.toString());
		System.out.println(numList.toString());
	}
	
	private static void addPi (ArrayList<? super Double> list) {
		list.add(Math.PI);
	}

}
