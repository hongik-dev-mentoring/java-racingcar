package calculator;

public class Calculator {

	private static final String SPLIT_REGEX = "[,:]";

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
		return input.split(SPLIT_REGEX);
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}
}
