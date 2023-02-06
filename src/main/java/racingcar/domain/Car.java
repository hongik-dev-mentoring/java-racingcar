package racingcar.domain;

import racingcar.util.NumGenerator;

public class Car {
    private static final int CRITICAL_POINT_OF_MOVING = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public void move(NumGenerator zeroToNineGenerator) {
        if (zeroToNineGenerator.getNum() >= CRITICAL_POINT_OF_MOVING) {
            position++;
        }
    }
}
