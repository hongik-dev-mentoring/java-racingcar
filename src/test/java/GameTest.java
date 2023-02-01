import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	Game game;

	@BeforeEach
	void setup() {
		game = new Game();
	}

	@Test
	@DisplayName("입력받고 Car객체 배열 생성")
	void createCars() {
		//given
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("nae", "tae", "joe"));
		int num = carNames.size();

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
	@DisplayName("승수를 기준으로 정렬한다.")
	void rankFinal() {
		//given
		List<Car> cars = game.createCars(new ArrayList<>(Arrays.asList("na", "tae", "joe")));
		for (int i = 0; i < 3; i++) {
			game.race(cars, 3);
			game.recordWinNum(game.selectRoundWinner(game.rankRound(cars)));
		}
		//when
		List<Car> result = game.rankFinal(cars);

		assertThat(result.get(0).getWinNum()).isGreaterThanOrEqualTo(result.get(1).getWinNum());
	}

	@Test
	@DisplayName("포지션을 기준으로 정렬한다.")
	void rankRound() {
		//given
		List<Car> cars = game.createCars(new ArrayList<>(Arrays.asList("na", "tae", "joe")));
		game.race(cars, 5);

		//when
		List<Car> result = game.rankRound(cars);

		assertThat(result.get(0).getWinNum()).isGreaterThanOrEqualTo(result.get(1).getWinNum());
	}

	@Test
	@DisplayName("최종 winNum 동점시 2명을 승자를 뽑는다")
	void selectFinalWinner() {
		//given
		List<Car> cars = game.createCars(new ArrayList<>(Arrays.asList("na", "tae", "joe")));
		for (int i = 0; i < 3; i++) {
			game.race(cars, 3);
			game.recordWinNum(game.selectRoundWinner(game.rankRound(cars)));
		}
		//when
		List<Car> winner = game.selectFinalWinner(game.rankFinal(cars));

		assertThat(winner.size()).isEqualTo(
			cars.stream().filter(m -> m.getWinNum() == winner.get(0).getWinNum()).count());
	}

	@Test
	@DisplayName("라운드에서 경주 동점시 2명을 승자를 뽑는다")
	void selectRoundWinner() {
		//given
		List<Car> cars = game.createCars(new ArrayList<>(Arrays.asList("na", "tae", "joe")));

		game.race(cars, 3);

		//when
		List<Car> winner = game.selectRoundWinner(game.rankRound(cars));

		assertThat(winner.size()).isEqualTo(
			cars.stream().filter(m -> m.getPosition() == winner.get(0).getPosition()).count());
	}
}
