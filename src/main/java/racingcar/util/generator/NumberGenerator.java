package racingcar.util.generator;

import racingcar.util.validator.NumberValidator;

public class NumberGenerator {

	public static int generateNumber(String attemptNumber) {
		NumberValidator.validateNumber(attemptNumber);
		return Integer.parseInt(attemptNumber);
	}
}
