import java.util.ArrayList;

public class RacingCarInputException {
	private static final int MAX_LENGTH = 5;

	public static void isEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("이름을 입력해주세요.");
		}
	}

	public static void isNull(String input) {
		if (input == null) {
			throw new IllegalArgumentException("다시 입력해주세요.");
		}
	}

	public static void isLong(ArrayList<String> strings, String[] input) {
		for (String s : input) {
			if (s.length() > MAX_LENGTH) {
				throw new IllegalArgumentException("5이하의 문자열을 입력하세요.");
			}
			strings.add(s);
		}
	}

	public static void isPositive(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("1회 이상의 수를 입력하세요.");
		}
	}
}
