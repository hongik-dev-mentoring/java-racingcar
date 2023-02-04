package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	RacingGame game;
	final ArrayList<String> NAMES = new ArrayList<>(Arrays.asList("na", "tae", "joe"));

	@BeforeEach
	void setup() {
		game = new RacingGame(NAMES);
	}

	@Test
	@DisplayName("입력받고 Car객체 배열 생성")
	void createCars() {
		//given
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("nae", "tae", "joe"));

		//when
		List<Car> cars = game.createCars(carNames);

		//then
		assertAll(
			() -> assertThat(cars.get(0).getName()).isEqualTo("nae"),
			() -> assertThat(cars.get(1).getName()).isEqualTo("tae"),
			() -> assertThat(cars.get(2).getName()).isEqualTo("joe")
		);

	}

	@Test
	@DisplayName("최종 position을 기준으로 승자 정렬.")
	void rankFinal() {
		//given
		List<Car> cars = game.createCars(new ArrayList<>(Arrays.asList("na", "tae", "joe")));
		game.race();

		//when
		List<Car> result = game.rankFinal(cars);

		assertThat(result.get(0).getPosition()).isGreaterThanOrEqualTo(result.get(1).getPosition());
	}

	@Test
	@DisplayName("최종 우승자가 여러명이면 공동우승자를 뽑는다")
	void selectFinalWinner() {
		//given
		List<Car> cars = game.createCars(new ArrayList<>(Arrays.asList("na", "tae", "joe")));
		for (int i = 0; i < 3; i++) {
			game.race();
		}
		//when
		List<Car> winner = game.selectFinalWinner(game.rankFinal(cars));

		assertThat(winner.size()).isEqualTo(
			cars.stream().filter(m -> m.getPosition() == winner.get(0).getPosition()).count());
	}

}
