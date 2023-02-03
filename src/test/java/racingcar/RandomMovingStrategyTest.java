package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.movingstrategy.RandomMovingStrategy;
import racingcar.domain.movingstrategy.RangedRandomNumberPicker;

class RandomMovingStrategyTest {
    int movingStandard;
    int FROM;
    int TO;

    @Test
    void RandomMovingStrategy는_전진_가능_범위에서_true를_반환한다() {
        // given
        movingStandard = 4;
        FROM = movingStandard;
        TO = 9;
        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);

        // when
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy(randomNumberPicker, movingStandard);
        boolean result = randomMovingStrategy.isPossibleMoveForward();

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void RandomMovingStrategy는_전진_불가능_범위에서_false를_반환한다() {
        // given
        movingStandard = 4;
        FROM = 0;
        TO = movingStandard - 1;
        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);

        // when
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy(randomNumberPicker, movingStandard);
        boolean result = randomMovingStrategy.isPossibleMoveForward();

        //then
        assertThat(result).isEqualTo(false);
    }
}
