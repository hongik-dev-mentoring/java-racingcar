package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
	private static final String POSITION_NEGATIVE_MESSAGE = "자동차의 위치는 음수일 수 없습니다.";

	@Test
	@DisplayName("위치는 음수일 수 없습니다.")
	void position_can_not_be_negative() {
		assertThatThrownBy(() -> new Position(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(POSITION_NEGATIVE_MESSAGE);
	}

	@Test
	@DisplayName("자동차가 전진하면 위치가 1 증가해야 합니다.")
	void move_forward_car() {
		Position position = new Position(0);

		position.moveCarForward();

		assertThat(position.getValue()).isEqualTo(1);
	}
}