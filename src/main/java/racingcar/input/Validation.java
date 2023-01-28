package racingcar.input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static racingcar.message.ErrorMessage.*;

public class Validation {

    public void validateCarNameInputProcess(String input) {
        checkInputContainsBlank(input);
        checkInputHasEnoughCars(input);
        checkDuplicatedCarNames(input);
        Arrays.stream(input.split(","))
                .forEach((carName) -> checkCarNameLength(carName));
    }

    public void checkInputContainsBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(INPUT_CONTAINS_BLANK);
        }
    }

    public void checkInputHasEnoughCars(String input) {
        if (input.split(",").length < 2) {
            throw new IllegalArgumentException(NOT_ENOUGH_CARS);
        }
    }

    public void checkCarNameLength(String carName) {
        int length = carName.length();
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException(NOT_PROPER_NAME_LENGTH);
        }
    }

    public void checkDuplicatedCarNames(String input) {
        String[] strings = input.split(",");
        HashSet<String> hashSet = new HashSet<>(List.of(strings));
        if (strings.length != hashSet.size()) {
            throw (new IllegalArgumentException(DUPLICATED_NAMES));
        }
    }

    public void validateMoveCountInputProcess(String input) {
        checkInputIsNumber(input);
        checkInputIsGreaterThanZero(input);
    }

    public void checkInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    public void checkInputIsGreaterThanZero(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException(INPUT_IS_UNDER_ONE);
        }
    }
}
