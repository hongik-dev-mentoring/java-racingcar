package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private List<Car> cars;
	private final int tryNum;
	private int countEnd = 0;

	public RacingGame(ArrayList<String> carNames, int tryNum) {
		cars = createCars(carNames);
		this.tryNum = tryNum;
	}

	public boolean isEnd() {
		if (countEnd == tryNum) {
			return true;
		}
		countEnd++;
		return false;
	}

	public List<Car> createCars(ArrayList<String> carNames) {
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public void race() {
		cars.forEach(Car::move);
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> getWinners() {
		return selectFinalWinner(rankFinal(cars));
	}

	public List<Car> selectFinalWinner(List<Car> carRanking) {
		int maxPosition = carRanking.get(0).getPosition();

		return carRanking.stream()
			.filter((car) -> car.isSamePosition(maxPosition))
			.collect(Collectors.toList());
	}

	public List<Car> rankFinal(List<Car> cars) {
		return cars.stream()
			.sorted(Comparator.comparing(Car::getPosition).reversed())
			.collect(Collectors.toList());
	}
}
