package racingcar.util.validator;

import java.util.Arrays;
import java.util.List;

public class NameValidator {
	private static final int MIN_LENGTH_CAR_NAME = 1;
	private static final int MAX_LENGTH_CAR_NAME = 5;
	private static final String SEPARATE_BY_COMMA = ",";
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 1자 이상 5자 이하여야 합니다.";
	private static final String EMPTY_CAR_NAME_MESSAGE = "자동차의 이름은 비어있을 수 없습니다.";
	private static final String NULL_CAR_NAME_MESSAGE = "자동차의 이름은 NULL일 수 없습니다.";
	private static final String DUPLICATE_CAR_NAME_MESSAGE = "자동차의 이름은 중복일 수 없습니다.";

	public static void validateCarNames(String carNames) {
		checkCarNameIsNull(carNames);
		checkCarNameIsEmpty(carNames);
		checkCarNameIsDuplicate(carNames);
	}

	public static void validateCarName(String carName) {
		checkCarNameIsNull(carName);
		checkCarNameIsEmpty(carName);
		checkCarNameLength(carName);
	}

	private static void checkCarNameIsNull(String carName) {
		if (carName == null) {
			throw new IllegalArgumentException(NULL_CAR_NAME_MESSAGE);
		}
	}

	private static void checkCarNameIsEmpty(String carName) {
		if (isBlank(carName)) {
			throw new IllegalArgumentException(EMPTY_CAR_NAME_MESSAGE);
		}
	}

	private static boolean isBlank(String carName) {
		return carName.isEmpty() || carName.trim().isEmpty();
	}

	private static void checkCarNameIsDuplicate(String carNames) {
		List<String> carNameList = Arrays.asList(carNames.split(SEPARATE_BY_COMMA));
		if (carNameList.size() != carNameList.stream().distinct().count()) {
			throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
		}
	}

	private static void checkCarNameLength(String carName) {
		if (carName.length() < MIN_LENGTH_CAR_NAME || carName.length() > MAX_LENGTH_CAR_NAME) {
			throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
		}
	}
}
