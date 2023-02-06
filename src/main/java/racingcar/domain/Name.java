package racingcar.domain;

public class Name {
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 1자 이상 5자 이하여야 합니다.";
	private static final String CAR_NAME_NOT_EXIST_MESSAGE = "자동차의 이름이 존재하지 않습니다.";
	private static final int MIN_LENGTH_CAR_NAME = 1;
	private static final int MAX_LENGTH_CAR_NAME = 5;
	private final String name;

	public Name(String name) {
		this.name = name;
		validateTheNumberOfCarName(name);
		validateCarNameLength(name);
	}

	public String getValue() {
		return name;
	}

	private void validateTheNumberOfCarName(String name) {
		if (name == null || isBlank(name)) {
			throw new IllegalArgumentException(CAR_NAME_NOT_EXIST_MESSAGE);
		}
	}

	private boolean isBlank(String name) {
		return name.isBlank();
	}

	private void validateCarNameLength(String name) {
		if (name.length() > MAX_LENGTH_CAR_NAME
			|| name.length() < MIN_LENGTH_CAR_NAME) {
			throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
		}
	}

}
