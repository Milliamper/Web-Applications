package hu.iit.webalk.consoleApp.AutoSpring;

import org.springframework.stereotype.Component;

@Component
public class ElectricMotorImpl implements Engine {

	private final int power;
	private final int voltage;

	public ElectricMotorImpl(int power, int voltage) {
		super();
		this.power = power;
		this.voltage = voltage;
	}

	@Override
	public String toString() {
		return "ElectricMotor [power=" + power + ", voltage=" + voltage + "]";
	}

}
