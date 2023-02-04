package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.Racing;

public class CarRacingService {

    private static final CarRacingService INSTANCE = new CarRacingService();

    private CarRacingService() {
    }

    public static CarRacingService getInstance() {
        return INSTANCE;
    }

    public void carRacingGame(Cars cars, int raceGameCount,
        MovingStrategy movingStrategy) {
        Racing racing = new Racing(cars, raceGameCount);
        racing.race(movingStrategy);
    }
}
