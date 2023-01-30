package racingcar.util.validator;

import java.util.List;
import java.util.stream.Collectors;

public class NameValidator {
	private static final int MIN_LENGTH_CAR_NAME = 1;
	private static final int MAX_LENGTH_CAR_NAME = 5;
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 1자 이상 5자 이하여야 합니다.";
	private static final String CAR_NAME_NOT_EXIST_MESSAGE = "자동차의 이름이 존재하지 않습니다.";
	private static final String DUPLICATE_CAR_NAME_MESSAGE = "자동차의 이름은 중복일 수 없습니다.";

	public static void validateCarNames(List<String> names) {
		validateTheNumberOfCarNames(names);
		validateDuplicateCarNames(names);
		validateNameLength(names);
	}

	private static void validateDuplicateCarNames(List<String> names) {
		List<String> uniqueNames = names.stream()
			.distinct()
			.collect(Collectors.toList());
		if (names.size() != uniqueNames.size()) {
			throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
		}
	}

	private static void validateTheNumberOfCarNames(List<String> names) {
		if (names == null || isBlank(names)) {
			throw new IllegalArgumentException(CAR_NAME_NOT_EXIST_MESSAGE);
		}
	}

	private static boolean isBlank(List<String> names) {
		return names.stream()
			.anyMatch(String::isBlank);
	}

	private static void validateNameLength(List<String> names) {
		if (hasInvalidNameLength(names)) {
			throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
		}
	}

	private static boolean hasInvalidNameLength(List<String> names) {
		return names.stream()
			.anyMatch(name -> name.length() < MIN_LENGTH_CAR_NAME
				|| name.length() > MAX_LENGTH_CAR_NAME);
	}
}
