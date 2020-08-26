package how2do.injava;

public class Q12Parent {

	public static void main(String[] args) {
		Parent c = new Child();
		System.out.println(c.value + "& " + c.getValue());
	}
}

class Parent {
	public String value = "Parent";
	public String getValue() {
		return value;
	}
}

class Child extends Parent {
	public String value = "Child";
	public String getValue() {
		return value;
	}
}
