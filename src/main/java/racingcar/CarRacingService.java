package racingcar;

import static racingcar.view.CarRacingResultView.printCurrentRaceResult;
import static racingcar.view.CarRacingResultView.printRacingGameWinner;

import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.Racing;

public class CarRacingService {

    private static final CarRacingService INSTANCE = new CarRacingService();

    private CarRacingService() {
    }

    public static CarRacingService getInstance() {
        return INSTANCE;
    }

    public void carRacingGame(Racing racing, int raceGameCount,
        MovingStrategy movingStrategy) {
        System.out.println("실행 결과");
        while  (racing.isLeftRacing()) {
            racing.raceAllCar(movingStrategy);
            printCurrentRaceResult(racing);
        }
        printRacingGameWinner(racing);
    }
}
