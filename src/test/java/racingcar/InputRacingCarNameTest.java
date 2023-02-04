package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.view.CarNames;
import racingcar.view.Input;

class InputRacingCarNameTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private InputStream inputStream;

    @AfterEach
    void resetInputStream() throws IOException {
        inputStream.reset();
    }

    @Test
    void 자동차_이름_한개_입력_테스트() {
        //given
        String inputString = "jinho";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Input input = new Input();

        // when
        Cars cars = input.getCars();
        List<String> carNamesString = cars.getCarsByPosition(0);
        // then
        assertThat(carNamesString.get(0)).isEqualTo(inputString);
    }

    @Test
    void 자동차_이름_여러개_입력_테스트() {
        //given
        String inputString = "jinho, dongh, skull";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Input input = new Input();

        // when
        Cars cars = input.getCars();
        List<String> carNamesString = cars.getCarsByPosition(0);

        // then
        assertAll(
            () -> assertThat(carNamesString.get(0)).isEqualTo("jinho"),
            () -> assertThat(carNamesString.get(1)).isEqualTo("dongh"),
            () -> assertThat(carNamesString.get(2)).isEqualTo("skull")
        );
    }

    @Test
    void 자동차_이름에_공란_입력시_입력_다시_받기() {
        //given
        setOutPrintStream();

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n")
            .append("[ERROR] 아무 이름도 입력하지 않으셨습니다. 다시 입력해주세요.\r\n")
            .append("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n");

        Input input = new Input();

        try {
            // when
            String inputString = "\n";
            inputStream = new ByteArrayInputStream(inputString.getBytes());
            System.setIn(inputStream);

            input.getCars();

            failBecauseExceptionWasNotThrown(NoSuchElementException.class);
        } catch (NoSuchElementException e) {
            // then
            String actualOutput = output.toString();
            assertThat(actualOutput).contains(expectedOutput);
        } finally {
            resetOutputStream();
        }
    }

    @Test
    void 자동차_이름_5글자_제한_초과시_에러_발생() {
        //given
        setOutPrintStream();

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n")
            .append("[ERROR] 자동차의 이름은 최대 5자입니다. 다시 입력해주세요.\r\n")
            .append("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n");

        Input input = new Input();

        try {
            // when
            String inputString = "jinhojinhoyayaya";
            inputStream = new ByteArrayInputStream(inputString.getBytes());
            System.setIn(inputStream);

            input.getCars();

            failBecauseExceptionWasNotThrown(NoSuchElementException.class);
        } catch (NoSuchElementException e) {
            // then
            String actualOutput = output.toString();
            assertThat(actualOutput).contains(expectedOutput);
        } finally {
            resetOutputStream();
        }
    }

    @Test
    void 자동차_이름에_공란을_섞은_경우_에러_발생() {
        //given
        setOutPrintStream();

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n")
            .append("[ERROR] 자동차 이름에 공란이 있습니다. 다시 입력해주세요.\r\n")
            .append("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n");

        Input input = new Input();

        try {
            // when
            String inputString = "jinho, , dongh, skull";
            inputStream = new ByteArrayInputStream(inputString.getBytes());
            System.setIn(inputStream);

            input.getCars();

            failBecauseExceptionWasNotThrown(NoSuchElementException.class);
        } catch (NoSuchElementException e) {
            // then
            String actualOutput = output.toString();
            assertThat(actualOutput).contains(expectedOutput);
        } finally {
            resetOutputStream();
        }
    }

    void setOutPrintStream() {
        System.setOut(new PrintStream(output));
    }

    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }
}
