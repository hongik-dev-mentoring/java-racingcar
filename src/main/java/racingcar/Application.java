package racingcar;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputProcess;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputProcess inputProcess = new InputProcess();
        List<Car> cars = inputProcess.getCarList();
        Integer moveCount = inputProcess.getMoveCount();

        Race race = new Race(cars, moveCount);
        race.start();
        race.printWinners();
    }
}
