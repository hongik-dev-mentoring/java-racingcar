package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	private final Cars cars = new Cars();
	private Car car1;
	private Car car2;

	@BeforeEach
	void initialize() {
		cars.addCarNames(Arrays.asList("chan", "dong", "ho"));
		List<Car> cars = this.cars.getCars(); // return immutable list
		car1 = cars.get(0);
		car2 = cars.get(1);
	}

	@Test
	@DisplayName("가장 멀리 간 위치 찾기")
	void max_position() {
		for (int i = 0; i < 3; ++i) {
			car1.moveForward(5);
		}

		assertThat(cars.findMaxPosition()).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차 게임 단독 우승자 찾기")
	void find_winner() {
		for (int i = 0; i < 3; ++i) {
			car1.moveForward(5);
		}

		List<String> winners = cars.findWinnersName();

		assertThat(winners.get(0)).isEqualTo("chan");
	}

	@Test
	@DisplayName("자동차 게임 공동 우승자 찾기")
	void find_winners() {
		for (int i = 0; i < 3; ++i) {
			car1.moveForward(5);
			car2.moveForward(5);
		}

		List<String> winners = cars.findWinnersName();

		assertThat(winners.size()).isEqualTo(2);
	}
}
