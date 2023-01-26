package racingcar.input;

import java.util.HashSet;
import java.util.List;

import static racingcar.message.ErrorMessage.*;

public class Validation {

    public void checkInputContainsBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(INPUT_CONTAINS_BLANK.toString());
        }
    }

    public void checkInputHasEnoughCars(String input) {
        if (input.split(",").length < 2) {
            throw new IllegalArgumentException(NOT_ENOUGH_CARS.toString());
        }
    }

    public void checkCarNameLength(String carName) {
        int length = carName.length();
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException(NOT_PROPER_NAME_LENGTH.toString());
        }
    }

    public void checkDuplicatedCarNames(String input) {
        String[] strings = input.split(",");
        HashSet<String> hashSet = new HashSet<>(List.of(strings));
        if (strings.length != hashSet.size()) {
            throw (new IllegalArgumentException(DUPLICATED_NAMES.toString()));
        }
    }

    public void checkInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER.toString());
        }
    }

    public void checkInputIsGreaterThanZero(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException(INPUT_IS_UNDER_ONE.toString());
        }
    }
}
