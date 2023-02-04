package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.domain.MoveCount;
import racingcar.domain.Race;
import racingcar.view.InputProcess;

import static racingcar.view.OutputProcess.*;

public class RaceController {
    private final CarList carList;
    private final MoveCount moveCount;
    private final Race race;

    public RaceController() {
        InputProcess inputProcess = new InputProcess();
        carList = inputProcess.getCarList();
        moveCount = inputProcess.getMoveCount();
        race = new Race(carList);
    }

    public void startRace() {
        printResultHeader();
        for (int i = 0; i < moveCount.getNumber(); i++) {
            race.proceedOneRound();
            printCarPositions(carList);
            printNewLine();
        }
    }

    public void printWinners() {
        CarList winners = race.selectWinners();
        printFinalResult(winners);
    }

}
