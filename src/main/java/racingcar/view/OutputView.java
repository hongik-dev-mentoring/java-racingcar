package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String GAME_RESULT_HEADER = "실행 결과";
	private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

	public static void printErrorMessage(String message) {
		System.out.println(ERROR_MESSAGE + message);
	}

	public static void printGameResultHeader() {
		System.out.println(GAME_RESULT_HEADER);
	}

	public static void printCarsPosition(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName().getValue() + " : " + printCarsCurrentPosition(car.getPosition()));
		}
		printBlankLine();
	}

	private static StringBuilder printCarsCurrentPosition(int position) {
		StringBuilder builder = new StringBuilder();
		builder.append("-".repeat(Math.max(0, position)));
		return builder;
	}

	public static void printBlankLine() {
		System.out.println();
	}

	public static void printWinners(Cars cars) {
		List<String> winnersName = cars.findWinnersName();
		System.out.println(String.join(",", winnersName) + FINAL_WINNER_MESSAGE);
	}
}
