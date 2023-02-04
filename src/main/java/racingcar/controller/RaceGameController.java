package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.generator.NameGenerator;
import racingcar.util.generator.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
	private Cars cars;
	private int attemptNumber;

	public void ready() {
		cars = createCars();
		attemptNumber = getAttemptNumber();
		printResultHeader();
	}

	private Cars createCars() {
		try {
			return new Cars(addCars());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return createCars();
		}
	}

	private List<Car> addCars() {
		List<String> carNames = NameGenerator.generateCarNames(InputView.getCarNames());
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	private int getAttemptNumber() {
		try {
			return NumberGenerator.generateNumber(InputView.getAttemptNumber());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getAttemptNumber();
		}
	}

	private void printResultHeader() {
		OutputView.printBlankLine();
		OutputView.printGameResultHeader();
	}

	public void run() {
		moveCarsForwardByAttemptNumber();
	}

	private void moveCarsForwardByAttemptNumber() {
		for (int i = 0; i < attemptNumber; ++i) {
			cars.moveForward();
			OutputView.printCarsPosition(cars.getCars());
		}
	}

	public void announceWinner() {
		OutputView.printWinners(cars);
	}
}
