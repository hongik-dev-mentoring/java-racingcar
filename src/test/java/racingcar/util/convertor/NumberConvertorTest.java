package racingcar.util.convertor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberConvertorTest {
	private static final String ATTEMPT_NUMBER = "3";

	@Test
	@DisplayName("시도횟수 정상 입력")
	void attempt_number_input_success() {
		assertThat(NumberConvertor.convertNumber(ATTEMPT_NUMBER)).isEqualTo(3);
	}
}
