package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void outputSetUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @BeforeEach
    public void inputSetUp() {
        String input = "pobi,crong,honux\n3\n";
        systemIn(input);
    }

    public void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("자동차 경주 최종 결과 출력 테스트")
    public void printWinnersTest() {
        // given
        RaceController raceController = new RaceController();
        // when
        raceController.completeRace();
        String output = getOutput();
        // then
        assertThat(output).contains("실행 결과");
        assertThat(output).contains("가 최종 우승했습니다.");
    }

    public String getOutput() {
        return outputStream.toString();
    }
}
