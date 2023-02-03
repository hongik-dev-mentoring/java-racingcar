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

        RangedRandomNumberPicker rangedRandomNumberPicker = new RangedRandomNumberPicker(0, 9);
        int movingStandard = 4;
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy(rangedRandomNumberPicker,
            movingStandard);

        CarRacingService.getInstance()
            .carRacingGame(carNamesList, raceGameCount, randomMovingStrategy);
    }
}
