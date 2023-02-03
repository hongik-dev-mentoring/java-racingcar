package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;
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
        List<Car> cars = inputProcess.getCarList();
        Race race = new Race(cars);
        // when
        race.proceedOneRound();
        List<Car> winners = race.selectWinners();
        // then
        assertThat(winners.size()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("모든 자동차가 전진하지 못한 경우 우승자 select 테스트")
    public void testNoWinner() {
        // given
        List<Car> cars = List.of(
                new Car("a", new RandomNumberGenerator(3, 3)),
                new Car("b", new RandomNumberGenerator(3, 3)),
                new Car("c", new RandomNumberGenerator(3, 3))
        );
        Race race = new Race(cars);
        // when
        List<Car> winners = race.selectWinners();
        // then
        assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 경주 One Round 진행후 출력 테스트")
    public void raceStartTest() {
        // given
        InputProcess inputProcess = new InputProcess();
        List<Car> cars = inputProcess.getCarList();
        OutputProcess outputProcess = new OutputProcess(cars);
        Race race = new Race(cars);

        // when
        race.proceedOneRound();
        outputProcess.printCarPositions();
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
