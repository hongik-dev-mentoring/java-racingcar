package racingcar.domain;

public class AttemptNumber {
	private static final String MIN_ATTEMPT_NUMBER_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";
	private static final String ATTEMPT_NUMBER_IS_NOT_INTEGER = "시도 횟수는 숫자여야 한다.";
	private static final int MIN_ATTEMPT_NUMBER = 1;
	private int attemptNumber;

	public AttemptNumber(String attemptNumber) {
		validateNumberIsNotInteger(attemptNumber);
		validateNumberRange(attemptNumber);
		this.attemptNumber = getAttemptNumberToInteger(attemptNumber);
	}

	private void validateNumberIsNotInteger(String attemptNumber) {
		try {
			Integer.parseInt(attemptNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_IS_NOT_INTEGER);
		}
	}

	private void validateNumberRange(String attemptNumber) {
		int attemptNumberToInteger = getAttemptNumberToInteger(attemptNumber);
		if (attemptNumberToInteger < MIN_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(MIN_ATTEMPT_NUMBER_MESSAGE);
		}
	}

	private static int getAttemptNumberToInteger(String attemptNumber) {
		return Integer.parseInt(attemptNumber);
	}

	public int getAttemptNumber() {
		return this.attemptNumber;
	}
}
