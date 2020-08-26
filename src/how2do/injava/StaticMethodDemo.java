package how2do.injava;

public class StaticMethodDemo implements TestInterface {
	// Implementation of square abstract method
	public void square(int a) {
		System.out.println(a * a);
	}
	
	static void show() {
		System.out.println("Staticmmmmmm Method Executed");
	}

	public static void main(String args[]) {
		StaticMethodDemo d = new StaticMethodDemo();
		d.square(4);
		d.show();
		
		TestInterface t = new StaticMethodDemo();
		t.square(5);

		// Static method executed
		TestInterface.show();
	}
}

//A simple Java program to TestClassnstrate static 
//methods in java 
interface TestInterface {
	// abstract method
	public void square(int a);

	// static method
	static void show() {
		System.out.println("Static Method Executed");
	}
}

/*
 * public class StaticMethodDemo {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * 
 * }
 * 
 * }
 */
