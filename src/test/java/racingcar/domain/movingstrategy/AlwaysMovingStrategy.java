package racingcar.domain.movingstrategy;

import racingcar.domain.movingstrategy.MovingStrategy;

public class AlwaysMovingStrategy implements MovingStrategy {

    @Override
    public boolean isPossibleMoveForward() {
        return true;
    }
}
