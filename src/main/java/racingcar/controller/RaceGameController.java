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
		// 자동차 경주 게임 시작
		moveCarsForwardByAttemptNumber();
	}

	public void announceWinner() {
		// 자동차 경주 게임 최종 우승자 발표
		OutputData.printWinners(cars);
	}

	private static void printResultHeader() {
		OutputData.printBlankLine();
		OutputData.printGameResultHeader();
	}

	private void moveCarsForwardByAttemptNumber() {
		for (int i = 0; i < attemptNumber; ++i) {
			cars.moveForward();
			OutputData.printCarsPosition(cars.getCars());
		}
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
}
