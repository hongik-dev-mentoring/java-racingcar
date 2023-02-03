package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;
import racingcar.domain.Car;
import racingcar.domain.movingstrategy.AlwaysMovingStrategy;
import racingcar.domain.movingstrategy.MovingStrategy;

public class RacingTest {

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
    void 레이싱_공동_우승자_출력_테스트() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("jinho1"));
        cars.add(new Car("jinho2"));

        Racing racing = new Racing(cars, 3);

        MovingStrategy movingStrategy = new AlwaysMovingStrategy();
        StringBuilder expectedOutputString = get_레이싱_공동_우승자_출력_테스트_ExpectedOutput();

        // when
        racing.race(movingStrategy);
        String actualOutputString = output.toString();

        // then
        assertThat(actualOutputString).contains(expectedOutputString);
    }

    StringBuilder get_레이싱_공동_우승자_출력_테스트_ExpectedOutput() {
        return new StringBuilder("실행 결과\r\n")
            .append("jinho1 : -\r\n")
            .append("jinho2 : -\r\n")
            .append("\r\n")
            .append("jinho1 : --\r\n")
            .append("jinho2 : --\r\n")
            .append("\r\n")
            .append("jinho1 : ---\r\n")
            .append("jinho2 : ---\r\n")
            .append("\r\n")
            .append("최종 우승자 : jinho1, jinho2\r\n");
    }
}
