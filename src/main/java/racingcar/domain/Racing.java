package racingcar.domain;

import java.util.List;
import racingcar.domain.movingstrategy.MovingStrategy;

public class Racing {

    private final Cars cars;
    private int gameCount;

    public Racing(Cars cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void raceAllCar(MovingStrategy movingStrategy) {
        gameCount--;
        cars.getCars()
            .forEach(car -> car.race(movingStrategy));
    }

    public boolean isLeftRacing() {
        return gameCount > 0;
    }

    public Cars getCars() {
        return cars;
    }

    public List<String> getWinnersName() {
        int leadCarPosition = cars.getLeadCarPosition();
        return cars.getCarsByPosition(leadCarPosition);
    }
}
