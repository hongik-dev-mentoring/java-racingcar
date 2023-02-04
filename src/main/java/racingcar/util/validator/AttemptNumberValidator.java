package racingcar.util.validator;

public class AttemptNumberValidator {
	private static final String MIN_ATTEMPT_NUMBER_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";
	private static final String ATTEMPT_NUMBER_IS_NOT_INTEGER = "시도 횟수는 숫자여야 한다.";
	private static final int MIN_ATTEMPT_NUMBER = 1;

	public static void validateNumber(String attemptNumber) {
		checkNumberIsNotInteger(attemptNumber);
		checkNumberRange(attemptNumber);
	}

	private static void checkNumberIsNotInteger(String attemptNumber) {
		try {
			Integer.parseInt(attemptNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_IS_NOT_INTEGER);
		}
	}

	private static void checkNumberRange(String attemptNumber) {
		int attemptNumberToInteger = Integer.parseInt(attemptNumber);
		if (attemptNumberToInteger < MIN_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(MIN_ATTEMPT_NUMBER_MESSAGE);
		}
	}
}
