package racingcar.model;

import racingcar.util.RandomNumberPicker;

public class Car {

    private static final Integer START_LINE = 0;
    private static final Integer CAN_MOVE_MIN_NUMBER = 4;
    private static final Integer MIN_RANDOM_NUMBER = 0;
    private static final Integer MAX_RANDON_NUMBER = 10;
    private static final String COLLON = " : ";
    private static final String ONE_MOVE_MARK = "-";

    private final String name;
    private Integer position = START_LINE;
    private RandomNumberPicker randomNumberPicker;

    public Car(String name) {
        this.name = name;
        this.randomNumberPicker = new RandomNumberPicker(MIN_RANDOM_NUMBER, MAX_RANDON_NUMBER);
    }

    public Car(String name, RandomNumberPicker randomNumberPicker) {
        this.name = name;
        this.randomNumberPicker = randomNumberPicker;
    }

    public void move() {
        if (checkCanMoveCondition()) {
            this.position++;
        }
    }

    private boolean checkCanMoveCondition() {
        Integer randomNumber = randomNumberPicker.pickRandomNumber();
        return randomNumber >= CAN_MOVE_MIN_NUMBER;
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(COLLON);
        sb.append(ONE_MOVE_MARK.repeat(position));
        System.out.println(sb);
    }

    public Integer getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
