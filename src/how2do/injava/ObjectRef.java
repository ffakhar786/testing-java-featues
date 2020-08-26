package how2do.injava;

import java.util.ArrayList;
import java.util.List;

public class ObjectRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new ArrayList<>();
		list1.add("foo");
		List<String> list2 = list1;
		List<String> list3 = new ArrayList<>(list2);
		list1.clear();
		list2.add("bar");
		list3.add("baz");
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);

	}

}
