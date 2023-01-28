package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("자동차 Position 출력 테스트")
    public void printPositionTest() {
        // given
        Car car = new Car("abc", 3);
        // when
        int actual = car.getPosition();
        car.printPosition();
        String output = getOutput();
        // then
        Assertions.assertThat(actual).isEqualTo(3);
        Assertions.assertThat(output).contains("abc : ---");
    }

    public String getOutput() {
        return outputStream.toString();
    }
}
