package racingcar.domain;

public class Name {
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 1자 이상 5자 이하여야 합니다.";
	private static final String CAR_NAME_NOT_EXIST_MESSAGE = "자동차의 이름이 존재하지 않습니다.";
	private static final int CAR_NAME_LENGTH_MAX = 5;
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
		if (name.length() > CAR_NAME_LENGTH_MAX) {
			throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
		}
	}

}
