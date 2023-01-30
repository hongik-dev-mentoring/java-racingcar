package racingcar.model;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.validator.NameValidator;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public void addCarNames(List<String> cars) {
		NameValidator.validateCarNames(cars);
		for (String carName : cars) {
			this.cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return List.copyOf(cars);
	}

	public void moveForward() {
		for (Car car : cars) {
			int randomNumber = RandomNumberGenerator.generateRandomNumber();
			car.moveForward(randomNumber);
		}
	}

	public int findMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	public List<String> findWinnersName() {
		return cars.stream()
			.filter(car -> car.isWinner(findMaxPosition()))
			.map(Car::getName)
			.collect(toList());
	}
}
