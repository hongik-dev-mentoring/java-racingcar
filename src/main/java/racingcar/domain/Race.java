package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void proceedOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> selectWinners() {
        Integer maxPosition = getMaxPosition(cars);
        return getCarsAtPosition(cars, maxPosition);
    }

    private Integer getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private List<Car> getCarsAtPosition(List<Car> cars, Integer maxPosition) {
        return cars.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .collect(Collectors.toList());
    }
}
