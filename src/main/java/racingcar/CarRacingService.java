package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.Racing;
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
        Cars cars = Cars.getCarsFromCarNamesList(carNamesList);
        Racing racing = new Racing(cars, raceGameCount);
        racing.race(movingStrategy);
    }
}
