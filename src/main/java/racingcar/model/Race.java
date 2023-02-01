package racingcar.model;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {

    private final List<Car> cars;

    private final Integer moveCount;

    public Race(List<Car> cars, Integer moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void proceedWholeRound() {
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

    public List<Car> selectWinners() {
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
}
