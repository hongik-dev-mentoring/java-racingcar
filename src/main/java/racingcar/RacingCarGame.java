package racingcar;

import racingcar.controller.RaceGameController;

public class RacingCarGame {
	public static void main(String[] args) {
		RaceGameController raceGameController = new RaceGameController();
		raceGameController.ready();
		raceGameController.run();
		raceGameController.announceWinner();
	}
}
