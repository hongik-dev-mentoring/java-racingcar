package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.Racing;
import racingcar.domain.Car;
import racingcar.view.CarNamesList;

public class CarRacingService {

    private static final CarRacingService INSTANCE = new CarRacingService();

    private CarRacingService() {
    }

    public static CarRacingService getInstance() {
        return INSTANCE;
    }

    public void carRacingGame(CarNamesList carNamesList, int raceGameCount,
        MovingStrategy movingStrategy) {
        List<Car> cars = getCars(carNamesList);
        Racing racing = new Racing(cars, raceGameCount);
        racing.race(movingStrategy);
    }

    private List<Car> getCars(List<String> carNamesList) {
        return carNamesList.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }
}
