package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.movingstrategy.AlwaysMovingStrategy;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.view.CarNames;

public class RacingTest {

    @Test
    void 레이싱을_할_수_있다() {
        // given
        List<String> carNamesList = new LinkedList<>();
        carNamesList.add("jinh1");
        carNamesList.add("jinh2");

        CarNames carNames = CarNames.createCarNamesFromCarNamesString(String.join(",", carNamesList));
        Cars cars = carNames.createCars();
        Racing racing = new Racing(cars, 1);

        MovingStrategy movingStrategy = new AlwaysMovingStrategy();

        // when
        racing.raceAllCar(movingStrategy);
        List<String> carsAfterRace = racing.getCars().getCarsByPosition(1);

        // then
        assertThat(carsAfterRace).isEqualTo(carNamesList);
    }

    @Test
    void 레이싱의_우승자들의_이름을_가져올_수_있다() {
        // given
        String carName = "jinh1";

        CarNames carNames = CarNames.createCarNamesFromCarNamesString(carName);
        Cars cars = carNames.createCars();
        Racing racing = new Racing(cars, 3);

        MovingStrategy movingStrategy = new AlwaysMovingStrategy();
        List<String> expectedResult =  new LinkedList<>();
        expectedResult.add(carName);

        // when
        racing.raceAllCar(movingStrategy);
        List<String> actualResult = racing.getWinnersName();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 레이싱_공동_우승자_처리_테스트() {
        // given
        List<String> carNamesList = new LinkedList<>();
        carNamesList.add("jinh1");
        carNamesList.add("jinh2");

        CarNames carNames = CarNames.createCarNamesFromCarNamesString(String.join(",", carNamesList));
        Cars cars = carNames.createCars();
        Racing racing = new Racing(cars, 3);

        MovingStrategy movingStrategy = new AlwaysMovingStrategy();
        List<String> expectedResult =  new LinkedList<>(carNamesList);

        // when
        racing.raceAllCar(movingStrategy);
        List<String> carsAfterRace = racing.getWinnersName();

        // then
        assertThat(carsAfterRace).isEqualTo(expectedResult);
    }
}
