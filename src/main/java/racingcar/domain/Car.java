package racingcar.domain;

import racingcar.domain.movingstrategy.MovingStrategy;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void race(MovingStrategy movingStrategy) {
        if (movingStrategy.isPossibleMoveForward()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
