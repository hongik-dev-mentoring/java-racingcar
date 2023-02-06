package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputProcess;
import racingcar.view.OutputProcess;

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
    @DisplayName("자동차 경주 우승자 select 테스트")
    public void printWinnersTest() {
        // given
        InputProcess inputProcess = new InputProcess();
        CarList carList = inputProcess.getCarList();
        MoveCount moveCount = inputProcess.getMoveCount();
        Race race = new Race(carList, moveCount);
        // when
        race.proceedOneRound();
        CarList winners = race.selectWinners();
        // then
        assertThat(winners.getCars().size()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("자동차 경주 One Round 진행후 출력 테스트")
    public void raceStartTest() {
        // given
        InputProcess inputProcess = new InputProcess();
        CarList carList = inputProcess.getCarList();
        MoveCount moveCount = inputProcess.getMoveCount();
        Race race = new Race(carList, moveCount);

        // when
        race.proceedOneRound();
        OutputProcess.printCarPositions(carList);
        String output = getOutput();

        // then
        List<String> carNames = List.of("pobi : ", "crong : ", "honux : ");
        for (String carName : carNames) {
            output = output.replaceFirst(carName, "");
        }

        assertThat(output).doesNotContain("pobi : ");
        assertThat(output).doesNotContain("crong : ");
        assertThat(output).doesNotContain("honux : ");
    }

    public String getOutput() {
        return outputStream.toString();
    }

}
