package racingcar.util.validator;

import static org.assertj.core.api.Assertions.*;
import static racingcar.util.validator.NameValidator.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.model.Car;

public class NameValidatorTest {

	private static final String DUPLICATE_CAR_NAME = "chan,chan";
	private static final String LENGTH_EXCEED_CAR_NAME = "euichan";

	@Test
	@DisplayName("자동차 이름은 Null일 수 없다.")
	void car_name_should_not_be_null() {
		assertThatThrownBy(() -> validateCarNames(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NULL_CAR_NAME_MESSAGE);
	}

	@Test
	@DisplayName("자동차 이름은 비어있을 수 없다.")
	void car_name_should_not_be_empty() {
		assertThatThrownBy(() -> validateCarNames(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(EMPTY_CAR_NAME_MESSAGE);
	}

	@Test
	@DisplayName("자동차 이름은 중복될 수 없다.")
	void car_name_should_not_be_duplicate() {
		assertThatThrownBy(() -> validateCarNames(DUPLICATE_CAR_NAME))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(DUPLICATE_CAR_NAME_MESSAGE);
	}

	@Test
	@DisplayName("자동차 이름은 5자 이내여야 한다.")
	void validate_car_name_length() {
		assertThatThrownBy(() -> validateCarName(LENGTH_EXCEED_CAR_NAME))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NAME_LENGTH_EXCEPTION_MESSAGE);
	}

	@ParameterizedTest(name = "{index}번 자동차 이름 : {0}, 결과 : {1}")
	@DisplayName("자동차 이름 유효성 검사")
	@MethodSource("invalidCarNames")
	void validate_car_name(String carName, String expectedResult) {
		assertThatThrownBy(() -> new Car(carName))
			.isInstanceOf(IllegalArgumentException.class);
	}

	static Stream<Arguments> invalidCarNames() {
		return Stream.of(
			Arguments.of("euichan", "이름 5자 초과"),
			Arguments.of("", "1글자 미만"),
			Arguments.of(null, "null 입력"),
			Arguments.of("chan,,dong", "이름이 0자")
		);
	}
}
