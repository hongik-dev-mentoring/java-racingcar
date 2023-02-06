package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveCountValidationTest {
    @Test
    @DisplayName("이동횟수는 숫자만 입력할 수 있습니다.")
    public void checkInputIsNumberTest() {
        String input = "AA";
        Assertions.assertThatThrownBy(() -> new MoveCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동횟수는 숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("이동횟수는 1 이상의 숫자만 가능합니다.")
    public void checkInputIsGreaterThanZeroTest() {
        String input = "-1";
        Assertions.assertThatThrownBy(() -> new MoveCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동횟수는 1 이상의 숫자만 가능합니다.");
    }
}
