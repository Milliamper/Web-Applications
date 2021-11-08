package hu.iit.webalk.consoleApp.AutoSpring;

import org.springframework.stereotype.Component;

@Component
public class Auto {

	private final Engine motor;
	private final Wheel[] wheel;
	private final String type;

	public Auto(Engine motor, Wheel[] wheel, String type) {
		super();
		this.motor = motor;
		this.wheel = wheel;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Auto [motor=" + motor + ", wheel=" + wheel[0].toString() + ", type=" + type + "]";
	}

}
