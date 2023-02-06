package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.domain.MoveCount;
import racingcar.domain.Race;
import racingcar.view.InputProcess;

import static racingcar.view.OutputProcess.*;

public class RaceController {
    private Race race;

    public void completeRace() {
        prepareRace();
        startRace();
        printWinners();
    }

    private void prepareRace() {
        InputProcess inputProcess = new InputProcess();
        CarList racingCarList = inputProcess.getCarList();
        MoveCount moveCount = inputProcess.getMoveCount();
        race = new Race(racingCarList, moveCount);
    }

    private void startRace() {
        printResultHeader();
        while (!race.isEnd()) {
            race.proceedOneRound();
            printCarPositions(race.getRacingCars());
            printNewLine();
        }
    }

    private void printWinners() {
        CarList winners = race.selectWinners();
        printFinalResult(winners);
    }
}
