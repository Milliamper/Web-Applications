package hu.me.iit.webalk.dependency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Component;

@Component
@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

	@Mock
	Dependency dependency;

	@InjectMocks
	ServiceImpl service;

	@Test
	void calculateTest() {
		// GIVEN

		// WHEN
		service.calculate();

		// THEN
		// dependency referencia: megnézzük, hogy pontosan egyszer meghívódott-e a
		// megfelelő metódus
		verify(dependency, times(1)).helpNoParameterNoReturnValue();
	}

	@Test
	void return5Test() {
		// GIVEN
		final int FIVE = 5;

		// WHEN
		int result = service.return5();

		// THEN
		assertEquals(FIVE, result);
	}

	@Test
	// Is the service calls the dependency?
	// Is the return value of dependency method used?
	void dependencyReturnValueIsUsedTest() {
		// GIVEN
		final int FIVE = 5;

		// betanítjuk a függőség metódusát
		when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);

		// WHEN
		int result = service.callHelpAndUseReturnValue();

		// THEN
		verify(dependency, times(1)).helpNoParameterReturnValue();
		assertEquals(FIVE, result);
	}

	@Test
	// Is the service calls the dependency?
	// Is the parameter of dependency method appropriate?
	void callHelpAndPassParameter5Test() {
		// GIVEN
		final int FIVE = 5;

		// WHEN
		service.callHelpAndPassParameter5();

		// THEN
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

		verify(dependency, times(1)).helpWithParameterNoReturnValue(captor.capture());
		assertEquals(FIVE, captor.getValue());
	}

}