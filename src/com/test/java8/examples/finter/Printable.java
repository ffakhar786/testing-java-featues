package com.test.java8.examples.finter;

public interface Printable {

	int print( int j);

	default void printColor() {
		System.out.println("Printing Color copy");
	}
	
	default void printColor1() {
		System.out.println("Printing1 Color copy");
	} 
	
	//void print1();
}