package racingcar;

public class RandomMovingCar {

    public static final int MOVING_STANDARD = 4;
    private final String name;
    private final RangedRandomNumberPicker randomNumberPicker;
    private int position = 0;

    public RandomMovingCar(String name, RangedRandomNumberPicker randomNumberPicker) {
        this.name = name;
        this.randomNumberPicker = randomNumberPicker;
    }

    public void race() {
        if (isPossibleMoveForward()) {
            position += 1;
        }
    }

    private boolean isPossibleMoveForward() {
        int randomNumber = randomNumberPicker.pickRandomNumber();
        return randomNumber >= MOVING_STANDARD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
