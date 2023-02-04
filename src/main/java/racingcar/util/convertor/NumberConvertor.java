package racingcar.util.convertor;

import racingcar.util.validator.AttemptNumberValidator;

public class NumberConvertor {
	public static int convertNumber(String attemptNumber) {
		AttemptNumberValidator.validateNumber(attemptNumber);
		return Integer.parseInt(attemptNumber);
	}
}
