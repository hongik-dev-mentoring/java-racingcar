package racingcar.util.convertor;

import racingcar.util.validator.NumberValidator;

public class NumberConvertor {
	public static int convertNumber(String attemptNumber) {
		NumberValidator.validateNumber(attemptNumber);
		return Integer.parseInt(attemptNumber);
	}
}
