package racingcar.model;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public void add(List<String> cars) {

	}

	public List<Car> getCars() {
		return cars.stream()
			.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}
}
