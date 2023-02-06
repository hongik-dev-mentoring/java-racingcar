package racingcar;

import static racingcar.view.CarRacingResultView.printCurrentRaceResult;
import static racingcar.view.CarRacingResultView.printRacingGameWinner;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.movingstrategy.RandomMovingStrategy;
import racingcar.domain.movingstrategy.RangedRandomNumberPicker;
import racingcar.view.Input;

public class CarRacingController {

    private CarRacingController() {
        throw new AssertionError();
    }

    public static void initCarRacingGame() {
        Input input = new Input();
        Cars cars = input.getCars();
        int raceGameCount = input.getRacingGameCount();

        Racing racing = new Racing(cars, raceGameCount);
        MovingStrategy movingStrategy = getRandomMovingStrategy();

        carRacingGame(racing, movingStrategy);
    }

    private static MovingStrategy getRandomMovingStrategy() {
        final int movingStandard = 4;
        final int FROM = 0;
        final int TO = 0;

        RangedRandomNumberPicker rangedRandomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        return new RandomMovingStrategy(rangedRandomNumberPicker, movingStandard);
    }

    private static void carRacingGame(Racing racing, MovingStrategy movingStrategy) {
        System.out.println("실행 결과");
        while  (racing.isLeftRacing()) {
            racing.raceAllCar(movingStrategy);
            printCurrentRaceResult(new CarsDto(racing.getCars()));
        }
        printRacingGameWinner(racing.getWinnersName());
    }

    public static class CarsDto {
        private final List<CarDto> cars;

        public CarsDto(Cars cars) {
            List<Car> carList = cars.getCars();
            this.cars = carList.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
        }

        public List<CarDto> getCars() {
            return cars;
        }
    }

    public static class CarDto {

        private final String name;
        private final int position;

        public CarDto(Car car) {
            name = car.getName();
            position = car.getPosition();
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }
}
