package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;

public class CarRacingResultView {

    static public void printCurrentRaceResult(Racing racing) {
        Cars cars = racing.getCars();
        cars.getCars()
            .forEach(car -> System.out.println(buildCurrentPositionString(car)));
        System.out.println();
    }

    static private StringBuilder buildCurrentPositionString(Car car) {
        return new StringBuilder(car.getName())
            .append(" : ")
            .append("-".repeat(car.getPosition()));
    }

    static public void printRacingGameWinner(Racing racing) {
        Cars cars = racing.getCars();
        int leadCarPosition = cars.getLeadCarPosition();
        String winnerString = buildWinnerString(cars, leadCarPosition).toString();
        System.out.println(winnerString);
    }

    static private StringBuilder buildWinnerString(Cars cars, int leadCarPosition) {
        List<String> winners = cars.getCarsByPosition(leadCarPosition);

        return new StringBuilder("최종 우승자 : ")
            .append(String.join(", ", winners));
    }
}
