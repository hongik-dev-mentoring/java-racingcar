package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    public String getOutput() {
        return outputStream.toString();
    }

    @Test
    public void racePrintTest() {
        // given
        Race race = new Race();
        // when
        race.startInputProcess();
        race.proceed();
        race.print();
        String output = getOutput();
        // then
        List<String> carNames = List.of("pobi : ", "crong : ", "honux : ");
        for (String carName : carNames) {
            assertThat(output).contains(carName);
        }
    }

    @Test
    public void raceStartTest() {
        // given
        Race race = new Race();
        // when
        race.start();
        String output = getOutput();
        // then
        assertThat(output).contains("실행 결과");
        List<String> carNames = List.of("pobi : ", "crong : ", "honux : ");
        for (int i = 0; i < 3; i++) {
            for (String carName : carNames) {
                assertThat(output).contains(carName);
                output = output.replaceFirst(carName, "");
            }
        }
        for (String carName : carNames)
            assertThat(output).doesNotContain(carName);
    }

    @Test
    public void selectWinnersTest() {
        Race race = new Race();
        List<Car> cars = Arrays.asList(
                new Car("A", 2),
                new Car("B", 3),
                new Car("C", 3)
        );
        List<Car> winners = race.selectWinners(cars);
        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners.get(0).getPosition()).isEqualTo(3);
    }

    @Test
    public void printWinnersTest() {
        Race race = new Race();
        race.start();
        race.printWinners();
        String output = getOutput();
        Assertions.assertThat(output).contains("가 최종 우승했습니다.");
    }

}
