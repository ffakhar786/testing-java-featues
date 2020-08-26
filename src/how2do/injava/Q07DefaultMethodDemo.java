package how2do.injava;

public class Q07DefaultMethodDemo implements FirstInterface, SecondInterface {

	public static void main(String[] args) {
		System.out.println(new Q07DefaultMethodDemo().talk());
		
		System.out.println(new Q07DefaultMethodDemo().whisper());
		
	}

	@Override
	public String whisper() {
		return FirstInterface.super.whisper();
	}

	@Override
	public String talk() {
		return "Good Talk ";
	}
}

interface FirstInterface {
	String talk();
	default String whisper() {
		return talk() + ", but softer";
	}
	
	default String yell() {
		return talk() + ", but louder";
	}
}

interface SecondInterface {
	String talk();
	default String whisper() {
		return talk() + ", but less annoying";
	}
	
	default String shout() {
		return talk() + ", but more annoying";
	}
}
