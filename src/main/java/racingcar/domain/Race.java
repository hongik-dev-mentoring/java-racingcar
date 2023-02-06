package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {

    public static final int INITIAL_STATE = 0;

    private final CarList racingCarList;
    private final MoveCount moveCount;
    private int currentRoundNumber;

    public Race(CarList racingCarList, MoveCount moveCount) {
        this.racingCarList = racingCarList;
        this.moveCount = moveCount;
        this.currentRoundNumber = INITIAL_STATE;
    }

    public void proceedOneRound() {
        for (Car car : racingCarList.getCars()) {
            car.move();
        }
        currentRoundNumber++;
    }

    public CarList selectWinners() {
        Integer maxPosition = getMaxPosition(racingCarList);
        return getCarsAtPosition(racingCarList, maxPosition);
    }

    private Integer getMaxPosition(CarList racingCarList) {
        return racingCarList.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private CarList getCarsAtPosition(CarList racingCarList, Integer maxPosition) {
        List<Car> cars = racingCarList.getCars()
                .stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .collect(Collectors.toList());
        return new CarList(cars);
    }

    public CarList getRacingCarList() {
        return racingCarList;
    }

    public boolean isEnd() {
        return moveCount.getNumber() == currentRoundNumber;
    }
}
