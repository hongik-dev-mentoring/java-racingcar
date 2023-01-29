package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomMovingCarTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setOutPrintStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 자동차_이름을_저장할_수_있다() {
        // given
        String carName = "Jinho";
        RandomMovingCar randomMovingCar = new RandomMovingCar(carName, new RangedRandomNumberPicker(0, 9));

        // when
        String result = randomMovingCar.getName();

        // then
        assertThat(result).isEqualTo(carName);
    }

    @Test
    void 자동차는_진행_가능_범위에서_진행할_수_있다() {
        // given
        final int FROM = 4;
        final int TO = 9;

        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        RandomMovingCar car = new RandomMovingCar("jinho", randomNumberPicker);

        // when
        car.race();
        car.race();
        car.race();
        car.race();
        car.race();

        // then
        assertThat(car.getPosition()).isEqualTo(5);
    }

    @Test
    void 자동차는_진행_불가능_범위에서_진행할_수_없다() {
        // given
        final int FROM = 0;
        final int TO = 3;

        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        RandomMovingCar car = new RandomMovingCar("jinho", randomNumberPicker);

        // when
        car.race();
        car.race();
        car.race();
        car.race();
        car.race();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
