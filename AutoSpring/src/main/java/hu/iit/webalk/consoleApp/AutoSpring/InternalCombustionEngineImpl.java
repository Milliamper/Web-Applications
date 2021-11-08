package hu.iit.webalk.consoleApp.AutoSpring;

import org.springframework.stereotype.Component;

@Component
public class InternalCombustionEngineImpl implements Engine {
	
	private final int power;
	private final int ccm;
	
	public InternalCombustionEngineImpl(int power, int ccm) {
		super();
		this.power = power;
		this.ccm = ccm;
	}

	@Override
	public String toString() {
		return "InternalCombustionEngineImpl [power=" + power + ", ccm=" + ccm + "]";
	}


	
	
	
	

}
