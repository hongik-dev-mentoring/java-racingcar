package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

public class CarTest {

    @Test
    @DisplayName("자동차 이동하기 테스트")
    public void moveTest() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(4, 9);
        Car car = new Car("abc", randomNumberGenerator);
        // when
        car.move();
        car.move();
        car.move();
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(3);
    }

}
