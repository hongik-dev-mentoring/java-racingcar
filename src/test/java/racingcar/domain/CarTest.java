package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.util.NumGenerator;

class CarTest {

    Car car;

    @BeforeEach
    void setup() {
        car = new Car("tae");
    }

    @Test
    @DisplayName("4이상의 숫자에 car가 움직이는지 테스트")
    void moveForward() {

        car.move(new ForwardNumGenerator());

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만의 숫자에 car의 안움직이는지 테스트")
    void stop() {

        car.move(new StopNumGenerator());

        assertThat(car.getPosition()).isEqualTo(0);
    }

    class ForwardNumGenerator implements NumGenerator {
        @Override
        public int getNum() {
            return 4;
        }
    }

    class StopNumGenerator implements NumGenerator {
        @Override
        public int getNum() {
            return 3;
        }
    }

}
