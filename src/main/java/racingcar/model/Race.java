package racingcar.model;

import racingcar.view.InputProcess;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {

    private static final String COMMA_IN_RESULT_TEXT = ", ";
    private static final String RESULT_TEXT = "실행 결과";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    private List<racingcar.model.Car> cars;

    private Integer moveCount;

    private List<racingcar.model.Car> winners;

    public void start() {
        startInputProcess();
        System.out.println(RESULT_TEXT);
        for (int i = 0; i < moveCount; i++) {
            proceedOneRound();
            System.out.println();
        }
    }

    private void startInputProcess() {
        InputProcess input = new InputProcess();
        this.cars = input.getCarList();
        this.moveCount = input.getMoveCount();
    }

    private void proceedOneRound() {
        this.moveCars();
        this.printCarPositions();
    }

    private void moveCars() {
        for (racingcar.model.Car car : cars) {
            car.move();
        }
    }

    private void printCarPositions() {
        for (racingcar.model.Car car : cars) {
            car.printPosition();
        }
    }

    public void printWinners() {
        winners = selectWinners(cars);
        createFinalResultText();
    }

    private List<racingcar.model.Car> selectWinners(List<racingcar.model.Car> cars) {
        Integer maxPosition = getMaxPosition(cars);
        return getCarsAtPosition(cars, maxPosition);
    }

    private static Integer getMaxPosition(List<racingcar.model.Car> cars) {
        racingcar.model.Car winner = cars.stream()
                .max(Comparator.comparing(racingcar.model.Car::getPosition))
                .orElseThrow(NoSuchElementException::new);
        return winner.getPosition();
    }

    private static List<racingcar.model.Car> getCarsAtPosition(List<racingcar.model.Car> cars, Integer maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .collect(Collectors.toList());
    }

    private void createFinalResultText() {
        List<String> winnerNames = winners.stream()
                .map(racingcar.model.Car::getName)
                .collect(Collectors.toList());
        System.out.println(String.join(COMMA_IN_RESULT_TEXT, winnerNames) + WINNER_TEXT);
    }
}
