package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.movingstrategy.AlwaysMovingStrategy;
import racingcar.domain.movingstrategy.MovingStrategy;

public class CarTest {

    @Test
    void 자동차_이름을_저장할_수_있다() {
        // given
        String carName = "Jinho";
        Car car = new Car(carName);

        // when
        String result = car.getName();

        // then
        assertThat(result).isEqualTo(carName);
    }

    @Test
    void 자동차는_진행_가능하다() {
        // given
        Car car = new Car("jinho");
        MovingStrategy movingStrategy = new AlwaysMovingStrategy();

        // when
        car.race(movingStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
