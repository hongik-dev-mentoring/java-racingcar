package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환한다.")
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
    @DisplayName("null 값을 입력할 경우 0을 반환한다.")
    public void nullInputTest() {
        // given
        Calculator calculator = new Calculator();
        // when
        int actual = calculator.splitAndSum(null);
        // then
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void oneNumberStringInputTest() {
        // given
        Calculator calculator = new Calculator();
        List<String> testData = Arrays.asList("7", " 7", "7 ", "7,", "7:");
        // when & then
        testData.forEach(input -> {
            int actual = calculator.splitAndSum(input);
            assertThat(actual).isEqualTo(7);
        });
    }

    @Test
    @DisplayName("숫자를 ',' 구분자로 입력할 경우 숫자의 합을 반환한다.")
    public void numbersWithCommaInputTest() {
        // given
        Calculator calculator = new Calculator();
        String input = "1, 2, 3";
        // when
        int actual = calculator.splitAndSum(input);
        // then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자를 ':' 구분자로 입력할 경우 숫자의 합을 반환한다.")
    public void numbersWithColonInputTest() {
        // given
        Calculator calculator = new Calculator();
        String input = "1: 2: 3";
        // when
        int actual = calculator.splitAndSum(input);
        // then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자를 ',' 와 ':' 구분자로 입력할 경우 숫자의 합을 반환한다.")
    public void numbersWithCommaAndColonInputTest() {
        // given
        Calculator calculator = new Calculator();
        String input = "1: 2, 3";
        // when
        int actual = calculator.splitAndSum(input);
        // then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("'//'와 '\n' 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    public void numbersWithCustomSeparatorInputTest() {

    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    public void nagativeNumberInputTest() {

    }
}
