package how2do.injava;

public class InheritanceDemo {

	public static void main(String[] args) {
		Parent1 p = new Child1();
		p.show();
		p.parentMethod();
		//p.childMethod();
	}

}

class Parent1 {
	
	public void parentMethod() {
		System.out.println("parent.parentMethod");
	}
	
	public void show() {
		System.out.println("parent.show()");
	}
}

class Child1 extends Parent1 {
	public void childMethod() {
		System.out.println("child.childMethod");
	}
	public void show() {
		System.out.println("child.show()");
	}
}