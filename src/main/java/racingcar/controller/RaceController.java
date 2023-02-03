package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.InputProcess;
import racingcar.view.OutputProcess;

import java.util.List;

public class RaceController {
    private final Race race;
    private final OutputProcess outputProcess;
    private final Integer moveCount;

    public RaceController() {
        InputProcess inputProcess = new InputProcess();
        List<Car> cars = inputProcess.getCarList();
        moveCount = inputProcess.getMoveCount();
        outputProcess = new OutputProcess(cars);
        race = new Race(cars);
    }

    public void startRace() {
        outputProcess.printResultHeader();
        for (int i = 0; i < moveCount; i++) {
            race.proceedOneRound();
            outputProcess.printCarPositions();
            outputProcess.printNewLine();
        }
    }

    public void printWinners() {
        List<Car> winners = race.selectWinners();
        outputProcess.createFinalResultText(winners);
    }

}
