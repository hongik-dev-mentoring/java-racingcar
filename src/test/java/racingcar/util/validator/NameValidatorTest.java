package racingcar.util.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameValidatorTest {

	private static final String DUPLICATE_CAR_NAME = "chan,chan";
	private static final String LENGTH_EXCEED_CAR_NAME = "euichan";

	@Test
	@DisplayName("자동차 이름은 Null일 수 없다.")
	void car_name_should_not_be_null() {
		assertThatThrownBy(() -> NameValidator.validateCarNames(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름은 비어있을 수 없다.")
	void car_name_should_not_be_empty() {
		assertThatThrownBy(() -> NameValidator.validateCarNames(""))
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
