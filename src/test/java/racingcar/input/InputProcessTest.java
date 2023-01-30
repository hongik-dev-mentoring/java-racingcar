package racingcar.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.message.ConsoleMessage.INPUT_CAR_NAMES;
import static racingcar.message.ConsoleMessage.INPUT_MOVE_COUNT;

public class InputProcessTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void outputSetUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    public void inputCarNamesTest() {
        // given
        String input = "A,B,C\n";
        systemIn(input);
        // when
        InputProcess inputProcess = new InputProcess();
        List<Car> carNames = inputProcess.getCarList();
        // then
        assertThat(getOutput()).contains(INPUT_CAR_NAMES);
        assertThat(carNames.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("이동횟수 입력 테스트")
    public void inputMoveCountTest() {
        // given
        String input = "3\n";
        systemIn(input);
        // when
        InputProcess inputProcess = new InputProcess();
        Integer count = inputProcess.getMoveCount();
        // then
        assertThat(getOutput()).contains(INPUT_MOVE_COUNT);
        assertThat(count).isEqualTo(3);
    }

    public void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public String getOutput() {
        return outputStream.toString();
    }


}
