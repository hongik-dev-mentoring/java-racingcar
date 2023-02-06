package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptNumberTest {
	@ParameterizedTest(name = "{index} : 시도 횟수 {0}번")
	@ValueSource(strings = {"-1", "0"})
	@DisplayName("시도횟수 범위는 0번 이하일 수 없다.")
	void attempt_number_range(String input) {
		assertThatThrownBy(() -> new AttemptNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "{index} : 숫자가 아닌 문자 {0} 입력")
	@ValueSource(strings = {"a", "B", "input"})
	@DisplayName("시도횟수는 숫자여야 한다.")
	void attempt_number_should_be_number(String input) {
		assertThatThrownBy(() -> new AttemptNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("시도횟수 정상 입력")
	void attempt_number_input_success() {
		assertThat(new AttemptNumber("3").getAttemptNumber()).isEqualTo(3);
	}
}
