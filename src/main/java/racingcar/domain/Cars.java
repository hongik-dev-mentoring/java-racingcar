package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.view.CarNamesList;

public class Cars {

    private final List<Car> cars;

    private Cars(CarNamesList carNamesList) {
        cars = carNamesList.getCarNamesList()
            .stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public static Cars getCarsFromCarNamesList(CarNamesList carNamesList) {
        return new Cars(carNamesList);
    }

    public void raceAllCar(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.race(movingStrategy));
    }

    public void printCurrentRaceResult() {
        cars.forEach(car -> System.out.println(buildCurrentPositionString(car)));
        System.out.println();
    }

    private StringBuilder buildCurrentPositionString(Car car) {

        return new StringBuilder(car.getName())
            .append(" : ")
            .append("-".repeat(car.getPosition()));
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
