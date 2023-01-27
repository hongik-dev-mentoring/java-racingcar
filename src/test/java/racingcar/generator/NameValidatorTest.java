package racingcar.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

public class NameValidatorTest {
	private Car car;

	@BeforeEach
	void initiate() {
		car = new Car("chan");
	}

	@Test
	@DisplayName("")
}
