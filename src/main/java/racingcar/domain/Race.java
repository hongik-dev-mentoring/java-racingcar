package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {
    private final CarList carList;

    public Race(CarList carList) {
        this.carList = carList;
    }

    public void proceedOneRound() {
        for (Car car : carList.getCars()) {
            car.move();
        }
    }

    public CarList selectWinners() {
        Integer maxPosition = getMaxPosition(carList);
        return getCarsAtPosition(carList, maxPosition);
    }

    private Integer getMaxPosition(CarList carList) {
        return carList.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private CarList getCarsAtPosition(CarList carList, Integer maxPosition) {
        List<Car> cars = carList.getCars()
                .stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .collect(Collectors.toList());
        return new CarList(cars);
    }
}
