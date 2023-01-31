package racingcar.model;

import java.util.Random;

public class Car {

    private static final Integer START_LINE = 0;
    private static final Integer CAN_MOVE_MIN_NUMBER = 4;
    private static final Integer RANGE_0_AND_10 = 10;
    private static final String COLLON = " : ";
    private static final String ONE_MOVE_MARK = "-";

    private final String name;
    private Integer position = START_LINE;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        if (pickRandomNumber() >= CAN_MOVE_MIN_NUMBER) {
            this.position++;
        }
    }

    private int pickRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(RANGE_0_AND_10);
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
