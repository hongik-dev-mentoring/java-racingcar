package racingcar.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.validator.NameValidator;

public class NameValidatorTest {
	private final Cars cars = new Cars();
	private Car nullCar;
	private Car emptyCar;
	private static final String DUPLICATE_CAR_NAME = "chan,chan";
	private static final String LENGTH_EXCEED_CAR_NAME = "euichan";

	@BeforeEach
	void initialize() {
		cars.add(Arrays.asList(null, ""));
		List<Car> cars = this.cars.getCars();
		nullCar = cars.get(0);
		emptyCar = cars.get(1);
	}

	@Test
	@DisplayName("자동차 이름은 Null일 수 없다.")
	void car_name_should_not_be_null() {
		assertThatThrownBy(() -> NameValidator.validateCarNames(nullCar.getName()))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름은 Empty일 수 없다.")
	void car_name_should_not_be_empty() {
		assertThatThrownBy(() -> NameValidator.validateCarNames(emptyCar.getName()))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름은 중복될 수 없다.")
	void car_name_should_not_be_duplicate() {
		assertThatThrownBy(() -> NameValidator.validateCarNames(DUPLICATE_CAR_NAME))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름은 5자 이내여야 한다.")
	void validate_car_name_length() {
		assertThatThrownBy(() -> NameValidator.validateCarName(LENGTH_EXCEED_CAR_NAME))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
