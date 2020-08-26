package how2do.injava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Q16Iterator {

	public static void main(String[] args) {
		List<Integer> lst = GetSomeRandomValues();
		System.out.println(lst);
		try {
			for(Integer n : lst) {
				if (n % 2 == 0) {
					lst.remove(n);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(lst);
		}
		lst = GetSomeRandomValues();
		System.out.println(lst);
		try {
			List<Integer> tmpList = new ArrayList<>();
			for(Integer n : lst) {
				if (n % 2 == 0) {
					tmpList.add(n);
				}
			}
			lst.removeAll(tmpList);
			///System.out.println(lst);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(lst);			
		}
		
		lst = GetSomeRandomValues();
		System.out.println(lst);
		try {
			Iterator<Integer> it = lst.iterator();
			while(it.hasNext()) {
				Integer i = it.next();
				if (i % 2 == 0) {
					it.remove();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(lst);			
		}

	}

	private static List<Integer> GetSomeRandomValues() {
		List<Integer> lst = new ArrayList<>();
		Random random = new Random();
		int max = 100, min = 10;
		//return random.nextInt(max - min) + min;
		for(int i = 0; i < 10; i++) {
			int n = random.nextInt(max-min) + min;
			lst.add(n);
		}
		return lst;
	}

}
