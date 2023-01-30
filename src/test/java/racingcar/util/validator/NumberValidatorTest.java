package racingcar.util.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {
	@ParameterizedTest(name = "{index} : 시도 횟수 {0}번")
	@ValueSource(strings = {"-1", "0"})
	void 시도횟수_범위(String input) {
		assertThatThrownBy(() -> NumberValidator.validateNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "{index} : 숫자가 아닌 문자 {0} 입력")
	@ValueSource(strings = {"a", "B", "input"})
	void 숫자_미입력(String input) {
		assertThatThrownBy(() -> NumberValidator.validateNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
