package how2do.injava;

import java.util.ArrayList;
import java.util.List;

public class Lambda2 {
	public static void main(String[] arg) {
		List<Asteroid> asteriods = new ArrayList<>();
		asteriods.add(new Asteroid("Sylvia", 286));
		asteriods.add(new Asteroid("Pallas", 512));
		asteriods.add(new Asteroid("Eunomia", 268));
		asteriods.add(new Asteroid("Juno", 258));
		asteriods.add(new Asteroid("Hygiwa",431));
		asteriods.add(new Asteroid("Davida", 289));
		
		Asteroid c = asteriods.stream().reduce(asteriods.get(0),
				(a,b) -> a.getDiameter() > b.getDiameter() ? a : b);
		System.out.println(c);
	}
}

class Asteroid {
	private String name;
	private double diameter;
	
	public Asteroid(String name, double diameter) {
		this.setName(name);
		this.setDiameter(diameter);		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getDiameter() {
		return diameter;
	}
	
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	public String toString() {
		return String.format("%s [%.2f]", getName(), getDiameter());
	}
}

