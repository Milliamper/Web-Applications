package hu.iit.webalk.consoleApp.AutoSpring;

import org.springframework.stereotype.Component;

@Component
public class WheelImpl implements Wheel {

	private final int width;
	private final int height;
	private final int radial;

	public WheelImpl(int width, int height, int radial) {
		super();
		this.width = width;
		this.height = height;
		this.radial = radial;
	}

	@Override
	public String toString() {
		return "WheelImpl [" + width + "/" + height + " R" + radial + "]";
	}

}
