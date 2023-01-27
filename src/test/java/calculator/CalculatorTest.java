package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = Calculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void spliatAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = Calculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}
	
}