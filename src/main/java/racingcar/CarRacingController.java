package racingcar;

import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.movingstrategy.RandomMovingStrategy;
import racingcar.domain.movingstrategy.RangedRandomNumberPicker;
import racingcar.view.CarNames;
import racingcar.view.Input;

public class CarRacingController {

    private CarRacingController() {
        throw new AssertionError();
    }

    public static void initCarRacingGame() {
        Input input = new Input();
        CarNames carNames = input.getCarNames();
        int raceGameCount = input.getRacingGameCount();

        MovingStrategy movingStrategy = getRandomMovingStrategy();
        CarRacingService.getInstance()
            .carRacingGame(carNames, raceGameCount, movingStrategy);
    }

    private static MovingStrategy getRandomMovingStrategy() {
        final int movingStandard = 4;
        final int FROM = 0;
        final int TO = 0;

        RangedRandomNumberPicker rangedRandomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        return new RandomMovingStrategy(rangedRandomNumberPicker, movingStandard);
    }
}
