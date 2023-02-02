package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 1자 이상 5자 이하여야 합니다.";
	private static final String CAR_NAME_NOT_EXIST_MESSAGE = "자동차의 이름이 존재하지 않습니다.";

	@Test
	@DisplayName("자동차의 이름은 공백일 수 없습니다.")
	void empty_name() {
		assertThatThrownBy(() -> new Name(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(CAR_NAME_NOT_EXIST_MESSAGE);
	}

	@Test
	@DisplayName("자동차의 이름은 null일 수 없습니다.")
	void null_name() {
		assertThatThrownBy(() -> new Name(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(CAR_NAME_NOT_EXIST_MESSAGE);
	}

	@Test
	@DisplayName("자동차의 이름은 1자 이상 5자 이하여야 합니다.")
	void exceed_name_length() {
		assertThatThrownBy(() -> new Name("euichan"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(NAME_LENGTH_EXCEPTION_MESSAGE);
	}
}