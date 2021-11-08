package hu.iit.webalk.consoleApp.AutoSpring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jparams.verifier.tostring.ToStringVerifier;

class AutoSpringApplicationTests {

	@Test
	public void testToString() {
		
		ToStringVerifier.forClass(Auto.class).verify();
		ToStringVerifier.forClass(InternalCombustionEngineImpl.class).verify();
		ToStringVerifier.forClass(ElectricMotorImpl.class).verify();
		ToStringVerifier.forClass(WheelImpl.class).verify();
		ToStringVerifier.forClass(Main.class).verify();
		
	}
	


}
