package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.util.generator.ForwardNumberGenerator;

class CarsTest {
	private final Cars cars = new Cars(List.of(new Car("chan"), new Car("dong")));
	private Car car1;
	private Car car2;

	@BeforeEach
	void initialize() {
		List<Car> cars = this.cars.getCars(); // return immutable list
		car1 = cars.get(0);
		car2 = cars.get(1);
	}
	
	@Test
	@DisplayName("자동차 게임 단독 우승자 찾기")
	void find_winner() {
		for (int i = 0; i < 3; ++i) {
			car1.moveForward(new ForwardNumberGenerator());
		}

		List<String> winners = cars.findWinnersName();

		assertThat(winners.get(0)).isEqualTo("chan");
	}

	@Test
	@DisplayName("자동차 게임 공동 우승자 찾기")
	void find_winners() {
		for (int i = 0; i < 3; ++i) {
			car1.moveForward(new ForwardNumberGenerator());
			car2.moveForward(new ForwardNumberGenerator());
		}

		List<String> winners = cars.findWinnersName();

		assertThat(winners.size()).isEqualTo(2);
	}
}
