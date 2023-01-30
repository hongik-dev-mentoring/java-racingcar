package racingcar.util.validator;

import static org.assertj.core.api.Assertions.*;
import static racingcar.util.validator.NameValidator.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameValidatorTest {
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 1자 이상 5자 이하여야 합니다.";
	private static final String CAR_NAME_NOT_EXIST_MESSAGE = "자동차의 이름이 존재하지 않습니다.";
	private static final String DUPLICATE_CAR_NAME_MESSAGE = "자동차의 이름은 중복일 수 없습니다.";
	private final List<String> emptyNames = List.of("");
	private final List<String> duplicateNames = List.of("chan", "chan");
	private final List<String> exceedNames = List.of("euichan");
	
	@Test
	@DisplayName("자동차 이름은 Null일 수 없다.")
	void car_name_should_not_be_null() {
		assertThatThrownBy(() -> validateCarNames(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CAR_NAME_NOT_EXIST_MESSAGE);
	}

	@Test
	@DisplayName("자동차 이름은 비어있을 수 없다.")
	void car_name_should_not_be_empty() {
		assertThatThrownBy(() -> validateCarNames(emptyNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CAR_NAME_NOT_EXIST_MESSAGE);
	}

	@Test
	@DisplayName("자동차 이름은 중복될 수 없다.")
	void car_name_should_not_be_duplicate() {
		assertThatThrownBy(() -> validateCarNames(duplicateNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(DUPLICATE_CAR_NAME_MESSAGE);
	}

	@Test
	@DisplayName("자동차 이름은 5자 이내여야 한다.")
	void validate_car_name_length() {
		assertThatThrownBy(() -> validateCarNames(exceedNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NAME_LENGTH_EXCEPTION_MESSAGE);
	}

	@ParameterizedTest(name = "{index}번 자동차 이름 : {0}")
	@DisplayName("자동차 이름 유효성 검사")
	@ValueSource(strings = {"", "dongho", "chan, chan"})
	void validate_car_name(String invalidNames) {
		assertThatThrownBy(() -> validateCarNames(List.of(invalidNames)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
