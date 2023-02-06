package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.domain.Race;

import static racingcar.view.OutputProcess.*;

public class RaceController {
    private final Race race;

    public RaceController(Race race) {
        this.race = race;
    }

    public void completeRace() {
        startRace();
        printWinners();
    }

    private void startRace() {
        printResultHeader();
        while (!race.isEnd()) {
            race.proceedOneRound();
            printCarPositions(race.getRacingCarList());
            printNewLine();
        }
    }

    private void printWinners() {
        CarList winners = race.selectWinners();
        printFinalResult(winners);
    }
}
