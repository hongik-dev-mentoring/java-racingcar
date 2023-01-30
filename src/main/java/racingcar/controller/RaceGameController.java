package racingcar.controller;

import java.util.List;

import racingcar.model.Cars;
import racingcar.util.generator.NameGenerator;
import racingcar.util.generator.NumberGenerator;
import racingcar.view.InputData;
import racingcar.view.OutputData;

public class RaceGameController {
	private Cars cars;
	private int attemptNumber;

	public void ready() {
		cars = new Cars();
		addCarNamesToCars();
		attemptNumber = getAttemptNumber();
		printResultHeader();
	}

	private void addCarNamesToCars() {
		try {
			List<String> carNames = NameGenerator.generateCarNames(InputData.getCarNames());
			cars.addCarNames(carNames);
		} catch (IllegalArgumentException e) {
			OutputData.printErrorMessage(e.getMessage()); // [ERROR] + 메시지 출력
			addCarNamesToCars();
		}
	}

	private int getAttemptNumber() {
		try {
			return NumberGenerator.generateNumber(InputData.getAttemptNumber());
		} catch (IllegalArgumentException e) {
			OutputData.printErrorMessage(e.getMessage());
			return getAttemptNumber();
		}
	}

	private static void printResultHeader() {
		OutputData.printBlankLine();
		OutputData.printGameResultHeader();
	}

	public void run() {
		moveCarsForwardByAttemptNumber();
	}

	private void moveCarsForwardByAttemptNumber() {
		for (int i = 0; i < attemptNumber; ++i) {
			cars.moveForward();
			OutputData.printCarsPosition(cars.getCars());
		}
	}

	public void announceWinner() {
		OutputData.printWinners(cars);
	}
}
