package racingcar.view;

import java.util.List;
import racingcar.CarRacingController.CarDto;
import racingcar.CarRacingController.CarsDto;

public class CarRacingResultView {

    public static void printCurrentRaceResult(CarsDto cars) {
        List<CarDto> carList = cars.getCars();
        carList.forEach(car -> System.out.println(buildCurrentPositionString(car)));
        System.out.println();
    }

    private static StringBuilder buildCurrentPositionString(CarDto car) {
        return new StringBuilder(car.getName())
            .append(" : ")
            .append("-".repeat(car.getPosition()));
    }

    public static void printRacingGameWinner(List<String> winners) {
        String winnerString = new StringBuilder("최종 우승자 : ")
            .append(String.join(", ", winners))
            .toString();
        System.out.println(winnerString);
    }
}
