package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	Car car;

	@BeforeEach
	void setup() {
		car = new Car("tae");
	}

	@Test
	@DisplayName("winNum 1 올리기")
	void increaseWinNum() {

		car.increaseWinNum();

		assertThat(car.getWinNum()).isEqualTo(1);
	}

	@Test
	@DisplayName("정상적으로 race 테스트")
	void race() {

		int tryNum = 4;

		car.race(tryNum);

		assertThat(car.getPosition()).isLessThanOrEqualTo(tryNum);
	}
}
