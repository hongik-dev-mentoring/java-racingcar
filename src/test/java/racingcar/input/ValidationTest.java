package racingcar.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.message.ErrorMessage;

import static racingcar.message.ErrorMessage.*;

public class ValidationTest {

    private final Validation validate = new Validation();

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
        String carName = "AAABBC,DD";
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

    @ParameterizedTest
    @CsvSource(value = {
            "A,B,C,D D:INPUT_CONTAINS_BLANK",
            "A,:NOT_ENOUGH_CARS",
            "AAABBC,DD:NOT_PROPER_NAME_LENGTH",
            "AA,AA,B,C:DUPLICATED_NAMES"}, delimiter = ':')
    public void validateCarNameInputProcessTest(String input, String errorMessage) {
        ErrorMessage message = Enum.valueOf(ErrorMessage.class, errorMessage);
        Assertions.assertThatThrownBy(() -> validate.validateCarNameInputProcess(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message.toString());
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

    @ParameterizedTest
    @CsvSource(value = {
            "AA:INPUT_IS_NOT_NUMBER",
            "-1:INPUT_IS_UNDER_ONE"}, delimiter = ':')
    public void validateMoveCountInputProcessTest(String input, String errorMessage) {
        ErrorMessage message = Enum.valueOf(ErrorMessage.class, errorMessage);
        Assertions.assertThatThrownBy(() -> validate.validateMoveCountInputProcess(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message.toString());
    }

}
