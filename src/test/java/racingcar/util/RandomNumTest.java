package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumTest {

	@Test
	@DisplayName("랜덤 수 생성")
	void createRandomNum() {

		int num = RandomNum.createRandomNum();

		assertAll(
			() -> assertThat(num).isGreaterThanOrEqualTo(0),
			() -> assertThat(num).isLessThanOrEqualTo(9)
		);
	}
}
