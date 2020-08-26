package how2do.injava;

public class Q20ChangeTheString {

	public static void main(String[] args) {
		String weather = "rainy";
		changeTheString(weather);
		
		System.out.println("The weather is " +  weather);
		String[] rainyDays = new String[] {"Monday", "Friday"};
		changeTheArray(rainyDays);
		System.out.println("The rainy days were on " + rainyDays[0] + " and " + rainyDays[1]);
		
		Forecast forecast = new Forecast();
		forecast.pressure = 700;
		forecast.temperature = 20;
		changeTheObject(forecast);
		System.out.println("the temperature is " + forecast.temperature + "*C");
	}
	
	public static void changeTheString(String weather) {
		weather = "sunny";
	}
	
	public static void changeTheArray(String[] rainyDays) {
		rainyDays[1] = "Sunday";
		
	}
	
	public static void changeTheObject(Forecast forecast) {
		forecast.temperature = 35;
	}
	
	

}

class Forecast {
	public int temperature;
	public int pressure;
}
