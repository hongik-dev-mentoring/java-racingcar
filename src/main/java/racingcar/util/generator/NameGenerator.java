package racingcar.util.generator;

import java.util.Arrays;
import java.util.List;

public class NameGenerator {
	private static final String SEPARATE_BY_COMMA = ",";

	public static List<String> generateCarNames(String carNames) {
		return Arrays.asList(carNames.split(SEPARATE_BY_COMMA));
	}
}
