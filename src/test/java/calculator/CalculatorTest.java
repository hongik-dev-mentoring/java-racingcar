package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("빈 문자열을 입력할 경우 0을 반환한다.")
    @ParameterizedTest(name = "#{index} {displayName}")
    @ValueSource(strings = {"", "   "})
    public void emptyInputTest(String input) {
        // given
        Calculator calculator = new Calculator();
        // when & then
        int actual = calculator.splitAndSum(input);
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

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest(name = "#{index} {displayName}")
    @ValueSource(strings = {"7", " 7", "7 ", "7,", "7:"})
    public void oneNumberStringInputTest(String input) {
        // given
        Calculator calculator = new Calculator();
        // when & then
        int actual = calculator.splitAndSum(input);
        assertThat(actual).isEqualTo(7);
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

    @DisplayName("'//'와 '\n' 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest(name = "#{index} {displayName}")
    @ValueSource(strings = {"//.\n1.2.3", "//;\n1;2;3", "//-\n1-2-3"})
    public void numbersWithCustomSeparatorInputTest(String input) {
        // given
        Calculator calculator = new Calculator();
        // when
        int actual = calculator.splitAndSum(input);
        // then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("지정한 커스텀 구분자로 숫자를 입력하지 않는 경우 예외 발생")
    public void customSeparatorInvalidInputTest() {
        // given
        Calculator calculator = new Calculator();
        // when & then
        assertThatThrownBy(() -> calculator.splitAndSum("//;\n1:2:3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    public void nagativeNumberInputTest() {
        // given
        Calculator calculator = new Calculator();
        String input = "-1: 2, 3";
        // when & then
        assertThatThrownBy(() -> calculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 계산할 수 없습니다.");
    }
}
