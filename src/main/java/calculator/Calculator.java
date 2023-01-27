package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String SPLIT_REGEX = "[,:]";
	private static final String CUSTOM_SPLIT_REGEX = "//(.)\\n(.*)";

	public static int splitAndSum(String input) {
		if (isEmpty(input)) {
			return 0; // 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
		}
		return getSum(split(input));
	}

	private static int getSum(String[] inputs) {
		int sum = 0;
		for (String input : inputs) {
			int number = Integer.parseInt(input);
			sum += number;
		}
		return sum;
	}

	private static String[] split(String input) {
		Matcher matcher = getMatcher(input);
		if (isCustom(matcher)) { // 커스텀 구분자를 사용한다면
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
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
