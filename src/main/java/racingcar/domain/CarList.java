package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private static final String BLANK = " ";
    private static final String COMMA_DELIMITER = ",";
    private static final String INPUT_CONTAINS_BLANK = "자동차 이름에 공백문자가 포함될 수 없습니다.";
    private static final String DUPLICATED_NAMES = "중복된 자동차 이름이 존재합니다.";
    private static final String NOT_ENOUGH_CARS = "경주에 참가하는 자동차가 한대 이상이어야 합니다.";
    private static final String NOT_PROPER_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";

    private static final Integer CAR_NUMBER_LIMIT = 2;
    private static final Integer CAR_NAME_MIN_LIMIT = 1;
    private static final Integer CAR_NAME_MAX_LIMIT = 5;

    private final List<Car> cars;

    public CarList(String input) {
        validateCarNameInputProcess(input);
        cars = Arrays.stream(input.split(COMMA_DELIMITER))
                .map(carName -> new Car(carName.trim())).collect(Collectors.toList());
    }

    public CarList(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    private void validateCarNameInputProcess(String input) {
        checkInputContainsBlank(input);
        checkInputHasEnoughCars(input);
        checkDuplicatedCarNames(input);
        Arrays.stream(input.split(COMMA_DELIMITER))
                .forEach((carName) -> checkCarNameLength(carName));
    }

    private void checkInputContainsBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(INPUT_CONTAINS_BLANK);
        }
    }

    private void checkInputHasEnoughCars(String input) {
        if (input.split(COMMA_DELIMITER).length < CAR_NUMBER_LIMIT) {
            throw new IllegalArgumentException(NOT_ENOUGH_CARS);
        }
    }

    private void checkDuplicatedCarNames(String input) {
        String[] strings = input.split(COMMA_DELIMITER);
        HashSet<String> hashSet = new HashSet<>(List.of(strings));
        if (strings.length != hashSet.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAMES);
        }
    }

    private void checkCarNameLength(String carName) {
        int length = carName.length();
        if (carNameIsNotProper(length)) {
            throw new IllegalArgumentException(NOT_PROPER_NAME_LENGTH);
        }
    }

    private boolean carNameIsNotProper(int length) {
        return !(CAR_NAME_MIN_LIMIT <= length && length <= CAR_NAME_MAX_LIMIT);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}
