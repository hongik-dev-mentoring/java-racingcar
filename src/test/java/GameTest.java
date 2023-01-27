import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {


	@Test
	@DisplayName("입력받고 Car객체 배열 생성")
	void createCars() {
		//given
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("nae", "tae", "joe"));
		int num = carNames.size();

		//when
		List<Car> cars = Game.createCars(carNames);

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
		Car tae = new Car("tae");
		tae.setWinNum(1);
		Car joe = new Car("joe");
		joe.setWinNum(3);
		Car na = new Car("na");
		na.setWinNum(2);

		ArrayList<Car> cars = new ArrayList<>();

		cars.add(tae);
		cars.add(joe);
		cars.add(na);
		//when
		List<Car> result = Game.rankFinal(cars);

		assertAll(
			()-> assertThat(result.get(0).getName()).isEqualTo("joe"),
			()-> assertThat(result.get(1).getName()).isEqualTo("na"),
			()-> assertThat(result.get(2).getName()).isEqualTo("tae")
		);
	}

	@Test
	@DisplayName("포지션을 기준으로 정렬한다.")
	void rankRound() {
		//given
		Car tae = new Car("tae");
		tae.setPosition(1);
		Car joe = new Car("joe");
		joe.setPosition(3);
		Car na = new Car("na");
		na.setPosition(2);

		ArrayList<Car> cars = new ArrayList<>();

		cars.add(tae);
		cars.add(joe);
		cars.add(na);
		//when
		List<Car> result = Game.rankRound(cars);

		assertAll(
			()-> assertThat(result.get(0).getName()).isEqualTo("joe"),
			()-> assertThat(result.get(1).getName()).isEqualTo("na"),
			()-> assertThat(result.get(2).getName()).isEqualTo("tae")
		);
	}

	@Test
	@DisplayName("최종 winNum 동점시 2명을 승자를 뽑는다")
	void selectFinalWinner() {
		Car tae = new Car("tae");
		tae.setWinNum(4);
		Car joe = new Car("joe");
		joe.setWinNum(4);
		Car na = new Car("na");
		na.setWinNum(2);

		List<Car> sortedCars = new ArrayList<>();

		sortedCars.add(tae);
		sortedCars.add(joe);
		sortedCars.add(na);

		List<Car> winner = Game.selectFinalWinner(sortedCars);

		assertAll(
			() -> assertThat(winner.get(0).getName()).isEqualTo(tae.getName()),
			() -> assertThat(winner.get(1).getName()).isEqualTo(joe.getName())
		);

	}

	@Test
	@DisplayName("라운드에서 경주 동점시 2명을 승자를 뽑는다")
	void selectRoundWinner() {
		Car tae = new Car("tae");
		tae.setPosition(4);
		Car joe = new Car("joe");
		joe.setPosition(4);
		Car na = new Car("na");
		na.setPosition(2);

		List<Car> sortedCars = new ArrayList<>();

		sortedCars.add(tae);
		sortedCars.add(joe);
		sortedCars.add(na);

		List<Car> winner = Game.selectRoundWinner(sortedCars);

		assertAll(
			() -> assertThat(winner.get(0).getName()).isEqualTo(tae.getName()),
			() -> assertThat(winner.get(1).getName()).isEqualTo(joe.getName())
		);

	}

	@Test
	@DisplayName("승자의 winNum 을 1증가한다.")
	void recordWinNum(){
		//given
		Car tae = new Car("tae");
		tae.setPosition(4);
		Car joe = new Car("joe");
		joe.setPosition(4);
		Car na = new Car("na");
		na.setPosition(2);

		ArrayList<Car> cars = new ArrayList<>();

		cars.add(tae);
		cars.add(joe);
		cars.add(na);

		List<Car> roundWinner = Game.selectRoundWinner(Game.rankRound(cars));
		//when
		Game.recordWinNum(roundWinner);
		//then
		assertAll(
			()->assertThat(tae.getWinNum()).isEqualTo(1),
			()->assertThat(joe.getWinNum()).isEqualTo(1),
			()->assertThat(na.getWinNum()).isEqualTo(0)
		);
	}
}