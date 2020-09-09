package com.test.java8.examples.finter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FunctionalIntefaceMain {

	public static void main(String[] args) {
		FunctionalIntefaceMain pMain = new FunctionalIntefaceMain();
		final int x = 9;

		Printable q = (s -> {System.out.println(s); return s + 1;});
		int t = q.print(9);
		System.out.println(t);
		/*pMain.printForm(q);
		pMain.printForm((j) -> 
		  {
			  //final int x = 0;
			  System.out.println("Printing form");
		      for(int i = 0; i < 5; ) {
		    	  System.out.println("i="+ ++i + " - " + ++j + " " + x);
		      }
		  });*/

		List<Integer> ilst = new ArrayList<>();
		ilst = Arrays.asList(8, 4, 2, 5, 0, 12, 3, 17, 13);
		int sum = sumStream(ilst);
		System.out.println(sum);
		if (true) return ;

		Stream<Integer> stream = Stream.of(1,2,3,4);
		stream = Stream.of(new Integer[]{1,2,3,4});

		Stream<String> stream1 = Stream.generate(() -> {return "abc";});
		Stream<String> stream2 = Stream.iterate("abc", (i) -> i);

		LongStream is = Arrays.stream(new long[]{1,2,3,4});
		IntStream is2 = "abc".chars();

		Stream<Integer> intStream = Stream.of(1,2,3,4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println(intList); //prints [1, 2, 3, 4]

		intStream = Stream.of(1,2,3,4); //stream is closed, so we need to create it again
		Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
		System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}


		Stream<Integer> intStream1 = Stream.of(1,2,3,4);
		Integer[] intArray = intStream1.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray)); //prints [1, 2, 3, 4]

		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		Stream<Integer> sequentialStream = myList.stream();

		Stream<Integer> highNums = sequentialStream.filter(p -> p > 90); //filter numbers greater than 90
		System.out.print("High Nums greater than 90=");
		highNums.forEach(p -> System.out.print(p+" "));

		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
			return s.toUpperCase();
		}).collect(Collectors.toList()));

		Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted); // [ef, d, aBc, 123456]

		Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted); //[123456, aBc, d, ef]

		Stream<Integer> numbers = Stream.of(1,2,3,4,5);

		Optional<Integer> intOptional = numbers.reduce((i,j) -> {return i*j;});
		if(intOptional.isPresent()) System.out.println("Multiplication = "+intOptional.get()); //120

		Stream<Integer> numbers1 = Stream.of(1,2,3,4,5);
		System.out.println("Number of elements in stream="+numbers1.count()); //5

		Stream<Integer> numbers2 = Stream.of(1,2,3,4,5);
		numbers2.forEach(i -> System.out.print(i+",")); //1,2,3,4,5,

		Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
		System.out.println("Stream contains 4? "+numbers3.anyMatch(i -> i==4));
		//Stream contains 4? true

		Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
		System.out.println("Stream contains all elements less than 10? "+numbers4.allMatch(i -> i<10));
		//Stream contains all elements less than 10? true

		Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
		System.out.println("Stream doesn't contain 10? "+numbers5.noneMatch(i -> i==10));
		//Stream doesn't contain 10? trues


		Stream<String> names4 = Stream.of("Pankaj","Amit","David", "Lisa");
		Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
		if(firstNameWithD.isPresent()){
			System.out.println("First Name starting with D="+firstNameWithD.get()); //David
		}
	}

	public void printForm(Printable p) {
		p.print(55);
	}

	private static int sumStream(List<Integer> list) {
		return list.stream().filter(i -> i > 15).mapToInt(i -> i).sum();
	}
}
/* 
 void print( int j);

	default void printColor() {
		System.out.println("Printing Color copy");
	} 
 */