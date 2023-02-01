package racingcar.model;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {

    private static final String COMMA_IN_RESULT_TEXT = ", ";
    private static final String RESULT_TEXT = "실행 결과";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    private List<Car> cars;

    private Integer moveCount;

    private List<Car> winners;

    public Race(List<Car> cars, Integer moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void start() {
        System.out.println(RESULT_TEXT);
        for (int i = 0; i < moveCount; i++) {
            proceedOneRound();
            System.out.println();
        }
    }

    private void proceedOneRound() {
        this.moveCars();
        this.printCarPositions();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printCarPositions() {
        for (Car car : cars) {
            car.printPosition();
        }
    }

    public void printWinners() {
        winners = selectWinners(cars);
        createFinalResultText();
    }

    private List<Car> selectWinners(List<Car> cars) {
        Integer maxPosition = getMaxPosition(cars);
        return getCarsAtPosition(cars, maxPosition);
    }

    private static Integer getMaxPosition(List<Car> cars) {
        Car winner = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new);
        return winner.getPosition();
    }

    private static List<Car> getCarsAtPosition(List<Car> cars, Integer maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .collect(Collectors.toList());
    }

    private void createFinalResultText() {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(String.join(COMMA_IN_RESULT_TEXT, winnerNames) + WINNER_TEXT);
    }
}
