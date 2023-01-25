package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환")
    public void emptyInputTest() {
        // given
        Calculator calculator = new Calculator();
        // when
        int actual = calculator.splitAndSum("");
        // then
        assertThat(actual).isEqualTo(0);
        // when
        actual = calculator.splitAndSum("   ");
        // then
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환")
    public void nullInputTest() {
        // given
        Calculator calculator = new Calculator();
        // when
        int actual = calculator.splitAndSum(null);
        // then
        assertThat(actual).isEqualTo(0);
    }
}
