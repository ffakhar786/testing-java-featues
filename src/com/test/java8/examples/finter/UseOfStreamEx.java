package com.test.java8.examples.finter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UseOfStreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 4, 4);
		Set<Integer> duplicated = numbers
		  .stream()
		  .filter(n -> numbers.stream().filter(x -> {
			  return x == n;
			}).count() > 1).collect(Collectors.toSet());
		System.out.println(duplicated);
	}

}
