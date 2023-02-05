package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;

public class CarRacingResultView {

    static public void printCurrentRaceResult(Racing racing) {
        Cars cars = racing.getCars();
        cars.getCarList()
            .forEach(car -> System.out.println(buildCurrentPositionString(car)));
        System.out.println();
    }

    static private StringBuilder buildCurrentPositionString(Car car) {
        return new StringBuilder(car.getName())
            .append(" : ")
            .append("-".repeat(car.getPosition()));
    }
}
