package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final Integer START_LINE = 0;
    private static final Integer CAN_MOVE_MIN_NUMBER = 4;
    private static final Integer MIN_RANDOM_NUMBER = 0;
    private static final Integer MAX_RANDOM_NUMBER = 9;

    private final String name;
    private final RandomNumberGenerator randomNumberGenerator;
    private Integer position = START_LINE;

    public Car(String name) {
        this.name = name;
        this.randomNumberGenerator = new RandomNumberGenerator(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void move() {
        if (checkCanMoveCondition()) {
            this.position++;
        }
    }

    private boolean checkCanMoveCondition() {
        Integer randomNumber = randomNumberGenerator.generate();
        return randomNumber >= CAN_MOVE_MIN_NUMBER;
    }

    public boolean isAtPosition(Integer maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Integer getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
