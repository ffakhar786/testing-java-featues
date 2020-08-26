package how2do.injava;

public class Q05Inheritance {

	public static void main(String[] args) {
		Pet pet = new Cat();
		Ball ball = new Ball();
		System.out.println(String.format("My %s is playing with a %s", pet.getName(), ball.getName()));
	}

}

class Pet {
	public String getName() {
		return "pet";
	}
}

class Cat extends Pet {
	@Override
	public String getName() {
		return "Cat";
	}
}

class Shape {
	private String name;
	public Shape() {
		name = "shape";
	}
	public String getName() {
		return name;
	}
}
class Ball extends Shape {
	private String name;
	public Ball() {
		name = "ball";
	}
}