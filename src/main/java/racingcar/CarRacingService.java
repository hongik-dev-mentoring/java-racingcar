package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.Racing;
import racingcar.view.CarNames;

public class CarRacingService {

    private static final CarRacingService INSTANCE = new CarRacingService();

    private CarRacingService() {
    }

    public static CarRacingService getInstance() {
        return INSTANCE;
    }

    public void carRacingGame(CarNames carNames, int raceGameCount,
        MovingStrategy movingStrategy) {
        Cars cars = carNames.createCars();
        Racing racing = new Racing(cars, raceGameCount);
        racing.race(movingStrategy);
    }
}
