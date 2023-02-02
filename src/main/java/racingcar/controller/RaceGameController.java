package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

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
		cars = new Cars(createCars());
		attemptNumber = getAttemptNumber();
		printResultHeader();
	}

	private List<Car> createCars() {
		List<String> carNames = NameGenerator.generateCarNames(InputView.getCarNames());
		List<Car> cars = new ArrayList<>();
		try {
			for (String carName : carNames) {
				Car car = new Car(carName);
				cars.add(car);
			}
		} catch (Exception e) {
			OutputView.printErrorMessage(e.getMessage());
			return createCars();
		}
		return cars;
	}

	private int getAttemptNumber() {
		try {
			return NumberGenerator.generateNumber(InputView.getAttemptNumber());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getAttemptNumber();
		}
	}

	private static void printResultHeader() {
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
