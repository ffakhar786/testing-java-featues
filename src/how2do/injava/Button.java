package how2do.injava;
public class Button implements Clickable, Accessible {
	 
	public void printq(){
		//Clickable.super.print();
		//Accessible.super.print();
	}
 
	@Override
	public void print() {
		Clickable.super.print();
	}

	public static void main(String[] args) {
		Button button = new Button();
		button.click();
		button.access();
		button.print();
	}
}

interface Clickable{
	default void click(){
		System.out.println("click");
	}
 
	default void print(){
		System.out.println("Clickable");
	}
}
 
interface Accessible{
	default void access(){
		System.out.println("access");
	}
 
	default void print(){
		System.out.println("Accessible");
	}
}
 
