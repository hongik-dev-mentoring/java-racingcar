package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {

    public static final int INITIAL_STATE = 0;

    private final CarList racingCars;
    private final MoveCount moveCount;
    private int currentRoundNumber;

    public Race(CarList racingCars, MoveCount moveCount) {
        this.racingCars = racingCars;
        this.moveCount = moveCount;
        this.currentRoundNumber = INITIAL_STATE;
    }

    public void proceedOneRound() {
        for (Car car : racingCars.getCars()) {
            car.move();
        }
        currentRoundNumber++;
    }

    public CarList selectWinners() {
        Integer maxPosition = getMaxPosition(racingCars);
        return getCarsAtPosition(racingCars, maxPosition);
    }

    private Integer getMaxPosition(CarList racingCars) {
        return racingCars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private CarList getCarsAtPosition(CarList racingCars, Integer maxPosition) {
        List<Car> cars = racingCars.getCars()
                .stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .collect(Collectors.toList());
        return new CarList(cars);
    }

    public CarList getRacingCars() {
        return racingCars;
    }

    public boolean isEnd() {
        return moveCount.getNumber() == currentRoundNumber;
    }
}
