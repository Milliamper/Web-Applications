package myPackage;

public class Main {

	public static void main(String[] args) {

		Engine engine = new InternalCombustionEngineImpl(180, 1600);
		
		Auto opelAstra = new Auto(engine, get4wheel(), "OpelAstra");
		
		System.out.println(opelAstra);
		
		//HF: ugyanez Springben
		//hint: @Bean

	}

	private static Wheel[] get4wheel() {
		Wheel[] wheels = new Wheel[4];

		for (int i = 0; i < wheels.length; i++) {
			wheels[i] = new WheelImpl(195, 55, 16);
		}
		
		return wheels;
		
	}

}
