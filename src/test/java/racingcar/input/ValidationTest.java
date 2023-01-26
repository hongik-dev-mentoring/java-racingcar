package racingcar.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static racingcar.message.ErrorMessage.*;

public class ValidationTest {

    private final Validation validate = new Validation();

    @Test // checkCarNameLengthTest로 커버가능
    public void checkCarNameIsEmpty() {
        String input = ",A,B,C,D"; // 01111
        Arrays.stream(input.split(","))
                .forEach(s -> System.out.println(s.length()));
    }

    @Test
    public void checkInputContainsBlankTest() {
        String input = "A,B,C,D D";
        Assertions.assertThatThrownBy(() -> validate.checkInputContainsBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_CONTAINS_BLANK.toString());
    }

    @Test
    public void checkInputHasEnoughCarsTest() {
        String input = "A,";
        Assertions.assertThatThrownBy(() -> validate.checkInputHasEnoughCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ENOUGH_CARS.toString());
    }

    @Test
    public void checkCarNameLengthTest() {
        String carName = "AAABBC";
        Assertions.assertThatThrownBy(() -> validate.checkCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_PROPER_NAME_LENGTH.toString());
    }

    @Test
    public void checkDuplicatedCarNamesTest() {
        String input = "AA,AA,B,C";
        Assertions.assertThatThrownBy(() -> validate.checkDuplicatedCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NAMES.toString());
    }

    @Test
    public void checkInputIsNumberTest() {
        String input = "AA";
        Assertions.assertThatThrownBy(() -> validate.checkInputIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_IS_NOT_NUMBER.toString());
    }

    @Test
    public void checkInputIsGreaterThanZeroTest() {
        String input = "-1";
        Assertions.assertThatThrownBy(() -> validate.checkInputIsGreaterThanZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_IS_UNDER_ONE.toString());
    }

}
