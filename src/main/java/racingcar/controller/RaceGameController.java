package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.util.convertor.NameConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
	private Cars cars;
	private AttemptNumber attemptNumber;

	public void ready() {
		cars = createCars();
		attemptNumber = new AttemptNumber(InputView.getAttemptNumber());
		OutputView.printBlankLine();
		OutputView.printGameResultHeader();
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
		List<String> carNames = NameConvertor.convertCarNames(InputView.getCarNames());
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public void run() {
		Racing racing = new Racing(cars, attemptNumber);
		racing.moveForward();
	}

	public void announceWinner() {
		OutputView.printWinners(cars);
	}
}
