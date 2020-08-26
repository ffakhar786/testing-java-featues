package how2do.injava;

public class Q19Subclass extends Outer.Inner {
	public Q19Subclass(Outer outer){
		//super();
		outer.super();
	}
}


class Outer {
	
	class Inner {
		
	}
}