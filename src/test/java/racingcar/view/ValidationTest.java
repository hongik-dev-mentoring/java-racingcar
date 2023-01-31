package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    private final Validation validate = new Validation();

    @Test
    @DisplayName("자동차 이름에 공백문자가 포함될 수 없습니다.")
    public void checkInputContainsBlankTest() {
        String input = "A,B,C,D D";
        Assertions.assertThatThrownBy(() -> validate.checkInputContainsBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백문자가 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("경주에 참가하는 자동차가 한대 이상이어야 합니다.")
    public void checkInputHasEnoughCarsTest() {
        String input = "A,";
        Assertions.assertThatThrownBy(() -> validate.checkInputHasEnoughCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주에 참가하는 자동차가 한대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름은 1자 이상 5자 이하만 가능합니다.")
    public void checkCarNameLengthTest() {
        String carName = "AAABBC,DD";
        Assertions.assertThatThrownBy(() -> validate.checkCarNameLength(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 존재합니다.")
    public void checkDuplicatedCarNamesTest() {
        String input = "AA,AA,B,C";
        Assertions.assertThatThrownBy(() -> validate.checkDuplicatedCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    @DisplayName("이동횟수는 숫자만 입력할 수 있습니다.")
    public void checkInputIsNumberTest() {
        String input = "AA";
        Assertions.assertThatThrownBy(() -> validate.checkInputIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동횟수는 숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("이동횟수는 1 이상의 숫자만 가능합니다.")
    public void checkInputIsGreaterThanZeroTest() {
        String input = "-1";
        Assertions.assertThatThrownBy(() -> validate.checkInputIsGreaterThanZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동횟수는 1 이상의 숫자만 가능합니다.");
    }

}
