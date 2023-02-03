package racingcar.domain.movingstrategy;

public class RandomMovingStrategy implements MovingStrategy {

    private final RangedRandomNumberPicker randomNumberPicker;
    private final int movingStandard;

    public RandomMovingStrategy(RangedRandomNumberPicker randomNumberPicker, int movingStandard) {
        this.randomNumberPicker = randomNumberPicker;
        this.movingStandard = movingStandard;
    }

    @Override
    public boolean isPossibleMoveForward() {
        int randomNumber = randomNumberPicker.pickRandomNumber();
        return randomNumber >= movingStandard;
    }
}
