package racingcar.controller;

import java.util.ArrayList;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
	public static void main(String[] args) {
		ArrayList<String> carNames = InputView.readNames();
		int tryNum = InputView.readNum();

		RacingGame game = new RacingGame(carNames);
		for (int i = 0; i < tryNum; i++) {
			game.race();
			ResultView.printCars(game.getCars());
		}
		ResultView.printWinner(game.getWinners());
	}
}
