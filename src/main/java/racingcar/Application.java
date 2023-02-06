package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.CarList;
import racingcar.domain.MoveCount;
import racingcar.domain.Race;
import racingcar.view.InputProcess;

public class Application {
    public static void main(String[] args) {
        InputProcess inputProcess = new InputProcess();
        CarList racingCarList = inputProcess.getCarList();
        MoveCount moveCount = inputProcess.getMoveCount();

        RaceController raceController = new RaceController(new Race(racingCarList, moveCount));
        raceController.completeRace();
    }
}
