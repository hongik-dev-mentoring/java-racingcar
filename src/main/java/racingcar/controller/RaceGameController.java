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

	public void run() {

	}

	public void announceWinner() {

	}

	private static void printResultHeader() {
		OutputData.printBlankLine();
		OutputData.printGameResultHeader();
	}

	private void addCarNamesToCars() {
		try {
			List<String> carNames = NameGenerator.generateCarNames(InputData.getCarNames());
			cars.add(carNames);
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
}
