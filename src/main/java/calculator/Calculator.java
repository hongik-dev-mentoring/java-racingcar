package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String SPLIT_REGEX = "[,:]";
	private static final String CUSTOM_SPLIT_REGEX = "//(.)\\n(.*)";
	private static final int DELIMITER_NUMBER = 1;
	private static final int INPUT_GROUP = 2;

	public static int splitAndSum(String input) {
		if (isEmpty(input)) {
			return 0; // 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
		}
		return getSum(split(input));
	}

	private static int getSum(String[] inputs) {
		checkInputIsNegative(inputs);

		return Arrays.stream(inputs)
			.mapToInt(Integer::parseInt)
			.reduce(0, Integer::sum);
	}

	private static void checkInputIsNegative(String[] inputs) {
		for (String input : inputs) {
			if (getParseInt(input) < 0) {
				throw new RuntimeException();
			}
		}
	}

	private static int getParseInt(String input) {
		return Integer.parseInt(input);
	}

	private static String[] split(String input) {
		Matcher matcher = getMatcher(input);
		if (isCustom(matcher)) { // 커스텀 구분자를 사용한다면
			String customDelimiter = matcher.group(DELIMITER_NUMBER);
			return matcher.group(INPUT_GROUP).split(customDelimiter);
		}
		return input.split(SPLIT_REGEX);
	}

	private static boolean isCustom(Matcher matcher) {
		return matcher.find();
	}

	private static Matcher getMatcher(String input) {
		return Pattern.compile(CUSTOM_SPLIT_REGEX).matcher(input);
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}
}
