package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.view.CarRacingResultView.printCurrentRaceResult;
import static racingcar.view.CarRacingResultView.printRacingGameWinner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;

class CarRacingResultViewTest {

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
    void 레이싱_결과를_출력_할_수_있다() {
        List<Car> carList = new LinkedList<>();
        carList.add(new Car("jinho"));

        Cars cars = new Cars(carList);
        int gameCount = 0;
        Racing racing = new Racing(cars, gameCount);
        printCurrentRaceResult(racing);

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("jinho : \r\n");

        String actualOutput = output.toString();
        assertThat(actualOutput).contains(expectedOutput);
    }

    @Test
    void 레이싱의_우승자를_출력_할_수_있다() {
        List<Car> carList = new LinkedList<>();
        carList.add(new Car("jinho"));

        Cars cars = new Cars(carList);
        int gameCount = 0;
        Racing racing = new Racing(cars, gameCount);
        printRacingGameWinner(racing);

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("최종 우승자 : jinho\r\n");

        String actualOutput = output.toString();
        assertThat(actualOutput).contains(expectedOutput);
    }
}
