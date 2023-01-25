package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환")
    public void emptyInputTest() {
        // given
        Calculator calculator = new Calculator();
        // when & then
        int actual = calculator.splitAndSum("");
        assertThat(actual).isEqualTo(0);
        // when & then
        actual = calculator.splitAndSum("   ");
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

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환")
    public void oneNumberInputTest() {
        // given
        Calculator calculator = new Calculator();
        List<String> list = Arrays.asList("7", " 7", "7 ", "7,", "7:");
        // when & then
        list.forEach(input -> {
            int actual = calculator.splitAndSum(input);
            assertThat(actual).isEqualTo(7);
        });
    }
}
