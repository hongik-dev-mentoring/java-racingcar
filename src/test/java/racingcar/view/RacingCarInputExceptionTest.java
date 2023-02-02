package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarInputExceptionTest {

	@Test
	@DisplayName("null 값 테스트")
	void isNull() {
		String test = null;

		Assertions.assertThrows(IllegalArgumentException.class, () -> RacingCarInputException.isNull(test));
	}

	@Test
	@DisplayName("Empty 값 테스트")
	void isEmpty() {
		String test = "";

		Assertions.assertThrows(IllegalArgumentException.class, () -> RacingCarInputException.isEmpty(test));
	}

	@Test
	@DisplayName("5이하의 문자열 입력 테스트")
	void isLessThanFive() {
		String[] test = {"na", "tae", "abcdef"};
		ArrayList<String> result = new ArrayList<>();

		assertAll(
			() -> assertThrows(IllegalArgumentException.class,
				() -> RacingCarInputException.checkValidation(result, test)),
			() -> assertThat(result.size()).isEqualTo(2)
		);
	}

	@Test
	@DisplayName("중복 이름 테스트")
	void isDuplicatedName() {
		String[] test = {"na", "tae", "joe", "tae"};
		ArrayList<String> result = new ArrayList<>();

		assertAll(
			() -> assertThrows(IllegalArgumentException.class,
				() -> RacingCarInputException.checkValidation(result, test)),
			() -> assertThat(result.size()).isEqualTo(3)
		);
	}

	@Test
	@DisplayName("이름 사이에 , 예외 테스트")
	void nameTest() {
		String[] test = {"na", "ta,e", "joe"};
		ArrayList<String> result = new ArrayList<>();

		assertAll(
			() -> assertThrows(IllegalArgumentException.class,
				() -> RacingCarInputException.checkValidation(result, test)),
			() -> assertThat(result.size()).isEqualTo(1)
		);
	}

}
