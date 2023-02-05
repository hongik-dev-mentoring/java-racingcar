package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.CarRacingResultView.printCurrentRaceResult;
import static racingcar.view.CarRacingResultView.printRacingGameWinner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.view.CarNames;
import racingcar.view.CarRacingResultView;

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
        CarNames carNames = CarNames.createCarNamesFromCarNamesString("jinh1, jinh2");
        Cars cars = carNames.createCars();
        Racing racing = new Racing(cars, 3);

        MovingStrategy movingStrategy = new AlwaysMovingStrategy();
        StringBuilder expectedOutputString = new StringBuilder("최종 우승자 : jinh1, jinh2\r\n");

        // when
        racing.raceAllCar(movingStrategy);
        printRacingGameWinner(racing);
        String actualOutputString = output.toString();

        // then
        assertThat(actualOutputString).contains(expectedOutputString);
    }
}
