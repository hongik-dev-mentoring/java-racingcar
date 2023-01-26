package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    public String getOutput() {
        return outputStream.toString();
    }

    @Test
    public void printPositionTest() {
        Car car = new Car("abc", 3);
        int actual = car.getPosition();
        Assertions.assertThat(actual).isEqualTo(3);
        car.printPosition();
        String output = getOutput();
        Assertions.assertThat(output).contains("abc : ---");
    }
}
