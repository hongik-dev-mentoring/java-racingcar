package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesList {

    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    private final List<String> carNamesList;

    private CarNamesList(String carNames) {
        this.carNamesList = parseCarNames(carNames);
    }

    public static CarNamesList getCarNamesListByCarNames(String carNames) {
        return new CarNamesList(carNames);
    }

    public List<String> getCarNamesList() {
        return carNamesList;
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
            .map(CarNamesList::trimStringAndCheckEmptyName)
            .peek(CarNamesList::checkCarNameLengthIsLessThanOrEqualToLimit)
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
