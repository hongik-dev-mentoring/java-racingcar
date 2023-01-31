package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

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
    public void raceStartTest() {
        // given
        Race race = new Race();

        // when
        race.start();
        String output = getOutput();

        // then
        List<String> carNames = List.of("pobi : ", "crong : ", "honux : ");
        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            for (String carName : carNames) {
                output = output.replaceFirst(carName, "");
            }
        }

        assertThat(output).contains("실행 결과");
        assertThat(output).doesNotContain("pobi : ");
        assertThat(output).doesNotContain("crong : ");
        assertThat(output).doesNotContain("honux : ");
    }

    @Test
    @DisplayName("자동차 경주 우승자 출력 테스트")
    public void printWinnersTest() {
        // given
        Race race = new Race();
        // when
        race.start();
        race.printWinners();
        String output = getOutput();
        // then
        Assertions.assertThat(output).contains("가 최종 우승했습니다.");
    }

    public String getOutput() {
        return outputStream.toString();
    }

}
