package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

import racingcar.util.generator.RandomNumberGenerator;

public class Cars {
	private static final String DUPLICATE_CAR_NAME_MESSAGE = "자동차의 이름은 중복일 수 없습니다.";
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
		validateDuplicateCarNames(cars);
	}

	private void validateDuplicateCarNames(List<Car> cars) {
		List<String> uniqueNames = cars.stream()
			.map(Car::getName)
			.distinct()
			.collect(toList());
		if (cars.size() != uniqueNames.size()) {
			throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
		}
	}

	public List<Car> getCars() {
		return List.copyOf(cars);
	}

	public void moveForward() {
		for (Car car : cars) {
			car.moveForward(new RandomNumberGenerator());
		}
	}

	public List<String> findWinnersName() {
		return cars.stream()
			.filter(car -> car.isWinner(findMaxPosition()))
			.map(Car::getName)
			.collect(toList());
	}

	private int findMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}
}
