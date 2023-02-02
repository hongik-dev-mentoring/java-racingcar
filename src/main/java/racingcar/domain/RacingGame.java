package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private List<Car> cars;
	private final int TRY_NUM;
	private int countRound = 0;

	public RacingGame(ArrayList<String> carNames, int TRY_NUM) {
		cars = createCars(carNames);
		this.TRY_NUM = TRY_NUM;
	}

	public boolean isEnd(){
		if(countRound == TRY_NUM){
			return true;
		}
		countRound++;
		return false;
	}

	public List<Car> createCars(ArrayList<String> carNames) {
		return carNames.stream().map(Car::new).collect(Collectors.toList());
	}

	public void race() {
		cars.forEach(m -> m.race(TRY_NUM));
		recordWinNum(selectRoundWinner(rankRound(cars)));
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> getWinners(){
		return selectFinalWinner(rankFinal(cars));
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
