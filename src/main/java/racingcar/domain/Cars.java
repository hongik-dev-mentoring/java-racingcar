package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars;
    }

    public int getLeadCarPosition() {
        Car leadCar = cars.stream()
            .max(Comparator.comparing(Car::getPosition))
            .get();
        return leadCar.getPosition();
    }

    public List<String> getCarsByPosition(int position) {
        return cars.stream()
            .filter(car -> car.getPosition() == position)
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
