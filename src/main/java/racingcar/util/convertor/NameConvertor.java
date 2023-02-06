package racingcar.util.convertor;

import java.util.Arrays;
import java.util.List;

public class NameConvertor {
	private static final String SEPARATE_BY_COMMA = ",";

	public static List<String> convertCarNames(String carNames) {
		return Arrays.asList(carNames.split(SEPARATE_BY_COMMA));
	}
}
