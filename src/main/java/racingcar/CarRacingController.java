package racingcar;

import java.util.List;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.movingstrategy.RandomMovingStrategy;
import racingcar.domain.movingstrategy.RangedRandomNumberPicker;
import racingcar.view.Input;

public class CarRacingController {

    private CarRacingController() {
        throw new AssertionError();
    }

    public static void initCarRacingGame() {
        Input input = new Input();
        List<String> carNamesList = input.getCarNamesList();
        int raceGameCount = input.getRacingGameCount();

        MovingStrategy movingStrategy = getRandomMovingStrategy();
        CarRacingService.getInstance()
            .carRacingGame(carNamesList, raceGameCount, movingStrategy);
    }

    private static MovingStrategy getRandomMovingStrategy() {
        final int movingStandard = 4;
        final int FROM = 0;
        final int TO = 0;

        RangedRandomNumberPicker rangedRandomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        return new RandomMovingStrategy(rangedRandomNumberPicker, movingStandard);
    }
}
