package racingcar.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validator.NameValidator;

public class NameValidatorTest {
	private final Cars cars = new Cars();
	private Car car1;
	private Car car2;
	private Car car3;

	@BeforeEach
	void initialize() {
		cars.add(Arrays.asList("null", "", "euichan"));
		List<Car> cars = this.cars.getCars();
		car1 = cars.get(0);
		car2 = cars.get(1);
		car3 = cars.get(3);
	}

	@Test
	@DisplayName("자동차 이름은 Null일 수 없다.")
	void validate_car_name_length() {
		assertThatThrownBy(() -> NameValidator.validateCarNames(car1.getName()))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
