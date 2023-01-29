package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	@Test
	public void splitAndSum_쉼표구분자() {
		int result = Calculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() {
		int result = Calculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_구분자() {
		int result = Calculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_null() {
		int result = Calculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_빈문자() {
		int result = Calculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() {
		int result = Calculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_negative() {
		assertThatThrownBy(() -> Calculator.splitAndSum("-1,-2,-3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void splitAndSum_숫자이외의값() {
		assertThatThrownBy(() -> Calculator.splitAndSum("a, b, C"))
			.isInstanceOf(RuntimeException.class);
	}
}