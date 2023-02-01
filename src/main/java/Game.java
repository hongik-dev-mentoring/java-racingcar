import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
	private List<Car> cars;

	public List<Car> createCars(ArrayList<String> carNames) {
		return carNames.stream().map(Car::new).collect(Collectors.toList());
	}

	public void play() {
		ArrayList<String> carNames = Input.readNames();
		final int TRY_NUM = Input.readNum();
		cars = createCars(carNames);

		for (int i = 0; i < TRY_NUM; i++) {
			race(cars, TRY_NUM);
			recordWinNum(selectRoundWinner(rankRound(cars)));
		}
		Output.printWinner(selectFinalWinner(rankFinal(cars)));
	}

	public void race(List<Car> cars, int TRY_NUM) {
		cars.forEach(m -> m.race(TRY_NUM));
		System.out.println();
	}

	public void recordWinNum(List<Car> winner) {
		winner.forEach(Car::increaseWinNum);
	}

	public List<Car> selectRoundWinner(List<Car> carRanking) {
		int maxPosition = carRanking.get(0).getPosition();

		return carRanking.stream()
			.filter((m) -> m.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	public List<Car> selectFinalWinner(List<Car> carRanking) {
		int maxWin = carRanking.get(0).getWinNum();

		return carRanking.stream()
			.filter((m) -> m.getWinNum() == maxWin)
			.collect(Collectors.toList());
	}

	public List<Car> rankRound(List<Car> cars) {
		return cars.stream()
			.sorted(Comparator.comparing(Car::getPosition).reversed())
			.collect(Collectors.toList());
	}

	public List<Car> rankFinal(List<Car> cars) {
		return cars.stream()
			.sorted(Comparator.comparing(Car::getWinNum).reversed())
			.collect(Collectors.toList());
	}
}
