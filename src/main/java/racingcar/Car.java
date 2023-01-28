package racingcar;

import java.util.Random;

import static racingcar.message.Constant.*;

public class Car {
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
