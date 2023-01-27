package racingcar.model;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.util.validator.NameValidator;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public void add(List<String> cars) {
		NameValidator.validateCarNames(cars.toString());
		for (String carName : cars) {
			this.cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return cars.stream()
			.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	public void moveForward(int randomNumber) {

		for (Car car : cars) {
			car.moveForward(randomNumber);
		}
	}

	public int findMaxPosition() {
		return 0;
	}
}
