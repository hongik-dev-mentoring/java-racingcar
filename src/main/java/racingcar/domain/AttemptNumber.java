package racingcar.domain;

import racingcar.util.validator.AttemptNumberValidator;

public class AttemptNumber {
	public static int convertNumber(String attemptNumber) {
		AttemptNumberValidator.validateNumber(attemptNumber);
		return Integer.parseInt(attemptNumber);
	}
}
