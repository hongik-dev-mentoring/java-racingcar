package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarNames {

    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    private final List<String> carNames;

    private CarNames(String carNames) {
        this.carNames = parseCarNames(carNames);
    }

    public static CarNames getCarNamesFromCarNamesString(String carNames) {
        return new CarNames(carNames);
    }

    public Cars createCars() {
        List<Car> cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        return new Cars(cars);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
            .map(CarNames::trimStringAndCheckEmptyName)
            .peek(CarNames::checkCarNameLengthIsLessThanOrEqualToLimit)
            .collect(Collectors.toList());
    }

    private static String trimStringAndCheckEmptyName(String string) {
        String trimString = string.trim();

        if (trimString.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공란이 있습니다. 다시 입력해주세요.");
        }

        return trimString;
    }

    private static void checkCarNameLengthIsLessThanOrEqualToLimit(String string) {
        if (string.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 최대 5자입니다. 다시 입력해주세요.");
        }
    }
}
