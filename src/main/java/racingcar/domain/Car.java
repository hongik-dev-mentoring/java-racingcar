package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int START_LINE = 0;
    private static final int CAN_MOVE_MIN_NUMBER = 4;

    private final String name;
    private final RandomNumberGenerator randomNumberGenerator;
    private int position = START_LINE;

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void move() {
        if (checkCanMoveCondition()) {
            position++;
        }
    }

    private boolean checkCanMoveCondition() {
        Integer randomNumber = randomNumberGenerator.generate();
        return randomNumber >= CAN_MOVE_MIN_NUMBER;
    }

    public boolean isAtPosition(Integer maxPosition) {
        return position == maxPosition;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
