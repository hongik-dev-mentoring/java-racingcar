package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.RandomMovingCar;

public class RandomMovingCarTest {

    int movingStandard;
    int FROM;
    int TO;

    @Test
    void 자동차_이름을_저장할_수_있다() {
        // given
        String carName = "Jinho";
        RandomMovingCar randomMovingCar = new RandomMovingCar(carName);

        // when
        String result = randomMovingCar.getName();

        // then
        assertThat(result).isEqualTo(carName);
    }

    @Test
    void 자동차는_진행_가능_범위에서_진행할_수_있다() {
        // given
        movingStandard = 4;
        FROM = movingStandard;
        TO = 9;

        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        RandomMovingCar car = new RandomMovingCar("jinho");
        MovingStrategy movingStrategy = new RandomMovingStrategy(randomNumberPicker, movingStandard);

        // when
        car.race(movingStrategy);
        car.race(movingStrategy);
        car.race(movingStrategy);
        car.race(movingStrategy);
        car.race(movingStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(5);
    }

    @Test
    void 자동차는_진행_불가능_범위에서_진행할_수_없다() {
        // given
        movingStandard = 4;
        FROM = 0;
        TO = movingStandard - 1;

        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        RandomMovingCar car = new RandomMovingCar("jinho");
        MovingStrategy movingStrategy = new RandomMovingStrategy(randomNumberPicker, movingStandard);

        // when
        car.race(movingStrategy);
        car.race(movingStrategy);
        car.race(movingStrategy);
        car.race(movingStrategy);
        car.race(movingStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
