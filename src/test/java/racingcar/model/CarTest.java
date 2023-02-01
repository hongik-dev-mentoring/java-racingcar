package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberPicker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CarTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void outputSetUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("자동차 이동하기, Position 출력하기 테스트")
    public void moveTest() {
        // given
        RandomNumberPicker randomNumberPicker = new RandomNumberPicker(4, 9);
        Car car = new Car("abc", randomNumberPicker);
        // when
        car.move();
        car.move();
        car.move();
        car.printPosition();
        String output = getOutput();
        // then
        Assertions.assertThat(output).contains("abc : ---");
    }

    public String getOutput() {
        return outputStream.toString();
    }
}
