package racingcar.controller;

import java.util.ArrayList;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {
	public static void main(String[] args) {
		ArrayList<String> carNames = InputView.readNames();
		int tryNum = InputView.readNum();

		RacingGame game = new RacingGame(carNames,tryNum);
		game.play();
	}
}
