package racingcar.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.message.ErrorMessage;

import java.lang.reflect.Field;

import static racingcar.message.ErrorMessage.*;

public class ValidationTest {

    private final Validation validate = new Validation();

    @Test
    @DisplayName("자동차 이름에 공백문자가 포함될 수 없습니다.")
    public void checkInputContainsBlankTest() {
        String input = "A,B,C,D D";
        Assertions.assertThatThrownBy(() -> validate.checkInputContainsBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_CONTAINS_BLANK);
    }

    @Test
    @DisplayName("경주에 참가하는 자동차가 한대 이상이어야 합니다.")
    public void checkInputHasEnoughCarsTest() {
        String input = "A,";
        Assertions.assertThatThrownBy(() -> validate.checkInputHasEnoughCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ENOUGH_CARS);
    }

    @Test
    @DisplayName("자동차 이름은 1자 이상 5자 이하만 가능합니다.")
    public void checkCarNameLengthTest() {
        String carName = "AAABBC,DD";
        Assertions.assertThatThrownBy(() -> validate.checkCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_PROPER_NAME_LENGTH);
    }

    @Test
    @DisplayName("중복된 자동차 이름이 존재합니다.")
    public void checkDuplicatedCarNamesTest() {
        String input = "AA,AA,B,C";
        Assertions.assertThatThrownBy(() -> validate.checkDuplicatedCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NAMES);
    }
    
    @ParameterizedTest
    @DisplayName("자동차 이름 입력 예외처리 통합 테스트")
    @CsvSource(value = {
            "A,B,C,D D:INPUT_CONTAINS_BLANK",
            "A,:NOT_ENOUGH_CARS",
            "AAABBC,DD:NOT_PROPER_NAME_LENGTH",
            "AA,AA,B,C:DUPLICATED_NAMES"}, delimiter = ':')
    public void validateCarNameInputProcessTest(String input, String constantName) throws NoSuchFieldException, IllegalAccessException {
        ErrorMessage errorMessage = new ErrorMessage();
        Field field = errorMessage.getClass().getField(constantName);
        String message = (String) field.get(String.class);

        Assertions.assertThatThrownBy(() -> validate.validateCarNameInputProcess(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("이동횟수는 숫자만 입력할 수 있습니다.")
    public void checkInputIsNumberTest() {
        String input = "AA";
        Assertions.assertThatThrownBy(() -> validate.checkInputIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_IS_NOT_NUMBER);
    }

    @Test
    @DisplayName("이동횟수는 1 이상의 숫자만 가능합니다.")
    public void checkInputIsGreaterThanZeroTest() {
        String input = "-1";
        Assertions.assertThatThrownBy(() -> validate.checkInputIsGreaterThanZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_IS_UNDER_ONE);
    }

    @ParameterizedTest
    @DisplayName("이동횟수 입력 예외처리 통합 테스트")
    @CsvSource(value = {"AA:INPUT_IS_NOT_NUMBER", "-1:INPUT_IS_UNDER_ONE"}, delimiter = ':')
    public void validateMoveCountInputProcessTest(String input, String constantName) throws NoSuchFieldException, IllegalAccessException {
        ErrorMessage errorMessage = new ErrorMessage();
        Field field = errorMessage.getClass().getField(constantName);
        String message = (String) field.get(String.class);

        Assertions.assertThatThrownBy(() -> validate.validateMoveCountInputProcess(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

}
