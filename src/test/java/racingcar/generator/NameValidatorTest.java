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
	@DisplayName("자동차 이름은 5자 이하만 가능하다.")
	void validate_car_name_length() {
		car = new Car("euichan");
		NameValidator.validateCarNames(car.getName());
	}
}
