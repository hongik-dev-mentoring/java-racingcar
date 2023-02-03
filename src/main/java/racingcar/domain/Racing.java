package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.movingstrategy.MovingStrategy;

public class Racing {

    private final List<Car> cars;
    private int gameCount;

    public Racing(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void race(MovingStrategy movingStrategy) {
        System.out.println("실행 결과");
        while (isLeftRacing()) {
            gameCount--;
            raceAllCar(movingStrategy);
            printCurrentRaceResult();
        }
        printWinner();
    }

    private boolean isLeftRacing() {
        return gameCount > 0;
    }

    private void raceAllCar(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.race(movingStrategy));
    }

    private void printCurrentRaceResult() {
        cars.forEach(
            car -> System.out.println(buildCurrentPositionString(car)));
        System.out.println();
    }

    private int getLeadCarPosition() {
        Car leadCar = cars.stream()
            .max(Comparator.comparing(Car::getPosition))
            .get();
        return leadCar.getPosition();
    }

    private void printWinner() {
        int leadCarPosition = getLeadCarPosition();
        String winnerString = buildWinnderString(leadCarPosition).toString();
        System.out.println(winnerString);
    }

    private StringBuilder buildWinnderString(int leadCarPosition) {
        List<String> winners = cars.stream()
            .filter(car -> car.getPosition() == leadCarPosition)
            .map(Car::getName)
            .collect(Collectors.toList());

        return new StringBuilder("최종 우승자 : ")
            .append(String.join(", ", winners));
    }

    private StringBuilder buildCurrentPositionString(Car car) {

        return new StringBuilder(car.getName())
            .append(" : ")
            .append("-".repeat(car.getPosition()));
    }
}
