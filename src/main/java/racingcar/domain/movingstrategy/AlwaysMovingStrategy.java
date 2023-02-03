package racingcar.domain.movingstrategy;

public class AlwaysMovingStrategy implements MovingStrategy {

    @Override
    public boolean isPossibleMoveForward() {
        return true;
    }
}
