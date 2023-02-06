package racingcar.domain;

import racingcar.view.OutputView;

public class Racing {
	private final Cars cars;
	private final AttemptNumber attemptNumber;

	public Racing(Cars cars, AttemptNumber attemptNumber) {
		this.cars = cars;
		this.attemptNumber = attemptNumber;
	}

	public void moveForward() {
		for (int i = 0; i < attemptNumber.getAttemptNumber(); ++i) {
			cars.moveForward();
			OutputView.printCarsPosition(cars.getCars());
		}
	}
}
